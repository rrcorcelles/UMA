
.data
tam: .word 8
pos: .word 0
vector: .word 2, -3, 6, 5, -4, 8, 1, 0
val: .word -4

.text
.global main
main:
ldr r0, =tam
ldr r1, [r0]
ldr r2, =vector
ldr r0, =val
ldr r3, [r0]
ldr r0, =pos
mov r4, #0
bucle:
	cmp r1, #0
	beq acabar2
	ldr r5, [r2], #4
	sub r1, #1
	cmp r3, r5
	beq salir
	add r4, #1
	
	b bucle
	
acabar2:
	mov r4, #-1
	b salir
salir:
	str r4, [r0]
	bx lr
	