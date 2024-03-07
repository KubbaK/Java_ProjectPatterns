package zaliczenie.wzorceProjekt.domain.models;

public class CombustionCar extends Car{
    public CombustionCar DeepClone(CombustionCar car, CombustionCar copyCar){
        CombustionCar combustionCar = new CombustionCar();
             super.DeepClone(car, combustionCar);

             return combustionCar;
    }
}
