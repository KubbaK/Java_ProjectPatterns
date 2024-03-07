
package zaliczenie.wzorceProjekt.domain.models;

public class ElectricCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        Car electricCar = new Car();
        FuelType electricFuel = new FuelType("elektryczny");
        electricCar.setFuel_type(electricFuel);
        return electricCar;
    }
}
