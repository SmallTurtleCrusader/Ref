def isFibonacci():
    n = int(input('Num: '))
    a = 0
    b = 1
    if(a == n or b == n):
        print('True')
        return True
    c = a + b
    while(c<=n):
        if(c == n):
            print('True')
            return True
        a = b
        b = c
        c = a + b
    print('False')
    return False

isFibonacci()