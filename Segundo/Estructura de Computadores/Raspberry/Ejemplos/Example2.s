        .set  GPBASE,   0x3F200000
        .set  GPFSEL0,  0x00
	.set  GPFSEL1,  0x04
        .set  GPSET0,   0x1c
	.set  GPLEV0,   0x34
.text
        ldr   r0, =GPBASE
/* guia bits            xx999888777666555444333222111000*/
        mov   r1, #0b00001000000000000000000000000000
        str   r1, [r0, #GPFSEL0]  @ Configura como salida GPIO9 y como entrada GPIO2 y GPIO3
	mov   r1, #0b00000000000000000000001000000000
        str   r1, [r0, #GPSET0]   @ Enciende GPIO9
	mov   r4, #0b00000000000000000000000000000001
        str   r4, [r0, #GPFSEL1]  @ Configura como salida GPIO10 
	mov   r4, #0b00000000000000000000010000000000
        str   r4, [r0, #GPSET0]   @ Enciende GPIO10
	mov   r2, #0b00000000000000000000000000000100
	mov   r3, #0b00000000000000000000000000001000
bucle:
	ldr   r5, [r0, #GPLEV0]
	tst   r5, r2
	beq   luz1
bucle2:
	ldr   r5, [r0, #GPLEV0]
	tst   r5, r3
	beq   luz2
	
	b bucle

luz1:	
/* guia bits         10987654321098765432109876543210*/
        str   r1, [r0, #GPSET0]   @ Enciende GPIO9
        str   r4, [r0, #GPCRL0]   @ Apaga GPIO10
	b bucle
luz2:
/* guia bits         10987654321098765432109876543210*/
        str   r4, [r0, #GPSET0]   @ Enciende GPIO9
        str   r1, [r0, #GPCRL0]   @ Apaga GPIO10
	b bucle
infi:	b     infi
