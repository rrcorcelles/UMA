.data
tam:  .word 8
vect: .word 64,25,16,17,32,56,48,87
res:  .word 0

.text
.global main
main: push {r4, lr}
      ldr r0, =vect @ Cargamos direccion del vector en r0
      ldr r1, =tam
      ldr r1, [r1] @ Cargamos longitud del vector en r1
      bl vecm16 @ Invocamos funcion
      ldr r4, =res @ Cargamos la direccion de res en r4
      str r0, [r4] @ Guardamos el resultado en res
      pop {r4, lr}
      bx lr @ Finalizamos el programa

m16: @ funcion que dice si un numero es multiplo de 16
     @(Hay que llamarla desde vecm16 y no se puede modificar)
      and r0, r0, #0x0000000F
      bx lr

vecm16: push {lr}
		mov r2, r0
		mov r4, #0
		
bucle:	cmp r1, #0
		beq salir
		ldr r0, [r2], #4
		push {r0-r3,lr}
		bl m16
		cmp r0, #0
		pop {r0-r3,lr}
		addeq r4, r4, #1
		sub r1, #1
		b bucle

salir:
		mov r0, r4
		pop {lr}
		bx lr