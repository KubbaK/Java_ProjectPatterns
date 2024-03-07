
package zaliczenie.wzorceProjekt.domain.models;

public class ElectricCarFactory implements CarFactory {
    public ElectricCar createCar() {
       ElectricCar electricCar = new ElectricCar();
        FuelType electricFuel = new FuelType("elektryczny");
        electricCar.setFuel_type(electricFuel);
        return electricCar;
    }
}
