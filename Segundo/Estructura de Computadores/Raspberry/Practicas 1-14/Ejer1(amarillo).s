	.set  GPBASE,   0x3F200000
	.set  GPFSEL1,  0x04
        .set  GPSET0,   0x1c
	.set  GPCLR0,   0x28

.text
	ldr r0, =GPBASE

	mov r1, #0b00000000000000000000000000001000
	str r1, [r0, #GPFSEL1]
	mov r1, #0b00000000000000000000100000000000
	str r1, [r0, #GPSET0]

infi:   b   infi
