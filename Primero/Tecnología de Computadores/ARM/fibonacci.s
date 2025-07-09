.data
n: .word 5
.text
fib:	
		push {r1-r3, lr}
		mov r4, #0
		mov r1, #0
		mov r2, #1
		ldr r0, =n
bucle: 
		cmp r0, #0
		beq salir
		add r3, r1, r2
		mov r1, r2
		mov r2, r3
		sub r0, #1
		b bucle
		
salir:
		mov r0, r3
		pop {r1-r3, lr}
		mov pc, lr