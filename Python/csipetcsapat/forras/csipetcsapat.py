from random import randint
l = []
ch = input("fájl / random: ")
if ch == "fájl":
    with open("forras/gyujtemeny.txt", "r", encoding="UTF-8") as f:
        for line in f.readlines():
            l.append(int(line.strip()))
    van = False
    for i in l:
        if i == 0:
            van = True
            break
    if van:
        print("Volt olyan nap amikor nem gyűjöttek egyetlen mogyorót sem.")
    else:
        print("Nem volt olyan nap amikor nem gyűjöttek egyetlen mogyorót sem.")
    c = 0
    for i in l:
        if i >= 45:
            c +=1
    print(f"{c} napon szedtek legalább 45 mogyorót.")
    num = int(input("Kérek egy számot: "))
    if num in l:
        print(f"Volt hogy ennyit szedtek a(z) {l.index(num)+1}. napon.")
    else:
        print("Nem volt olyan nap amin ennyit szedtek.")
    c = 0
    for i in l:
        if i%2 != 0:
            c += 1
    print(f"{c} napon nem tudták egyenlően elosztani.")
    ind = 0
    for i in l:
        if i%5 == 0:
            ind = l.index(i)
            break
    print(f"{ind+1}. napon tudták először elosztani 5 felé.")
    turbo = []
    for i in l:
        turbo.append(i*3)
    with open("forras/turbo.txt", "w", encoding="UTF-8") as f:
        for i in turbo:
            f.write(str(turbo.index(i)+1))
            f.write(". nap: ")
            f.write(str(i))
            f.write(" darab\n")
    szinek = []
    with open("forras/szinek.txt", "r") as f:
        for line in f.readlines():
            szinek.append(line.strip())
    szinek.sort()
    print("Színek: ", end="")
    for i in szinek:
        print(f"{i},", end="")
    lufik = []
    print("")
    for i in range(10):
        lufik.append(int(input("Hány lufit fújt fel?: ")))
    max = lufik[0]
    for i in lufik:
        if i > max:
            max = i
    print(f"Legtöbb lufi: {szinek[lufik.index(max)]}\t Mennyit: {max}")
    min = lufik[0]
    for i in lufik:
        if i < min:
            min = i
    print(f"Legkevesebb lufi: {szinek[lufik.index(min)]}")
    sum = 0
    for i in lufik:
        sum += i
    print(f"Összesen {sum} darab lufit fújtak fel.")

elif ch == "random":
    for i in range(30):
        l.append(randint(0,50))
    van = False
    for i in l:
        if i == 0:
            van = True
            break
    if van:
        print("Volt olyan nap amikor nem gyűjöttek egyetlen mogyorót sem.")
    else:
        print("Nem volt olyan nap amikor nem gyűjöttek egyetlen mogyorót sem.")
    c = 0
    for i in l:
        if i >= 45:
            c +=1
    print(f"{c} napon szedtek legalább 45 mogyorót.")
    num = int(input("Kérek egy számot: "))
    if num in l:
        print(f"Volt hogy ennyit szedtek a(z) {l.index(num)+1}. napon.")
    else:
        print("Nem volt olyan nap amin ennyit szedtek.")
    c = 0
    for i in l:
        if i%2 != 0:
            c += 1
    print(f"{c} napon nem tudták egyenlően elosztani.")
    ind = 0
    for i in l:
        if i%5 == 0:
            ind = l.index(i)
            break
    print(f"{ind+1}. napon tudták először elosztani 5 felé.")
    turbo = []
    for i in l:
        turbo.append(i*3)
    with open("forras/turbo.txt", "w", encoding="UTF-8") as f:
        for i in turbo:
            f.write(str(turbo.index(i)+1))
            f.write(". nap: ")
            f.write(str(i))
            f.write(" darab\n")
    szinek = []
    with open("forras/szinek.txt", "r") as f:
        for line in f.readlines():
            szinek.append(line.strip())
    szinek.sort()
    print("Színek: ", end="")
    for i in szinek:
        print(f"{i},", end="")
    lufik = []
    print("")
    for i in range(10):
        lufik.append(int(input("Hány lufit fújt fel?: ")))
    max = lufik[0]
    for i in lufik:
        if i > max:
            max = i
    print(f"Legtöbb lufi: {szinek[lufik.index(max)]}\t Mennyit: {max}")
    min = lufik[0]
    for i in lufik:
        if i < min:
            min = i
    print(f"Legkevesebb lufi: {szinek[lufik.index(min)]}")
    sum = 0
    for i in lufik:
        sum += i
    print(f"Összesen {sum} darab lufit fújtak fel.")