import socket
serverName = socket.gethostname()
serverPort = 12000
print serverName
clientSocket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
message = raw_input('Input lowercase sentence: ')
clientSocket.sendto(message, (serverName, serverPort))
modifiedMessage, serverAddress = clientSocket.recvfrom(2048)
print modifiedMessage
clientSocket.close()
