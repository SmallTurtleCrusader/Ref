from tkinter import *
import tkinter as tk
import cv2
from functools import partial


#Function to Decode
def char_generator(message):
      for c in message:
        yield ord(c)

def get_image(image_location):
  img = cv2.imread(image_location)
  return img

def gcd(x, y):
  while(y):
    x, y = y, x % y
  return x

def encode_image(image_location, msg):
  img = get_image(image_location)
  msg_gen = char_generator(msg)
  pattern = gcd(len(img), len(img[0]))
  for i in range(len(img)):
    for j in range(len(img[0])):
      if (i+1 * j+1) % pattern == 0:
        try:
          img[i-1][j-1][0] = next(msg_gen)
        except StopIteration:
          img[i-1][j-1][0] = 0
          return img

def decode_image(img_loc):
    img = get_image(img_loc)
    pattern = gcd(len(img), len(img[0]))
    message = ''
    for i in range(len(img)):
        for j in range(len(img[0])):
            if (i-1 * j-1) % pattern == 0:
                if img[i-1][j-1][0] != 0:
                        message = message + chr(img[i-1][j-1][0])
                else:
                    return message


#Tkinter Part
m = tk.Tk()
m.title = "Decoder"

width = m.winfo_reqwidth()
height = m.winfo_reqheight()

txt = StringVar()
path = tk.StringVar()

#l1 = Label(m, textvariable=txt, wraplength=300, justify=CENTER)
#l1.grid(column=1,row=3)

t1 = Text(m)
t1.grid(column=1,row=3)

e1 = tk.Entry(m, textvariable=path, width=50)
e1.grid(column=1,row=1)

def getVal():
    return path.get()

def callDecode():
    t1.delete('1.0','end')
    p = getVal()
    try:
        decTxt = decode_image(p)
        t1.insert(tk.END, decTxt)
        txt.set(decTxt)
    except:
        txt.set('Wrong Location')

b1 = tk.Button(m, text='Decode', command=callDecode)
b1.grid(column=1,row=2)

mainloop()