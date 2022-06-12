from pytube import YouTube
import moviepy.editor as mp

url = input('Youtube link: ')
name = input('Output name: ')

yt = YouTube(url)
try:
    print(yt.streams)
except VideoUnavailable:
    print("Unavailable")
