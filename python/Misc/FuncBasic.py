# Times Function
# def times(x,y):
# 	return x * y
# 
# print times(2,4)
# print 'spam'

# Intersect Function
# def intersect(seq1,seq2):
# 	res=[]
# 	for x in seq1:
# 		if x in seq2:
# 			res.append(x)
# 	return res
# 
# list1=range(5)
# list2=range(-3,3)
# print list1
# print list2
# print intersect(list1,list2)

# print dir(__builtins__)

# Global Test
x=88
def func():
	global x
	x=99

func()
print x
