.data

res: .word 0

cadena: .asciz "Hola, esto es una prueba"

char: .ascii "a"


.text
 push {lr}
 ldr r0, =cadena 
 ldr r1, =char 
 ldrb r1, [r1] 
 bl chcount 
 ldr r1, =res 
 str r0, [r1] 
 pop {lr}
 bx lr

chcount: 
	push {r4-r5}
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
	pop {r4-r5}
	bx lr
