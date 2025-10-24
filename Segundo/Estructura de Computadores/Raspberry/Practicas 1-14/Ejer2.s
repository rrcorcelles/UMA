        .set  GPBASE,   0x3F200000
        .set  GPFSEL0,  0x00
	.set  GPFSEL1,  0x04
        .set  GPSET0,   0x1c
	.set  GPCLR0,   0x28
	.set  GPLEV0,   0x34
.text
        ldr   r0, =GPBASE
/* guia bits         xx999888777666555444333222111000*/
        mov   r1, #0b00001000000000000000000000000000
        str   r1, [r0, #GPFSEL0]  
	mov   r1, #0b00000000000000000000001000000000
        str   r1, [r0, #GPSET0] 
	mov   r5,   #0b00000000000000000000000000000001
	str   r5, [r0, #GPFSEL1]  
	mov   r5, #0b00000000000000000000010000000000
        str   r5, [r0, #GPSET0] 
	mov   r2, #0b00000000000000000000000000000100
	mov   r3, #0b00000000000000000000000000001000
bucle:
	ldr   r4, [r0, #GPLEV0]
	tst   r4, r2
	beq   luz1
bucle1:
	ldr   r4, [r0, #GPLEV0]
	tst   r4, r3
	beq luz2
	b bucle
luz1:
	str   r1, [r0, #GPSET0] 
	str   r5, [r0, #GPCLR0]
        b bucle
luz2: 
        str   r5, [r0, #GPSET0]
	str   r1, [r0, #GPCLR0]
        b bucle
	
infi:	b     infi
