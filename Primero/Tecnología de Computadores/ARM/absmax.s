.data
mytam:      .word 8
myvect:     .word 8,-3,4,-2,5,7,6,1
myres:      .word 0
 
.text
.global main
main:       push {lr}
            ldr r0, =myvect
            ldr r1, =mytam
            ldr r1, [r1]
            bl absmax
            ldr r1, =myres
            str r0, [r1]
            pop {lr}
            mov pc, lr
 
abs:        mov r1, #0
            cmp r0, r1
            sublt r0, r1, r0
            mov pc, lr
                 
absmax:		push {r4-r5,lr}
			mov r4, r0
			ldr r5, [r4], #4
			mov r0, r5
			push {r1}
			bl abs
			pop {r1}
			mov r5, r0
			
bucle:		cmp r1, #0
			beq salir
			push {r1}
			ldr r0, [r4], #4
			bl abs
			cmp r5, r0
			movlt r5, r0
			pop {r1}
			sub r1, #1
			b bucle

salir: 		mov r0, r5
			pop {r4-r5,lr}
			bx lr
			
			
			