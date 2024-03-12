package zaliczenie.wzorceProjekt.models.Fuel;

public class PetrolFuel implements IFuelType{
    public String typeOfPetrol;
    @Override
    public Boolean isEco() {
        return false;
    }
}
