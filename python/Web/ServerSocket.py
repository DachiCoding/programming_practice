import socket

ServerSock=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
ServerSock.bind(("",8081))
while True:
 data,addr=ServerSock.recvfrom(1024)
 print "Received:",data,"from",addr


