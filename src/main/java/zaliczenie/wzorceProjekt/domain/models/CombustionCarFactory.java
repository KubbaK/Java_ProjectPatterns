package zaliczenie.wzorceProjekt.domain.models;


public class CombustionCarFactory implements CarFactory {
    @Override

    public CombustionCar createCar() {
            CombustionCar combustionCar = new CombustionCar();
        FuelType combustionFuel = new FuelType("benzyna");
        combustionCar.setFuel_type(combustionFuel);
        return combustionCar;
    }
}
