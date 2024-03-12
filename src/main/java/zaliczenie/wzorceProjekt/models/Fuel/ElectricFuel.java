package zaliczenie.wzorceProjekt.models.Fuel;

public class ElectricFuel implements IFuelType{
    public String typeOfBattery;
    @Override
    public Boolean isEco() {
        return true;
    }
}
