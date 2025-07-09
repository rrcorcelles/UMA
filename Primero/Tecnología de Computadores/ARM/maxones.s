.data
tam:           .word 8
vect:          .word 64,25,9,23,56,77,87,100
res:           .word 0
.text
.global main
main:    push {lr}
         ldr r0, =vect
         ldr r1, =tam        
         ldr r1, [r1]          
         ldr r4, =res          
         bl maxones            
         str r0, [r4]          
         pop {pc}              
        
ones:   
               mov r2, #0
         onesloop:
               and r3, r0, #1
               add r2, r2, r3
               lsrs r0, #1
               bne onesloop
               mov r0, r2
               bx lr
 
maxones:
		push {r5-r8,lr}
		mov r5, r0
		mov r6, #0
		mov r7, #0
		mov r8, #0
		
bucle:
		cmp r1, #0
		beq salir
		ldr r0, [r5], #4
		mov r8, r0
		push {r0-r3, lr}
		bl ones
		mov r0, r2
		cmp r0, r6
		movgt r6, r0
		movgt r7, r8
		pop {r0-r3, lr}
		sub r1, #1
		b bucle
		
salir:
		mov r0, r7
		pop {r5-r8,lr}
		bx lr
		