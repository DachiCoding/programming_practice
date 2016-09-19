x=set('abcde')
y=set('bdxyz')
print x
print y
print " 'e' in x is",'e' in x
print x-y
print x|y
print x&y
print x^y
z=x.intersection(y)
print z
z.add('SPAM')
print z
z.update(set(['X','Y']))
print z
z.remove('b')
print z
z.union([3,4])
print z
z.issubset(range(-5,5))
print z
