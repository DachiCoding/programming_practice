import urllib

myurl=urllib.urlopen("http://www.profmcmillan.com")
print myurl

contents=myurl.readlines()
# print contents
headerinfo=myurl.info()
print headerinfo
urllib.urlretrieve("http://www.profmcmillan.com",filename="urlcontent")



