
.data
tam:   .word 8
datos: .word 2, 4, 6, 8, -2, -4, -6, -7
res:   .word 0
.text
.global main

main:
ldr r0, =tam
ldr r1, [r0]
ldr r2, =datos
ldr r0, =res
ldr r3, [r2]

bucle:
	cmp r1, #0
	beq salir

	ldr r4, [r2], #4
	sub r1, #1
	cmp r4, r3
	bgt ir

	b bucle
	
ir:
	mov r3, r4
	b bucle

salir:
	str r3, [r0]
	bx lr
