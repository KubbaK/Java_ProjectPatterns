package zaliczenie.wzorceProjekt.models;

import zaliczenie.wzorceProjekt.models.Fuel.IFuelType;
import zaliczenie.wzorceProjekt.visitor.ICarComponent;
import zaliczenie.wzorceProjekt.visitor.ICarVisitor;

import java.util.Date;

public class CombustionCar extends Car implements ICarComponent {
    private float fuelTankCapacity;

    public CombustionCar(int id, String brand, String model, Date production_date,
                         String color, String photo_url, IFuelType fuel_type, CarEquipment carEquipment, float fuelTankCapacity, float price){
        super(id, brand, model, production_date, color, photo_url, fuel_type, carEquipment, price);
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

    public float getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(float fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void Accept(ICarVisitor visitor) {
        visitor.VisitCombustionCar(this);
    }
}
