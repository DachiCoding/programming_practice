# while True:
#  print "Ctrl+C to stop me"

# x='spam'
# while x:
# 	print x
# 	x=x[1:]

# x=10
# while x:
# 	x-=1
# 	if x%2 !=0:
# 		continue
# 	print x

# while True:
# 	name=raw_input('Enter name: ->')
# 	if name == 'stop':break
# 	age=raw_input('Enter age: ->')
# 	print 'hello',name,'=>',int(age)**2

# for x in ['spam','eggs','ham']:
# 	print x

# prod=1
# for item in [1,2,3,4]:
# 	prod*=item
# print prod
# 
# T=[(1,2),(3,4),(5,6)]
# for (a,b) in T:
# 	print(a,b)

# D=dict(a=1,b=2,c=3)
# for key in D.keys():
# 	print D.get(key),D[key]

# tuple=[((1,2),3),((4,5),6)]
# for (a,b) in tuple:
# 	print (a,b)

# items=["aaa",111,(4,5),2.01]
# tests=[(4,5),3.14,'bbb',323]
# d=dict(zip(items,tests))
# for x in d.items():
#	print x

# 
# for key in tests:
# 	for item in items:
# 		if item==key:
# 			print(key,"was found")
# 			break
# 	else:
# 		print(key,"not found")
# 
# items_tests=zip(items,tests)
# for item in items_tests:
# 	print item 

# print list(range(-5,5))
# print list(range(-5,5,2))

s='spam'
for (idx,ele) in enumerate(s):
	print ele,'idx:-->',idx
