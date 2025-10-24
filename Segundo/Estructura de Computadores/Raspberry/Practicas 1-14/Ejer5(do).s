	.set GPBASE,  0x3F200000
	.set GPFSEL0, 0x00
	.set GPSET0,  0x1c
	.set GPCLR0,  0x28
	.set STBASE,  0x3F003000
	.set STCLO,  0x04
.text	
	mrs r0, cpsr
	mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
	msr spsr_cxsf, r0
	add r0, pc, #4
	msr ELR_hyp, r0 
	eret
	mov   r0, #0b11010011
	msr   cpsr_c, r0
	mov   sp, #0x08000000
	ldr   r4, =GPBASE
	mov   r5, #0b00000000000000000001000000000000
	str   r5, [r4, #GPFSEL0] 
	mov   r5, #0b00000000000000000000000000010000
	ldr   r0, =STBASE 	 
	ldr   r1, =1914
bucle:	bl    espera		 
	str   r5, [r4, #GPSET0]  
	bl    espera		 
	str   r5, [r4, #GPCLR0]  
	b     bucle
espera:	push  {r4, r5}	         
	ldr   r4, [r0, #STCLO]	 
	add   r4, r1		 
ret1:	ldr   r5, [r0, #STCLO]	 
	cmp   r5, r4		 
	blo   ret1		 
	pop   {r4, r5}		
	bx    lr		 
