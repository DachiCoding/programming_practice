import logging
import numpy as np
import os
import urllib

FRB_URL='http://www.federalreserve.gov/datadownload/Output.aspx? \
	 rel=H15&series=7fbf8fc65ad44431bf467b3b7eef6bf2&lastObs= \
         &from=&to=&filetype=csv&label=include&layout=seriescolumn \
         &type=package'

frb_site=urllib.urlopen(FRB_URL)
text=frb_site.read().strip()

with open('DachiFRBH15.csv','w') as f:
 f.write(text)

f.close()
