package zaliczenie.wzorceProjekt.models;

import zaliczenie.wzorceProjekt.models.CarType.CarType;
import zaliczenie.wzorceProjekt.models.Fuel.IFuelType;
import zaliczenie.wzorceProjekt.visitor.ICarComponent;
import zaliczenie.wzorceProjekt.visitor.ICarVisitor;

import java.util.Date;

public class ElectricCar extends Car implements ICarComponent {
    private float batteryCapacity;

    public ElectricCar(int id, String brand, String model, Date production_date, String color,
                       String photo_url, IFuelType fuel_type, CarEquipment carEquipment, CarType carType, float batteryCapacity, float price)
    {
        super(id, brand, model, production_date, color, photo_url, fuel_type, carEquipment, carType, price);
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

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void Accept(ICarVisitor visitor) {
        visitor.VisitElectricCar(this);
    }
}
