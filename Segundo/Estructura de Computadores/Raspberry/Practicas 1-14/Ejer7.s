        .set  GPBASE,   0x3F200000
        .set  GPFSEL0,  0x00  
        .set  GPSET0,   0x1c
	.set  GPCLR0,   0x28
	.set  GPLEV0,   0x34
	.set STBASE,  0x3F003000
	.set STCLO,  0x04
.text
	mrs r0, cpsr
	mov r0, #0b11010011 @Modo SVC, FIQ&IRQ desact
	msr spsr_cxsf, r0
	add r0, pc, #4
	msr ELR_hyp, r0
	eret
	
	mov r0, #0b11010011
	msr cpsr_c, r0
	mov sp, #0x08000000
	
	ldr r0, = STBASE
	ldr r2, = GPBASE

	mov r5, #0b00000000000000000001000000000000    
	str r5, [r2, #GPFSEL0]
	
	mov   r3, #0b00000000000000000000000000000100  
	mov   r4, #0b00000000000000000000000000001000  
	mov   r5, #0b00000000000000000000000000010000

bucle:
	ldr r6, [r2, #GPLEV0]
	tst r6, r3
	beq sonido1
	tst r6, r4
	beq sonido2
	b bucle
	
sonido1:
	ldr r1, = 1908
	bl espera
	str r5, [r2,#GPSET0]
	bl espera
	str r5, [r2, #GPCLR0]
	b bucle
	
sonido2:
	ldr r1, = 1278
	bl espera
	str r5, [r2,#GPSET0]
	bl espera
	str r5, [r2, #GPCLR0]
	b bucle
	
espera: push {r2, r5}
	ldr r2, [r0, #STCLO]
	add r2, r1
	
ret: 
	ldr r5, [r0, #STCLO]
	cmp r5, r2
	blo ret
	pop {r2, r5}
	
bx lr

infi : b infi