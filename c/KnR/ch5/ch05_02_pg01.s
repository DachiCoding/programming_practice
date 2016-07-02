	.section	__TEXT,__text,regular,pure_instructions
	.globl	_swap
	.align	4, 0x90
_swap:                                  ## @swap
## BB#0:
	pushl	%ebp
	movl	%esp, %ebp
	pushl	%esi
	movl	8(%ebp), %eax
	movl	(%eax), %ecx
	movl	12(%ebp), %edx
	movl	(%edx), %esi
	movl	%esi, (%eax)
	movl	%ecx, (%edx)
	popl	%esi
	popl	%ebp
	ret


.subsections_via_symbols
