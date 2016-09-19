import copy

# Referencing Test
# a=3
# b=a
# print "a=",a
# print "b=",b
# a='spam'
# print "a=",a
# print "b=",b

# Changable Object
# L1=[1,2,3]
# L2=L1
# print L1
# print L2
# L1[0]=24
# print L1
# print L2

# Copy
L1=[1,2,3]
L2=L1[:]
L3=copy.copy(L1)
print L1
print L2
print L3
