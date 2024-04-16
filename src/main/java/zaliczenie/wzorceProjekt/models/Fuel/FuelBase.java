package zaliczenie.wzorceProjekt.models.Fuel;

//Tydzień 8, Liskov
public abstract class FuelBase implements IFuelType{
    @Override
    public Boolean isEco() {
        return false;
    }
}
//Koniec tydzień 8, Liskov
