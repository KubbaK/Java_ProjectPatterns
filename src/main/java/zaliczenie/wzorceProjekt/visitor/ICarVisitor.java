package zaliczenie.wzorceProjekt.visitor;

import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;
//Tydzień 6, Wzorzec Odwiedzający, pozwala na odwiedzanie konkretnych obiektów i wykonywania na nim operacji bez naruszania kodu wewnętrznego klasy
public interface ICarVisitor {
    void VisitCombustionCar(CombustionCar car);
    void VisitElectricCar(ElectricCar car);
}
//Koniec tydzień 6, Wzorzec Odwiedzający