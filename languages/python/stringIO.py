from io import StringIO
f = StringIO()
f.write('hello')
f.write(' ')
f.write('world')
print(f.getvalue())
