.text
.global main

cuad:
		push {r0, lr}
		cmp r0, #0
		bxeq lr
		sub r0, #1
		bl cuad
		pop {r1, lr}
		mul r1, r1, r1
		add r0, r1
		mov pc, lr