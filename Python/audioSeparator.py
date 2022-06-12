import moviepy.editor as mp

path = input("Path to video: ")
name = input("Result's name: ")

try:
    my_clip = mp.VideoFileClip(path)
    my_clip.audio.write_audiofile(name + ".mp3")
except:
    print("Error")