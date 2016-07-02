import socket

ClientSock=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
port=8081
host="localhost"
while True:
 msg=raw_input()
 ClientSock.sendto(msg,(host,port))

