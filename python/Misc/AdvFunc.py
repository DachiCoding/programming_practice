# # Recursive
# def mysum(L):
# 	if not L:
# 		return 0
# 	else:
# 		return L[0]+mysum(L[1:])
# 
# print mysum([1,2,3,4,5])
# 
# # Non-Linear Recursive
# def sumtree(L):
# 	tot=0
# 	for x in L:
# 		if not isinstance(x,list):
# 			tot+=x
# 		else:
# 			tot+=sumtree(x)
# 	return tot
# 
# print sumtree([1,[2,34],2,[4,[5,6]]])
# 
# # Indirect Call
# def echo(message):
# 	print message
# 
# echo('Direct call')
# x=echo
# x('Indirect call')

# Lambda
# f=lambda x,y,z:x+y+z
# print f(2,3,4)
# 
# x=(lambda a="fee",b="fie",c="foe":a+b+c)
# print x("wee")
# 
# L=[lambda x: x**2,
#    lambda x: x**3,
#    lambda x: x**4]
# 
# for f in L:
# 	print(f(2))

# # Map
# counters=[1,2,3,4]
# updated=[]
# for x in counters:
# 	updated.append(x+10)
# print updated
# 
# def inc(x):return x+10
# print map(inc,counters)
# 
# # Filter
# print list(filter((lambda x:x>0),range(-5,5)))
# print list(filter((lambda x:x<0),range(-5,5)))

# Practice
addlist=(lambda x,y:x+y)
print map(addlist,[1,2],[3,4])
print [x+y for x in 'spam' for y in 'SPAM']

