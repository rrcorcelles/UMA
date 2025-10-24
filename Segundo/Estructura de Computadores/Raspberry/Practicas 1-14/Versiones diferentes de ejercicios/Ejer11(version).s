.include "inter.inc"
.text
	mrs r0, cpsr
	mov r0, #0b11010011 
	msr spsr_cxsf, r0
	add r0, pc, #4
	msr ELR_hyp, r0
	eret
	
	mov    r0, #0
	ADDEXC 0x18, irq_handler
	
	mov     r0, #0b11010010   
	msr     cpsr_c, r0		
	mov     sp, #0x8000
	
	mov     r0, #0b11010011
	msr     cpsr_c, r0		
	mov     sp, #0x8000000
	
	ldr    r0, =GPBASE
	ldr    r1, =0b00001000000000000000000000000000
	str    r1, [r0, #GPFSEL0]   
	ldr    r1, =0b00000000001000000000000000001001
	str    r1, [r0, #GPFSEL1]   
	ldr    r1, =0b00000000001000000000000001000000
	str    r1, [r0, #GPFSEL2]  
	mov r3, #1
	ldr    r0, =STBASE
	ldr    r1, [r0, #STCLO]
	add    r1, #0x50000        
	str    r1, [r0, #STC1]
	
	ldr    r0, =INTBASE         
	mov    r1, #0b0010
	str    r1, [r0, #INTENIRQ1 ]
	
	mov    r0, #0b01010011      
	msr    cpsr_c, r0
buc:	b      buc

irq_handler:
	push   {r0-r2}
	
	cmp r3, #1
	beq luz1
	cmp r3, #2
	beq luz2
	cmp r3, #3
	beq luz3
	cmp r3, #4
	beq luz4
	cmp r3, #5
	beq luz5
	cmp r3, #6
	beq luz6
	cmp r3, #7
	beq luz7


encendido:

	ldr    r0, =GPBASE
	ldr    r1, =onoff
	ldr    r2, [r1]			@ Load variable
	eors   r2, #1			@ Xor with 1 to test if it is on or off
	str    r2, [r1]
	
	strne  r4, [r0, #GPSET0]	@ Turn on if variable is 1
	streq  r5, [r0, #GPCLR0]	@ Turn on if variable is 1
	
	addeq r3, #1
	cmp r3, #8
	subeq r3, #7
	
	ldr    r0, =STBASE
        mov    r1, #0b0010
        str    r1, [r0, #STCS]		@ Clear timer interrupt
	ldr    r1, [r0, #STCLO]
	add    r1, #0x50000
	str    r1, [r0, #STC1]		@ 4.19 seconds
	pop    {r0-r2}
	subs   pc, lr, #4

onoff: .word  0				@ Variable stored after the program code


luz1:
mov    r4, #0b00000000000000000000001000000000
mov    r5, #0
b encendido

luz2:
ldr  r4,     =0b00000000000000000000010000000000
b encendido

luz3:
ldr  r4,     =0b00000000000000000000100000000000
b encendido

luz4:
ldr  r4,     =0b00000000000000100000000000000000
b encendido

luz5:
ldr r4,      =0b00000000010000000000000000000000
b encendido

luz6:
ldr r4,      =0b00001000000000000000000000000000
b encendido

luz7:
ldr r5,      =0b00001000010000100000111000000000
b encendido