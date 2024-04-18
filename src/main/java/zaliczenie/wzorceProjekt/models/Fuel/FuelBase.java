package zaliczenie.wzorceProjekt.models.Fuel;

//Tydzień 7, Otwarte - zamknięte poprzez abstrakcję
//Tydzień 8, Liskov
public abstract class FuelBase implements IFuelType{
    @Override
    public Boolean isEco() {
        return false;
    }
}
//Koniec tydzień 8, Liskov
//Koniec tydzień 7, Otwarte - zamknięte