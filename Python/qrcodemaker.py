import qrcode

img = qrcode.make('https://www.youtube.com/watch?v=o-YBDTqX_ZU')

img.save('test.png')