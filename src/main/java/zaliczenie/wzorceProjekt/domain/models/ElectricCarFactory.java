
package zaliczenie.wzorceProjekt.domain.models;

public class ElectricCarFactory implements CarFactory {
    @Override
    public ElectricCar createCar() {
        ElectricCar electricCar = new ElectricCar();
        return electricCar;
    }
}
