# Learning Python Chpater 27
class Person:
 def __init__(self,name,job=None,pay=0):
  self.name=name
  self.job=job
  self.pay=pay

bob=Person('Bob smith')
sue=Person('Sue Jones',job='dev',pay=100000)
print(bob.name,bob.pay)
print(sue.name,sue.pay)

