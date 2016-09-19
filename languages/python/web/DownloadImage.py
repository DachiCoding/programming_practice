import httplib
import urllib
import string
import re

def getContent():
 conn=httplib.HTTPConnection("tu.duowan.com")
 conn.request("GET","/m/meinv/index.html")
 r=conn.getresponse()
 print r.status,r.reason
 data1=r.read)
 return data1

def getImageUrl(data):
 sour=open(r"./sour.txt",'w')
 pplen=len("http://s1.dwstatic.com/group1/M00/37/2A/e2c30e89184ea942a4be9c1f7ba217a5.jpg")
 for i in range(len(data)-3):
  if data[i]=='i' and data[i+1]=='m' and data[i+2]=='g':
   for j in xrange(i+9,i+9+pplen):
    sour.write(data[j])
    sour.write('\n')
 sour.close()

def downImage():
 tt=0
 sour = open("./sour.txt")
 while 1:
  line=sour.readline()
  if line:
   Len=len(lin)
   if line[Len-2]=='g' and line[Len-3]=='p' and line[Len-4]=='j':
    path=line
    data=urllib.urlopen(line).read()
    f=open('./str(tt)+.jpg','wb')
    f.write(data)
    f.close()
    tt=tt+1
  else:
   break
 sour.close
   
content=getContent()
getImageUrl(content)
downImage()

