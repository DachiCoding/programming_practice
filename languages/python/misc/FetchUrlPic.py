import os,sys,urllib,urllib2,urlparse
from sgmllib import SGMLParser

img=[]
class URLLister(SGMLParser):
 def reset(self):
  SGMLParser.reset(self)
  self.urls=[]
  self.imgs=[]
 def start_a(self,attrs):
  href=[v for k,v in attrs if k=="href" and v.startswith("http")]
  if href:
   self.urls.extend(href)
 def start_img(self,attrs):
  src=[v for k,v in attrs if k=="src" and v.startswith("http")]
  if src:
   self.imgs.extend(src)

def get_url_of_page(url,if_img=False):
  urls=[]
  try:
   f=urllib2.urlopen(url,timeout=1).read()
   url_listen=URLLister()
   url_listen.feed(f)
   if if_img:
    urls.extend(url_listen.imgs)
   else:
    urls.extend(url_listen.urls)
  except urllib2.URLError,e:
    print e.reason
  return urls

def get_page_html(begin_url,depth,ignore_outer,main_site_domain):
 if ignore_outer:
  if not main_site_domain in begin_url:
   return


