package zaliczenie.wzorceProjekt.services;

public class CombustionCarPriceAdapter  {
    float fuelPrice;
    CarPriceCalculator carPriceCalculator;

    public CombustionCarPriceAdapter(CarPriceCalculator carPriceCalculator, float fuelPrice){
        this.fuelPrice = fuelPrice;
        this.carPriceCalculator = carPriceCalculator;
    }

    public float calculatePrice(float basePrice) {
        return carPriceCalculator.calculatePrice(basePrice) + fuelPrice;
    }
}
