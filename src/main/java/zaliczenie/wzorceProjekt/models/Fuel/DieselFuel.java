package zaliczenie.wzorceProjekt.models.Fuel;

public class DieselFuel extends FuelBase{
    public String typeOfDiesel;
    @Override
    public Boolean isEco() {
        return false;
    }
}
