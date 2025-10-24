	.include  "inter.inc"
.text
	mrs r0, cpsr
	mov r0, #0b11010011 
	msr spsr_cxsf, r0
	add r0, pc, #4
	msr ELR_hyp, r0
	eret
	
	mov r0, #0
	ADDEXC 0x18, irq_handler

	mov r0, #0b11010010
	msr cpsr_c, r0
	mov sp, #0x8000

	mov r0, #0b11010011
	msr cpsr_c, r0
	mov sp, #0x8000000
	
	ldr       r0, =GPBASE
	ldr    r1, =0b00001000000000000001000000000000
        str    r1, [r0, #GPFSEL0]	
	
	ldr    r1, =0b00000000001000000000000000001001
        str    r1, [r0, #GPFSEL1]	
	
	ldr    r1, =0b00000000001000000000000001000000
        str    r1, [r0, #GPFSEL2]	
	
	ldr    r0, =STBASE
	ldr    r1, [r0, #STCLO]
	add    r1, #2
	str    r1, [r0, #STC1]
	str    r1, [r0, #STC3]
	
	ldr    r0, =INTBASE
	mov    r1, #0b1010
	str    r1, [r0, #INTENIRQ1]	 
 	mov    r0, #0b01010011
	msr    cpsr_c, r0	
buc:	b      buc

irq_handler:
	push   {r0, r1, r2, r3}
	
	ldr    r0, =GPBASE
	ldr    r1, = STBASE
	ldr    r2, [r1, #STCS]
	ands r2, #0b0010
	beq sonido
	
	ldr r2, = arraysonido
	ldr r3, = 0b0001000010000100000111000000000
	str r3, [r0, #GPCLR0]
	
	ldr r1, = posicion
	ldr r3, [r1]
	ldr r2, [r3,r2]
	str r2, [r0, #GPSET0]
	
	add r3, #4
	cmp r3, #24
	subge r3, #24
	str r3, [r1]
	
	ldr    r0, =STBASE
        mov    r1, #0b0010
        str    r1, [r0, #STCS]		
	
	ldr    r1, [r0, #STCLO]
	ldr r2, = 200000
	add r1, r2
	str    r1, [r0, #STC1]	
	
	ldr r1, [r0, #STCS]
	ands r1, #0b0100
	beq final
	
sonido:
	ldr    r0, =STBASE
	ldr    r1, = GPBASE
	ldr    r2, =sonar
	ldr    r3, [r2]
	eors r3, #1
	str	r3, [r2]
	mov r3, #0b10000
	
	strne  r3, [r1, #GPSET0]	
	streq  r3, [r1, #GPCLR0]
	
	mov r1, #0b1000
	str r1, [r0, #STCS]	
	ldr r1,[r0, #STCLO]
	ldr r2, = 1136
	add r1, r2

	str r1, [r0, #STC3]
	
final:	
	pop    {r0, r1, r2, r3}
	subs   pc, lr, #4
	
sonar: .word 0
	
	
arraysonido: .word 0b0000000000000000000001000000000
	.word 0b0000000000000000000010000000000
	.word 0b0000000000000000000100000000000
	.word 0b0000000000000100000000000000000
	.word 0b0000000010000000000000000000000
	.word 0b0001000000000000000000000000000
	
posicion: .word 0
	
	
