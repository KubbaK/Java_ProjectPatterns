package zaliczenie.wzorceProjekt.models;

import zaliczenie.wzorceProjekt.models.Fuel.IFuelType;

import java.util.Date;

public class ElectricCar extends Car{
    private String batteryCapacity;

    public ElectricCar(int id, String brand, String model, Date production_date, String color, String photo_url, IFuelType fuel_type, String batteryCapacity)
    {
        super(id, brand, model, production_date, color, photo_url, fuel_type);
        setBatteryCapacity(batteryCapacity);
    }

    public ElectricCar(){}

    //Tydzien 1, prototyp pozwalający na klonowanie samochodu elektrycznego
    public ElectricCar DeepClone(ElectricCar car){
        ElectricCar electricCar = new ElectricCar();
        electricCar.setBatteryCapacity(car.batteryCapacity);
        super.DeepClone(car, electricCar);

        return electricCar;
    }
    //Koniec tydzien 1, prototyp

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
