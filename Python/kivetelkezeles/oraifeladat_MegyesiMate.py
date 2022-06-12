def negyzet():
    print("\n\n\nNégyzet.py")
    try:
        num = int(input("Kérek egy pozitív egész számot: "))
        if num < 0:
            raise Exception
    except ValueError:
        print("A szám nem egész")
    except Exception as ex:
        print("A szám nem pozitív")
    else:
        print(f"A négyzet kerülete: {4*num}")
        print(f"A négyzet területe: {num*num}")

def teglatest():
    print("\n\n\nTéglatest.py")
    try:
        a = int(input("Kérek egy pozitív egész számot: "))
        b = int(input("Kérek egy pozitív egész számot: "))
        c = int(input("Kérek egy pozitív egész számot: "))

        if a < 0 or b < 0 or c < 0:
            raise Exception
    except ValueError:
        print("A megadott adat nem egész szám")
    except Exception:
        print("Valamelyik szám nem pozitív")
    else:
        print(f"A téglatest felszíne: {2*(a*b+a*c+b*c)}")
        print(f"A téglatest térfogata: {a*b*c}")

def szamok():    
    print("\n\n\nSzámok.py")
    filename = input("Kérem a fájl nevét: ")

    try:
        f = open(filename, "r")
        lines = f.readlines()
        l = []
        for line in lines:
            l.append(int(line.strip()))

    except IOError:
        print("A fájlt nem lehet megnyitni!")
    except ValueError:
        print("Valamelyik sor nem egész számot tartalmaz")
    else:

        print(f"Elemek száma: {len(l)}")
        
        try:
            num = int(input("Kérek egy egész számot: "))
        except ValueError:
            print("Az adat nem egész szám")
        else:
            for i in l:
                if i == num:
                    print(f"{num} benne van a listában")
                    break
        
        s = {}
        for i in l:
            if i not in s.keys():
                s[i] = 1
            else:
                a = s[i]
                a += 1
                s[i] = a
        print("Statisztika:")
        for k in s.keys():
            print(k, ":" , s[k])
        
        o = 0
        for i in l:
            if i%2 != 0:
                o += 1
        print(f"Páratlan számok darabszáma: {o}")

        max = l[0]
        for i in l:
            if i > max:
                max = i
        print(f"A legnagyobb szám: {max}\t Helye a listában: {l.index(max)}")

negyzet()
teglatest()
szamok()