import pyshorteners as sh

link = 'https://www.youtube.com/watch?v=nHqe5D4MsCU&list=LL&index=11&ab_channel=ATB'

s = sh.Shortener()
print(s.tinyurl.short(link))