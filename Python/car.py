class Auto:
    def __init__(self, rendszam, gyarto, tipus, evjarat, tulajdonos, sebesseg):
        self.rendszam = rendszam
        self.gyarto = gyarto
        self.tipus = tipus
        self.evjarat = evjarat
        self.tulajdonos = tulajdonos
        self.sebesseg = sebesseg

    def info(self):
        print(f"Rendszám: {self.rendszam} -> Tulajdonos: {self.tulajdonos}")
    
    def start(self):
        return self.tulajdonos
    
    def gyorsabbe(self, other):
        if other.sebesseg < self.sebesseg:
            return 1
        elif other.sebesseg > self.sebesseg:
            return -1
        else:
            return 0
    
def main():
    auto1 = Auto('JER514', 'Lamborghini', 'Lamborghini Aventador', 2020, 'Megyesi Máté', 487)
    auto2 = Auto(input("Rendszám: "), input("Gyártó: "), input("Típus: "), int(input("Évjárat: ")), input("Tulajdonos: "), int(input("Sebesség: ")))

    auto1.info()
    auto2.info()
    
    i = auto1.gyorsabbe(auto2)
    if i == 1:
        print("1. autó gyorsabb.")
    elif i == -1:
        print("2. autó gyorsabb.")
    else:
        print("Ugyanolyan gyorsak.")

main()