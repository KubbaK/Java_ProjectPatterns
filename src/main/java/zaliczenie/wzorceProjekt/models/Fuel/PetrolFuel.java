package zaliczenie.wzorceProjekt.models.Fuel;

public class PetrolFuel extends FuelBase{
    public String typeOfPetrol;
    @Override
    public Boolean isEco() {
        return false;
    }
}
