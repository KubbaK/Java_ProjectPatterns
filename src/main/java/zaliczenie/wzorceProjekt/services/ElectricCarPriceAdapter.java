package zaliczenie.wzorceProjekt.services;

public class ElectricCarPriceAdapter {
    CarPriceCalculator carPriceCalculator;
    public ElectricCarPriceAdapter(CarPriceCalculator carPriceCalculator){
        this.carPriceCalculator = carPriceCalculator;
    }

    public float calculatePrice(float basePrice) {
        return carPriceCalculator.calculatePrice(basePrice);
    }
}
