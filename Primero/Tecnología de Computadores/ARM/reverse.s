.data
vector1:  .word 1,2,3,4,5,6,7,8
vector2:  .word 0,0,0,0,0,0,0,0
len:      .word 8
 
.text
  push {lr}
  ldr r0, =vector1
  ldr r1, =len
  ldr r1, [r1]
  ldr r2, =vector2
  bl reverse
  pop {lr}
  bx lr
 
reverse:
	push {r0,r2}
	add r2, #28
loop:
	cmp r1, #0
	beq salir
	ldr r3, [r0], #4
	str r3, [r2], #-4
	sub r1, #1
	b loop
	
salir:
	pop {r0,r2}
	bx lr