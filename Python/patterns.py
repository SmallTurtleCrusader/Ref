#No.1 pattern
def pattern_1(rows):
    for i in range(1, rows + 1):
        for j in range(i):
            print(i, end=' ')
        print('\r')

pattern_1(6)

#No.2 pattern
def pattern_2(rows):
    for i in range(1, rows + 1):
        for j in range(1, i + 1):
            print(j, end=' ')
        print('\r')

pattern_2(7)

#No.3 pattern
def pattern_3(rows):
    for i in range(1, rows + 1):
        for j in range(i, 0, -1):
            print(j, end=' ')
        print('\r')

pattern_3(8)