package zaliczenie.wzorceProjekt.models.Fuel;

public class ElectricFuel extends FuelBase{
    public String typeOfBattery;
    @Override
    public Boolean isEco() {
        return true;
    }
}
