	.set GPBASE,  0x3F200000
	.set GPFSEL0, 0x00
	.set  GPFSEL1,  0x04
	.set  GPFSEL2,  0x08
	.set GPSET0,  0x1c
	.set GPCLR0,  0x28
	.set STBASE,  0x3F003000
	.set STCLO,   0x04

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
	mov   r5, #0b00001000000000000000000000000000
	str   r5, [r4, #GPFSEL0]  @ Configura como salida GPIO9 y como entrada GPIO2 y GPIO3
	ldr   r6, =0b00000000001000000000000000001001
        str   r6, [r4, #GPFSEL1]  @ Configura como salida GPIO10 ,11,17
	ldr   r7, =0b00000000001000000000000001000000
        str   r7, [r4, #GPFSEL2]  @ Configura como salida GPIO22 ,27
	mov   r5, #0b00000000000000000000001000000000
	ldr  r6,     =0b00000000000000100000110000000000
	ldr r7,      =0b00001000010000000000000000000000
	ldr   r0, =STBASE 	 
	ldr   r1, =1000000
	ldr   r2, = 500000
	ldr   r3, = 250000
bucle:
	bl espera
	str r5, [r4, #GPSET0]
	str r6, [r4, #GPSET0] 
	str r7, [r4, #GPSET0]  
	bl espera
	str r5, [r4, #GPCLR0]
	str r6, [r4, #GPCLR0]
	str r7, [r4, #GPCLR0]
	bl espera2
	str r5, [r4, #GPSET0]
	str r6, [r4, #GPSET0] 
	str r7, [r4, #GPSET0]  
	bl espera2
	str r5, [r4, #GPCLR0]
	str r6, [r4, #GPCLR0]
	str r7, [r4, #GPCLR0]
	bl espera3
	str r5, [r4, #GPSET0]
	str r6, [r4, #GPSET0] 
	str r7, [r4, #GPSET0]  
	bl espera3
	str r5, [r4, #GPCLR0]
	str r6, [r4, #GPCLR0]
	str r7, [r4, #GPCLR0]
	b  bucle
	
espera:	
	push {r4, r5}
	ldr r4, [r0, #STCLO]
	add r4, r1
ret1:	
	ldr r5, [r0, #STCLO]
	cmp r5, r4
	blo ret1
	pop {r4, r5}
	bx lr
espera2:	
	push {r4, r5}
	ldr r4, [r0, #STCLO]
	add r4, r2
ret2:	
	ldr r5, [r0, #STCLO]
	cmp r5, r4
	blo ret2
	pop {r4, r5}
	bx lr
espera3:	
	push {r4, r5}
	ldr r4, [r0, #STCLO]
	add r4, r3
ret3:	
	ldr r5, [r0, #STCLO]
	cmp r5, r4
	blo ret3
	pop {r4, r5}
	bx lr	
infi:	b     infi