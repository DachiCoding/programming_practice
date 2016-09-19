import smtplib
server=smtplib.SMTP('smtp.gmail.com',587)

server.login("pwpnx360@gmail.com","Dachi5617@gm")

msg="\nTest"
server.sendmail("pwpnx360@gmail.com","dxu10@hawk.iit.edu",msg)

