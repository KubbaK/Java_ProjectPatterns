package zaliczenie.wzorceProjekt.template;

public abstract class CarManagementProcess {
    public void manageCar() {
        reserveVehicle();
        performMaintenance();
        releaseVehicle();
    }

    protected abstract void reserveVehicle();
    protected abstract void performMaintenance();
    protected abstract void releaseVehicle();
}
