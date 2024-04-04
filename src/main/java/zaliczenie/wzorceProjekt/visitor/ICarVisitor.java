package zaliczenie.wzorceProjekt.visitor;

import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;

public interface ICarVisitor {
    void VisitCombustionCar(CombustionCar car);
    void VisitElectricCar(ElectricCar car);
}
