package zaliczenie.wzorceProjekt.domain.models;


import java.util.Date;
//Tydzień 1, Wzorzec Fabryka, fabryka posiadająca metode wytwórczą do tworzenia samochodów spalinowych
public  class CombustionCarFactory  {

    public static CombustionCar CreateCar(int id, String brand, String model, Date production_date, String color, String photo_url, FuelType fuel_type, String fuelTankCapacity ) {
            CombustionCar combustionCar = new CombustionCar(id, brand, model, production_date, color, photo_url, fuel_type, fuelTankCapacity);
        FuelType combustionFuel = new FuelType("benzyna");
        combustionCar.setFuel_type(combustionFuel);
        return combustionCar;
    }
}
//Koniec tydzień 1, Wzorzec Fabryka