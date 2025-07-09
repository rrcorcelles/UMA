.data

cadena: .asciz "Hola, esto es un a prueba"

res: .ascii ""

.text

 push {lr}

 ldr r0, =cadena 

  bl common 
 ldr r1, =res

 strb r0, [r1] 

 pop {lr}

 bx lr

common: push {r4-r7, lr}
	mov r2, r0
	ldrb r4, [r2]
	mov r7, #0

bucle1:
	cmp r4, #0
	beq salir1
	ldrb r1, [r2], #1
	ldrb r4, [r2], #1
	push {r0-r2,lr}
	bl chcount
	cmp r0, r7
	mov r6, r0
	pop {r0-r2,lr}
	movgt r5, r1
	movgt r7, r6
	b bucle1
	
salir1:
	mov r0, r5
	pop {r4-r7, lr}
	bx lr

	
		
chcount: push {r4-r5, lr}
	mov r5, #0
	ldrb r4, [r0]
	
bucle:
	cmp r4, #0
	beq salir
	ldrb r4, [r0], #1
	cmp r1, r4
	addeq r5, #1
	b bucle
	
salir:
	mov r0, r5
	pop {r4-r5, lr}
	bx lr