
.data
tam: .word 8
ocur: .word 0
vector: .word 2, -3, 6, 5, -4, 8, 2, 0
val: .word 2

.text
.global main
main:
ldr r0, =tam
ldr r1, [r0]
ldr r2, =vector
ldr r0, =val
ldr r3, [r0]
ldr r0, =ocur
mov r4, #0

bucle:
	cmp r1, #0
	beq salir
	ldr r5, [r2], #4
	sub r1, #1
	cmp r3, r5
	beq ir
	
	b bucle
	
ir:
	add r4, #1
	b bucle
	
salir:
	str r4, [r0]
	bx lr