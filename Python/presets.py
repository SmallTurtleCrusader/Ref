import random

def preset_1():
    rows = random.randint(5,10)
    for i in range(1, rows + 1):
        for j in range(0, i):
            print('*', end='')
        print('\r')
    print('\n')

def preset_2():
    rows = random.randint(5,10)
    for i in range(rows + 1, 0, -1):
        for j in range(1, i):
            print('*', end='')
        print('\r')
    print('\n')

def preset_3():
    rows = random.randint(5,10)
    for i in range(1, rows + 1):
        for j in range(0, i):
            print('*', end='')
        print('\r')
    for k in range(0, rows+1):
        print('*', end='')
    print('\r')
    for x in range(rows + 1, 0, -1):
        for y in range(1, x):
            print('*', end='')
        print('\r')
    print('\n')