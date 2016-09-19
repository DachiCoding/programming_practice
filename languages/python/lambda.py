# Practicing python lambda function

if __name__ == "__main__":

    f = lambda x, y ,z : x + y + z
    print f(2,3,4)

    x = (lambda a="fee", b="fie", c="foe": a + b + c)
    print x("wee")

    def knights():
        title = 'Sir'
        action = (lambda x: title + ' ' + x)
        return action

    act = knights()
    print act('robin')

    L = [lambda x : x ** 2,
         lambda x : x ** 3,
         lambda x : x ** 4]

    for f in L:
        print(f(2))
    
