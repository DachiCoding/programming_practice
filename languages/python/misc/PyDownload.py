from os.path import basename #basename return the final comp of a path
from urlparse import urlsplit
import urllib2

def url2name(url):
	return basename(urlsplit(url)[2])

def download(url,localFileName=None):
	localName=url2name(url)
	req=urllib2.Request(url)
	r=urllib2.urlopen(req)
	if r.info().has_key('Content-Disposition'):
		localName=r.info()['Content-Disposition'].split('filename=')[1]
		if localName[0]=='"' or localName[0]=="'":
			localName=localName[1:-1]
	elif r.url !=url:
		localName=url2name(r.url)
	if localFileName:
		localName=localFileName
	f=open(localName,'wb')
	f.write(r.read())
	f.close()

download(r'http://i.dell.com/sites/content/business/solutions/whitepapers/en/Documents/hadoop-introduction.pdf')

