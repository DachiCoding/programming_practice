# Practicing map
def inc(x): 
    return x + 10

counters = [1,2,3,4]

#map(function,collection)
print list(map(inc,counters))   

#filter(function,condition)
print filter((lambda x: x % 2 == 0),range(-5,5))

#reduce(function,collection)

