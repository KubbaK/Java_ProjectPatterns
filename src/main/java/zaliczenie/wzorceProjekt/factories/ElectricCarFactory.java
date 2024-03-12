
package zaliczenie.wzorceProjekt.factories;

import zaliczenie.wzorceProjekt.models.ElectricCar;
import zaliczenie.wzorceProjekt.models.Fuel.ElectricFuel;
import zaliczenie.wzorceProjekt.models.Fuel.IFuelType;

import java.util.Date;
//Tydzień 1, Wzorzec Fabryka, fabryka posiadająca metode wytwórczą do tworzenia samochodów elektrycznych
public class ElectricCarFactory {
    public static ElectricCar CreateCar(int id, String brand, String model, Date production_date, String color, String photo_url, IFuelType fuel_type, String batteryCapacity ) {
       ElectricCar electricCar = new ElectricCar(id, brand, model, production_date, color, photo_url, fuel_type, batteryCapacity);
        IFuelType electricFuel = new ElectricFuel();
        electricCar.setFuel_type(electricFuel);
        return electricCar;
    }
}
//Koniec tydzień 1, Wzorzec Fabryka,