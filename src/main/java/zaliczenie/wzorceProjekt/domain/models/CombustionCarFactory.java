package zaliczenie.wzorceProjekt.domain.models;


public class CombustionCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        Car combustionCar = new Car();
        return combustionCar;
    }
}
