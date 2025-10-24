.set    GPBASE, 0x3f200000
.set    GPFSEL0, 0x00
.set    GPFSEL1, 0x04
.set    GPSET0, 0x1c
.set    GPCLR0, 0x28

.text
	ldr r0, =GPBASE
/* guia bits       xx999888777666555444333222111000 */
	mov r1, #0b00000000000000000000000000001000
	str r1, [r0, #GPFSEL1]
/* guia bits          10987654321098765432109876543210 */
	mov r1, #0b00000000000000000000100000000000
	str r1, [r0, #GPSET0]
        str r1, [r0, #GPCLR0]	
infi:   b   infi
@Lo que ocurre es que al no haber tiempo entre el encendido y el apagado, se mantiene apagado todo el rato.