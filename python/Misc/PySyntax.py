# while True:
#  reply=raw_input('Enter text: ')
#  if reply=='stop':
#   break
#  print(reply.upper())

while True:
 reply=raw_input('Enter text:')
 if reply=='stop':break
 try:
  num=int(reply)
 except:
  print 'Bad!'
 else:
  print int(reply)**2
print 'Bye'
