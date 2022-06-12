import math
import random
import secrets

length = int(input('Length of the password: '))
part = int(length/4)

numeric_values = ['0','1','2','3','4','5','6','7','8','9',]
alphabet_values = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','ö','p','q','r','s','t','u','ü','v','w','x','y','z']
uppercase_values = []

for i in alphabet_values:
    c = i.upper()
    uppercase_values.append(c)

symbol_values = ['|','Ä','€','÷','ä','đ','Đ','[',']','ł','Ł','$','ß','<','#','&','@','{','}',';','>','*']

random.shuffle(numeric_values)
random.shuffle(alphabet_values)
random.shuffle(uppercase_values)
random.shuffle(symbol_values)

result = []

for i in range(0,part):
    result.append(secrets.choice(numeric_values))
for i in range(0,part):
    result.append(secrets.choice(alphabet_values))
for i in range(0,part):
    result.append(secrets.choice(uppercase_values))
for i in range(0,part):
    result.append(secrets.choice(symbol_values))

diff = 0

if(len(result) < length):
    diff = length - len(result)

for i in range(0,diff):
    list_id = random.randint(0,3)
    
    if(list_id == 0):
        result.append(secrets.choice(numeric_values))
    elif(list_id == 1):
        result.append(secrets.choice(alphabet_values))
    elif(list_id == 2):
        result.append(secrets.choice(uppercase_values))
    elif(list_id == 3):
        result.append(secrets.choice(symbol_values))

random.shuffle(result)

password = ''

for i in result:
    password += str(i)

print(password)
print(len(password))