
package zaliczenie.wzorceProjekt.domain.models;

public class ElectricCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        Car electricCar = new Car();
        return electricCar;
    }
}
