.data

tam: .word 11
vector1: .word 1, 2
vector2: .word 1, 2, 1, 2, 3, 2, 4, 1, 2, 2, 3
vector3: .word 0, 0

.text
 push {lr}
 ldr r0, =vector1 
 ldr r1, =vector2 
 ldr r2, =tam 
 ldr r2, [r2] 
 ldr r3, =vector3 
 bl histo 
 pop {lr}
 bx lr

histo: 
		push {r4-r6, lr}
		ldr r6, =0
		
bucle1: 
		cmp r6, #2
		beq salir1
		ldr r4, [r0], #4
		push {r0-r3, lr}
		mov r0, r1
		mov r1, r2
		mov r2, r4
		bl count
		mov r5, r0
		pop {r0-r3, lr}
		str r5, [r3], #4
		add r6, #1
		b bucle1
		
salir1:
		pop {r4-r6, lr}
		bx lr
		

count:	
	push {r4}
	mov r4, #0
bucle:
	cmp r1, #0
	beq salir
	ldr r3, [r0], #4
	sub r1, #1
	cmp r2, r3
	addeq r4, #1
	b bucle
salir:
	mov r0, r4
	pop {r4}
	bx lr
	