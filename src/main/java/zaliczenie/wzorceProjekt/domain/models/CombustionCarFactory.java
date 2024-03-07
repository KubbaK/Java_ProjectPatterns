package zaliczenie.wzorceProjekt.domain.models;


public class CombustionCarFactory implements CarFactory {
    @Override
    public CombustionCar createCar() {
        CombustionCar combustionCar = new CombustionCar();
        return combustionCar;
    }
}
