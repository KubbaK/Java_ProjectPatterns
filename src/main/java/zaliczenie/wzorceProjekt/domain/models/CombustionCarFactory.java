package zaliczenie.wzorceProjekt.domain.models;


public class CombustionCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        Car combustionCar = new Car();
        FuelType combustionFuel = new FuelType("benzyna");
        combustionCar.setFuel_type(combustionFuel);
        return combustionCar;
    }
}
