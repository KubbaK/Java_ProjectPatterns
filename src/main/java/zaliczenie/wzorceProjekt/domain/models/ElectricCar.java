package zaliczenie.wzorceProjekt.domain.models;

import javax.management.openmbean.InvalidOpenTypeException;

public class ElectricCar extends Car{
    public ElectricCar DeepClone(ElectricCar car, ElectricCar copyCar){
        ElectricCar electricCar = new ElectricCar();
        super.DeepClone(car, electricCar);

        return electricCar;
    }
}
