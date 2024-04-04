package zaliczenie.wzorceProjekt.visitor;

import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;
//Tydzień 6, Wzorzec Odwiedzający, pozwala na odwiedzanie konkretnych obiektów i wykonywania na nim operacji bez naruszania kodu wewnętrznego klasy
public class CarTankVisitor implements ICarVisitor{
    @Override
    public void VisitCombustionCar(CombustionCar car) {
        System.out.println("Tankowanie samochodu spalinowego");
    }

    @Override
    public void VisitElectricCar(ElectricCar car) {
        System.out.println("Ładowanie samochodu elektrycznego");
    }
}
//Koniec tydzień 6, Wzorzec Odwiedzający