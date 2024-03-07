package zaliczenie.wzorceProjekt.domain.models;

public class TeslaCar extends ElectricCar{
    public TeslaCar DeepClone(TeslaCar car) {
        TeslaCar teslaCar = new TeslaCar();
        return (TeslaCar) super.DeepClone(car, teslaCar);
    }
}