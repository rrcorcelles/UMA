.data
tam: .word 10
vector: .word 1, 2, 3, 4, 1, 2, 1, 2, 5, 6
val: .word 3
res: .word 0

.text
 push {lr}
 ldr r0, =vector 
 ldr r1, =tam 
 ldr r1, [r1] 
 ldr r2, =val
 ldr r2, [r2] 
 bl lesser 
 ldr r1, =res 
 str r0, [r1] 
 pop {lr}
 bx lr

lesser: 
	push {r4}
	mov r4, #0
	
bucle:
	cmp r1, #0
	beq salir
	ldr r3, [r0], #4
	cmp r3, r2
	addlt r4, #1
	sub r1, #1
	b bucle
	
salir:
	mov r0, r4
	pop {r4}
	bx lr