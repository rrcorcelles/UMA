.include  "inter.inc"

.set RE, 1706
.set MI, 1515
.set FA, 1351
.set SOL, 1276
.set LA, 1136
.set SI, 1012
.set DO2, 956
.set RE2, 852
.text
	mrs r0, cpsr
	mov r0, #0b11010011 
	msr spsr_cxsf, r0
	add r0, pc, #4
	msr ELR_hyp, r0
	eret
	mov r0, #0
	ADDEXC 0x18, irq_handler
	ADDEXC 0x1c, fiq_handler
	
	mov    r0, #0b11010001
	msr    cpsr_c, r0		
	mov    sp, #0x4000
	mov    r0, #0b11010010
	msr    cpsr_c, r0		
	mov    sp, #0x8000
	mov    r0, #0b11010011
	msr    cpsr_c, r0		
	mov    sp, #0x8000000
	
	ldr       r0, =GPBASE
	ldr    r1, =0b00001000000000000001000000000000
        str    r1, [r0, #GPFSEL0]	
	
	ldr    r1, =0b00000000001000000000000000001001
        str    r1, [r0, #GPFSEL1]	
	
	ldr    r1, =0b00000000001000000000000001000000
        str    r1, [r0, #GPFSEL2]	
	
	ldr    r0, =STBASE
	ldr    r1, [r0, #STCLO]
	add    r1, #0x20000
	str    r1, [r0, #STC1]		
	
	ldr    r1, [r0, #STCLO]
	add r1, #2
	str r1, [r0, #STC3]
	
	ldr    r0, =INTBASE
	mov    r1, #0b0010
	str    r1, [r0, #INTENIRQ1]	
 	mov    r1, #0b10000011
	str    r1, [r0, #INTFIQCON]	
	mov    r0, #0b00010011
	msr    cpsr_c, r0		
buc:	b      buc

fiq_handler:
	push   {r0, r1, r2, r3}
        ldr    r0, =GPBASE
	ldr    r1, =onoff
	
	ldr    r2, [r1]			
	eors   r2, #2			
	str    r2, [r1]
	
	mov    r1, #0b00000000000000000000000000010000
	streq  r1, [r0, #GPCLR0]	
	strne  r1, [r0, #GPSET0]	
	
	ldr r0, =STBASE
	mov r1, #0b1000
	str r1, [r0, #STCS]
	ldr r2, =cont
	ldr r1, [r2]
	
	ldr r2, = notas
	ldr r3, [r2,r1]
	
	ldr r1, [r0, #STCLO]
	add r1, r3
	str r1, [r0,#STC3]
	
	pop    {r0, r1, r2, r3}
        subs   pc, lr, #4

irq_handler:
	push   {r0, r1, r2, r3}
	ldr    r0, =GPBASE
	ldr r3, = 0b0001000010000100000111000000000
	str r3, [r0, #GPCLR0]
	
	ldr r2, = cont
	ldr r1, [r2]
	
	add r1, #4
	cmp r1, #100
	subge r1, #100
	str r1, [r2]
	ldr r2, = desplazamiento
	ldr r1,[r2]
	
	add r1, #4
	cmp r1, #24
	subge r1, #24
	
	str r1,[r2]
	ldr r2, = arraysonido
	ldr r3, [r2,r1]
	
	strne  r3, [r0, #GPSET0]	
	ldr    r0, =STBASE
        mov    r1, #0b0010
        str    r1, [r0, #STCS]		
	ldr    r2, [r0, #STCLO]
	ldr    r1, = 500000
	add r2, r1
	str    r2, [r0, #STC1]		
	pop    {r0, r1, r2, r3}
	subs   pc, lr, #4
	
arraysonido: .word 0b0000000000000000000001000000000
	.word 0b0000000000000000000010000000000
	.word 0b0000000000000000000100000000000
	.word 0b0000000000000100000000000000000
	.word 0b0000000010000000000000000000000
	.word 0b0001000000000000000000000000000

onoff: .word 0x0		
desplazamiento: .word 0x0
cont: .word 0
notas: .word RE, RE, MI, RE, SOL, FA, RE, RE, MI, RE, LA, SOL, RE, RE, RE2, SI, SOL, FA, MI, DO2, DO2, SI, SOL, LA, SOL