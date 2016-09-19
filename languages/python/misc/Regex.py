# Regular Expression Notes
# Principles:
# Location + Literal + Variable Type + Pattern + Condition

# Rules:
# . -> match any character
# + -> match 1 or more occureences
# * -> match 0 or more occurrences
# ? -> match 0 or 1 occurence
# {N} -> match n occurences
# {M,N} -> match from M to N occurences
# ^ -> match start
# $ -> match end
# [xyz] -> match x or y or z
# xy|yz -> match xy or yz
# \d -> match numeric
# \w -> match any alphanumeric character
# \s -> match any whitespace

import re

# re.match(pattern,string,flag)
# re.match('word','word')
m=re.match('foo','foo')
if m is not None:
 print m.group()

# re.match(r'() word ()',line)
line="Cats are smarter than dogs"
matchObj=re.match(r'(.*) are (.*?) .*',line,re.M|re.I)

if matchObj:
 print "matchObj.group(): ",matchObj.group()
 print "matchObj.group(1): ",matchObj.group(1)
 print "matchObj.group(2): ",matchObj.group(2)
else:
 print "No match!"

# re.match ex3
print "re.match:",re.match('foo','foo on the table').group()

# re.search
print "re.search:",re.search('foo','seafood').group() # match will return NoneType

# match more than one string
bt='bat|bet|bit'
m=re.match(bt,'bat')
if m is not None: print m.group()

m=re.match(bt,'blt')
if m is not None: print m.group() # return None

m=re.match(bt,'He bit me!')
if m is not None: print m.group() # return None

m=re.search(bt,'He bit me!')
if m is not None: print m.group()

# matching (.)
anyend='.end'
m=re.match(anyend,'bend')
if m is not None: print m.group()
m=re.match(anyend,'end')
if m is not None: print m.group()
m=re.match(anyend,'\nend')
if m is not None: print m.group()
m=re.search('.end','The end.')
if m is not None: print m.group()

patt314='3.14'
pi_patt='3\.14'
m=re.match(pi_patt,'3.14')
if m is not None: print m.group()
m=re.match(patt314,'3.14')
if m is not None: print m.group()
m=re.match(pi_patt,'3014')
if m is not None: print m.group(),'pi_patt'
m=re.match(patt314,'3014')
if m is not None: print m.group(),'patt314'

# creating character classes[]
m=re.match('[cr][23][dp][o2]','c3po')
if m is not None: print m.group()

m=re.match('[cr][23][dp][o2]','c2do')
if m is not None: print m.group()

# Repitition
patt='\w+@(\w+\.)?\w+\.com'
print re.match(patt,'nobody@xxx.com').group()
print re.match(patt,'nobody@www.xxx.com').group()
patt='\w+@(\w+\.)*\w+\.com'
print re.match(patt,'nobody@www.xxx.yyy.zzz.com').group()
m=re.match('\w\w\w-\d\d\d','abc-123')
if m is not None: print m.group()
m=re.match('\w\w\w-\d\d\d','abc-xyz')
if m is not None: print m.group()

# Subgroup
m=re.match('ab','ab')
print 1,m.group()
m=re.match('(ab)','ab')
print 2,m.group()
print 2,m.group(1)
m=re.match('(a)(b)','ab')
print 3,m.group()
print 3,m.group(1)
print 3,m.group(2)
m=re.match('(a(b))','ab')
print 4,m.group()
print 4,m.group(1)
print 4,m.group(2)

# Match start and end
m=re.match("^The",'The end')
if m is not None:print 1,m.group()
m=re.match("^The",'end.The')
if m is not None:print 2,m.group()
m=re.search(r'\bthe','bite the dog')
if m is not None:print 3,m.group()
m=re.search(r'\Bthe','bite the dog')
if m is not None:print 4,m.group()

# findall
print re.findall('car','car')
print re.findall('car','scary')
print re.findall('car','carry the barcardi to the car')

# finditer
s='This and that'
reit=re.finditer(r'(th\w+)',s,re.I)
print reit.next().groups()
print reit.next().groups()

# sub
print re.sub('X','Mr.Smith','attn: X\nDear X')
print re.subn('X','Mr.Smith','attn: X\nDear X')

# Split
DATA= (
 'Mountain View, CA 94040',
 'Sunnyvale, CA',
 'Los Altos, 94023',
 'Cupertino 95014',
 'Palo Alto CA',
)

for datum in DATA:
 print re.split(',|(?=(?:\d{5}|[A-Z]{2})) ',datum)
 



