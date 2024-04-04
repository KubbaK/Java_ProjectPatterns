package zaliczenie.wzorceProjekt.visitor;

import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;

public class CarRepairVisitor implements ICarVisitor{
    @Override
    public void VisitCombustionCar(CombustionCar car) {
        System.out.println("Naprawa samochodu spalinowego");
    }

    @Override
    public void VisitElectricCar(ElectricCar car) {
        System.out.println("Naprawa samochodu elektrycznego");
    }
}
