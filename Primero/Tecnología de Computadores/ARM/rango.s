
.data
len:        .word 8
datos:      .word 8,-3,4,-7,9,-7,6,-1
res:        .word 0
 
.text
.global main
main:
ldr r0, =len
ldr r1, [r0]
ldr r2, =datos
ldr r0, =res
ldr r3, [r2]
ldr r4, [r2]

bucle:
	cmp r1, #0
	beq salir
	
	ldr r5, [r2], #4
	sub r1, #1
	cmp r5, r3
	bgt ir1
	cmp r5, r4
	blt ir2
	
	b bucle
	
ir1:
	mov r3,r5
	b bucle
ir2:
	mov r4,r5
	b bucle
		
salir:
	sub r5, r3, r4
	str r5, [r0]
	bx lr