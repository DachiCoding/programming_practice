############# Python String Manipulation

############# 01-String Manipulation
# word = "HeLLo World"
# print word
# print word[0]
# len(word)
# print word.count("l")
# print word.find("H")
# print word.index("World")
# print word[1:]
# print word[:-1]
# print word[-3:]
# print word.split(' ')
# print word.startswith("H")
# print word.endswith("d")
# print word.endswith("w")
# print "."*10
# print word.replace("Hello","Goodbye")
# print word.upper()
# print word.lower()
# print word.title()
# print word.capitalize()
# print word.swapcase()
# print ' '.join(reversed(word))
# print '.'.join(word)
# print word.isalnum()
# print word.isalpha()
# print word.isdigit()
# str= "      xyz    "
# print str,len(str)
# print str.strip(),len(str.strip())
# print str.lstrip(),len(str.lstrip())
# print str.rstrip(),len(str.rstrip())

############# 02-List Manipulation
# l=['yellow','red','blue','green','black']
# print l
# print l[0]
# print len(l)
# print sorted(l)
# l.insert(0,'white')
# print l
# l2=['Purple']
# l.extend(l2)
# print l
# # del.l[-1]
# # print l
# print l.pop()
# l.reverse()
# print l
# print l.count('white')
# 
# if 'red' in l:
# 	print "List contains",'red'
# 
# for item in l:
# 	print item


############ 03-List Comprehensions
# Strucutre:
# for item in list:
#	if conditional:
#		expression
# [transform -> iteration -> condition]
# new_range=[i*i for i in range(5) if i % 2 ==0]
# print new_range
# x=[i for i in range(10)]
# print x
# 
# squares=[]
# for x in range(10):
# 	squares.append(x**2)
# print squares
# 
# list1=[3,4,5]
# multiplied=[item*3 for item in list1]
# print multiplied

# listOfWords=["this","is","a","list","of","words"]
# item = [word[0] for word in listOfWords]
# print listOfWords
# print item
# print [x.lower() for x in ['A','B','C']]
# print [x.upper() for x in ['a','b','c']]
# string ="Hello 12345 World"
# numbers=[x for x in string if x.isdigit()]
# print numbers

############ 04-File I/O
# fh=open("test.txt","r")
# fh=fh.read()
# fh=fh.split('\n')
# fh=[fh]
# print type(fh)
# print fh
# result=[i for i in fh if "line 3" in i]
# print result

############ 05-Functions
# def double(x):
# 	return x*2
# print double(10)
# print [double(x) for x in range(10)]
# print [double(x) for x in range(10) if x%2==0]
# print [x+y for x in [10,30,50] for y in [20,40,60]]

############ 06-Date and Times
# import time
# import datetime
# print "Time in seconds since the epoch: %s" %time.time()
# print "Current date and time: ", datetime.datetime.now()
# print "Or like this: ", datetime.datetime.now().strftime("%y-%m-%d-%H-%M")
# 
# print "Current Year",datetime.date.today().strftime("%Y")
# print "Current Year",datetime.datetime.now().strftime("%Y")
# print "Month of Year",datetime.date.today().strftime("%B")
# print "Week number of the week: ", datetime.date.today().strftime("%w")
# print "Day of year: ",datetime.date.today().strftime("%j")
# print "Day of the month: ",datetime.date.today().strftime("%d")
# print "Day of week: ", datetime.date.today().strftime("%A")

############ 07 Sending Gmails
# import smtplib
# fromaddr="pwpnx360@gmail.com"
# toaddrs="biz_niz@hotmail.com"
# msg="I am sening you this via Python!"
# server=smtplib.SMTP("smtp.gmail.com:587")
# server.starttls()
# username="pwpnx360@gmail.com"
# password="Dachi5617@gm"
# server.login(username,password)
# server.sendmail(fromaddr,toaddrs,msg)
# toaddrs=fromaddr
# server.sendmail(fromaddr,toaddrs,msg)

############ 08 OS Module
# import os
# print os.system('pwd') # Executing Shell Command
# print os.getcwd()
# print os.getgid()
# print os.uname()
# print os.stat(filename)
