def gensquares(N):
	for i in range(N):
		yield i**2

for i in gensquares(5):
	print i,':'

