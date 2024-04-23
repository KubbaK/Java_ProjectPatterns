package zaliczenie.wzorceProjekt.template;

import zaliczenie.wzorceProjekt.aspects.Loggable;

//Tydzień 8, Odwrócenie zależności
public abstract class CarManagementProcess {
    @Loggable
    public void manageCar() {
        reserveVehicle();
        performMaintenance();
        releaseVehicle();
    }

    protected abstract void reserveVehicle();
    protected abstract void performMaintenance();
    protected abstract void releaseVehicle();
}
//Koniec tydzień 8, Odwrócenie zależności