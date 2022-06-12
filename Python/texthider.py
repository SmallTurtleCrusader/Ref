import cv2


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

#encoded_image = encode_image('CodeImage.jpg', "Odin, (más néven Oden, ó-északi nyelven Óinn, , németül: Wotan, Wuotan vagy, óangol: Wden vagy Wdan) a skandináv és germán mitológia legfontosabb istene és a panteon legidősebb, leghatalmasabb, legbölcsebb tagja. Odin a háború, győzelem, az akasztófák, a téboly, az uralkodás, halál, bölcsesség, költészet, szónoklat, varázslat és a rúnák istene. Felesége Frigg, a szülés és termékenység istennője. Odin szülei Bor/Bur – a hímnős, teremtetlen ősóriás, Buri fia – valamint a jötunn Bestla. Fivérei Vili és Vé (néha Hönir és Lodur). Fivéreivel együtt Odin végzett a kozmikus ősóriással, Ymirrel, akinek holttestéből megteremtették Midgárdot, az emberek világát. Ifjú éveit feltehetően vándorlással töltötte, amelynek során a bölcsesség és az örök hatalom megszerzése után kutatott. Ő volt az, aki megszerezte az istenek és az emberek számára a Költészet Mézsörét egy Suttung nevű óriástól, valamint ugyancsak ő szerzi meg a mágikus rúnákat. Ennek érdekében kilenc napig, varázserejű lándzsájával, a Gungnirrel átnyársalva a testét, áldozva, felakasztva függött a világfa, az Yggdrasil törzsén. A megszerzett rúnákkal díszíti dárdáját, valamint nyolclábú lova, Szleipnir fogait is. Hogy szert tegyen a bölcsességre, Odin feláldozta fél szemét Mímir kútjában, hogy ihasson a bölcsességet adó vízből, a kút pedig a mai napig őrzi azt.")
#cv2.imwrite("EncodedImage.png", encoded_image)

encoded_image = "EncodedImage.png"
print(decode_image(encoded_image))

print('Done')