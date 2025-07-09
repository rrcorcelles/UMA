.data
tam: .word 10
vector: .word 1, 2, 3, 4, 1, 2, 1, 2, 5, 6
val: .word 1
res: .word 0
.text

	push {lr}
	ldr r0, =vector 
	ldr r1, =tam  
	ldr r1, [r1] 
	ldr r2, =val
	ldr r2, [r2] 
 	bl count 
	ldr r1, =res
 	str r0, [r1] 
 	pop {lr}
 	bx lr

count: push {r4}
	mov r4, #0
loop:
	cmp r1, #0
	beq salir
	ldr r3, [r0], #4
	sub r1, #1
	cmp r2, r3
	beq ir
	b loop
ir: 	
	add r4, #1
	b loop
salir:
	mov r0, r4
	pop {r4}
	bx lr