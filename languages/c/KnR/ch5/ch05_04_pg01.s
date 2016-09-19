	.section	__TEXT,__text,regular,pure_instructions
	.globl	_alloc
	.align	4, 0x90
_alloc:                                 ## @alloc
## BB#0:
	pushl	%ebp
	movl	%esp, %ebp
	pushl	%edi
	pushl	%esi
	calll	L0$pb
L0$pb:
	popl	%edx
	movl	_allocp-L0$pb(%edx), %ecx
	movl	%ecx, %eax
	negl	%eax
	leal	(_allocbuf-L0$pb)+10000(%edx,%eax), %edi
	xorl	%eax, %eax
	movl	8(%ebp), %esi
	cmpl	%esi, %edi
	jl	LBB0_2
## BB#1:
	addl	%ecx, %esi
	movl	%esi, _allocp-L0$pb(%edx)
	movl	%ecx, %eax
LBB0_2:
	popl	%esi
	popl	%edi
	popl	%ebp
	ret

	.globl	_afree
	.align	4, 0x90
_afree:                                 ## @afree
## BB#0:
	pushl	%ebp
	movl	%esp, %ebp
	calll	L1$pb
L1$pb:
	popl	%eax
	movl	8(%ebp), %ecx
	leal	_allocbuf-L1$pb(%eax), %edx
	cmpl	%edx, %ecx
	jb	LBB1_3
## BB#1:
	leal	(_allocbuf-L1$pb)+10000(%eax), %edx
	cmpl	%edx, %ecx
	jae	LBB1_3
## BB#2:
	movl	%ecx, _allocp-L1$pb(%eax)
LBB1_3:
	popl	%ebp
	ret

.zerofill __DATA,__bss,_allocbuf,10000,0 ## @allocbuf
	.section	__DATA,__data
	.align	2                       ## @allocp
_allocp:
	.long	_allocbuf


.subsections_via_symbols
