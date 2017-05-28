import feedparser
import time

# Read URLs from file
with open("urls.txt", "r") as urlFile:
    urlArray = []
    for line in urlFile:
        urlArray.append(line)
		
newsSitesNamesArray = ['Hurriyet', 'CnnTurk', 'Cumhuriyet', 'Yenisafak', 'Aksam',
 'AnaYurt', 'GercekGundem', 'AA',
 'AHaber', 'Euronews', 'AjansHaber', 
 'DW', 'Sabah']

# Getting news titles
try:
	for n in range(len(urlArray)):
		fp = feedparser.parse(urlArray[n])
		
		extension = newsSitesNamesArray[n]
		siteName = 'newsTitle%s.txt'%extension
		
		original = open(siteName, 'r')
		
		data = original.read()
		
		with file(siteName, 'w') as modified:
			for i in fp.entries:
				modified.write(i.title.encode('UTF-8') + "\n$\n" + data)	
except:
	raise Exception('Something Went Wrong!')
