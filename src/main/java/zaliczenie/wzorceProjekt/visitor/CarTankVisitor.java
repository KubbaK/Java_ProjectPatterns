package zaliczenie.wzorceProjekt.visitor;

import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;

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
