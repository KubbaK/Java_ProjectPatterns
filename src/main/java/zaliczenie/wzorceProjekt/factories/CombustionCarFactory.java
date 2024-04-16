package zaliczenie.wzorceProjekt.factories;


import zaliczenie.wzorceProjekt.models.CarEquipment;
import zaliczenie.wzorceProjekt.models.CarType.CarType;
import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.Fuel.IFuelType;
import zaliczenie.wzorceProjekt.models.Fuel.PetrolFuel;


import java.util.Date;
//Tydzień 1, Wzorzec Fabryka, fabryka posiadająca metode wytwórczą do tworzenia samochodów spalinowych
public  class CombustionCarFactory  {

    public static CombustionCar CreateCar(int id, String brand, String model, Date production_date, String color, String photo_url,
                                          IFuelType fuel_type, CarEquipment carEquipment, CarType carType, float fuelTankCapacity, float price) {
            CombustionCar combustionCar = new CombustionCar(id, brand, model, production_date, color,
                    photo_url, fuel_type, carEquipment, carType, fuelTankCapacity, price);
        IFuelType combustionFuel = new PetrolFuel();
        combustionCar.setFuel_type(combustionFuel);
        return combustionCar;
    }
}
//Koniec tydzień 1, Wzorzec Fabryka