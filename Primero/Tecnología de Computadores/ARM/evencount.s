
 .data
 tam:        .word 8
 vect:       .word 64,25,9,23,56,77,87,100
 res:        .word 0

 .text
 .global main
 main:       push {lr}
             ldr r0, =vect          
             ldr r1, =tam          
             ldr r1, [r1]           
             ldr r4, =res          
             bl evencount          
             str r0, [r4]          
             pop {lr}
             bx lr                
            
 iseven:     
             mov r1, r0
             mov r2, #1
             and r3, r2, r1
             eor r0, r3, #1
             bx lr
  
 evencount:
			push {r4, lr}
			mov r2, r0
			mov r4, #0
			
	bucle:	
			cmp r1, #0
			beq salir
			ldr r0, [r2], #4
			push {r0-r3, lr}
			bl iseven
			cmp r0, #1
			pop {r0-r3, lr}
			addeq r4, #1
			sub r1, #1
			b bucle
			
	salir:
			mov r0, r4
			pop {r4, lr}
			mov pc, lr

	
			
			