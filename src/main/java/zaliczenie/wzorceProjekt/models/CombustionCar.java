package zaliczenie.wzorceProjekt.models;

import zaliczenie.wzorceProjekt.models.Fuel.IFuelType;

import java.util.Date;

public class CombustionCar extends Car{
    private String fuelTankCapacity;

    public CombustionCar(int id, String brand, String model, Date production_date,
                         String color, String photo_url, IFuelType fuel_type, CarEquipment carEquipment, String fuelTankCapacity){
        super(id, brand, model, production_date, color, photo_url, fuel_type, carEquipment);
        setFuelTankCapacity(fuelTankCapacity);
    }

    public CombustionCar(){}

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
