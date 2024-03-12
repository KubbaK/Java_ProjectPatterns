package zaliczenie.wzorceProjekt.models.Fuel;

public class DieselFuel implements IFuelType{
    public String typeOfDiesel;
    @Override
    public Boolean isEco() {
        return false;
    }
}
