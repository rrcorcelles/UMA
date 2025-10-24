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
	ldr    r2, =0b00000000001000000000000000001001
	str    r2, [r0, #GPFSEL1]   
	ldr    r3, =0b00000000001000000000000001000000
	str    r3, [r0, #GPFSEL2]   
	ldr    r0, =STBASE
	ldr    r1, [r0, #STCLO]
	add    r1, #0x400000        
	str    r1, [r0, #STC1]
	ldr    r0, =INTBASE         
	mov    r1, #0b0010
	str    r1, [r0, #INTENIRQ1 ]
	mov    r0, #0b01010011      
	msr    cpsr_c, r0
buc:	b      buc

irq_handler:
	push   {r0, r1, r2, r3}
	ldr    r0, =GPBASE
	mov    r1, #0b00000000000000000000001000000000
	ldr  r2,     =0b00000000000000100000110000000000
	ldr r3,      =0b00001000010000000000000000000000
	str    r1, [r0, #GPSET0]    
	str    r2, [r0, #GPSET0] 
	str    r3, [r0, #GPSET0] 
	pop    {r0, r1, r2, r3}
	subs   pc, lr, #4