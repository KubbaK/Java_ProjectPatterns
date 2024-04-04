package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.template.CarManagementProcess;
import zaliczenie.wzorceProjekt.template.CombustionCarManagement;
import zaliczenie.wzorceProjekt.template.ElectricCarManagement;
//Tydzień 6, Wzorzec Template, dla każdego z typu samochodów daje szablon metod, używanych gdy samochód poddawany jest przeglądowi
public class CarFleetManager {
    public void manageElectricCarFleet() {
        CarManagementProcess managementProcess = new ElectricCarManagement();
        managementProcess.manageCar();
    }

    public void manageCombustionCarFleet() {
        CarManagementProcess managementProcess = new CombustionCarManagement();
        managementProcess.manageCar();
    }
}
//Koniec Tydzień 6, Wzorzec Template