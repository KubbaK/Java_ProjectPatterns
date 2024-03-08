package zaliczenie.wzorceProjekt.domain.models;

import java.util.Date;

public class CombustionCar extends Car{
    private String fuelTankCapacity;

    CombustionCar(int id, String brand, String model, Date production_date,
                  String color, String photo_url, FuelType fuel_type, String fuelTankCapacity){
        super(id, brand, model, production_date, color, photo_url, fuel_type);
        setFuelTankCapacity(fuelTankCapacity);
    }

    CombustionCar(){}
    //Tydzien 1, prototyp pozwalający na klonowanie samochodu spalinowego
    public CombustionCar DeepClone(CombustionCar car){
        CombustionCar combustionCar = new CombustionCar();
        combustionCar.setFuelTankCapacity(car.fuelTankCapacity);
        super.DeepClone(car, combustionCar);

        return combustionCar;
    }
    //Koniec tydzien 1, prototyp

    public String getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(String fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }
}
