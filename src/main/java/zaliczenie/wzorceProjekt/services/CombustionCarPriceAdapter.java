package zaliczenie.wzorceProjekt.services;

//Tydzień 3, adapter wyliczający cene wypożyczenia samochodu, który dolicza cene paliwa
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
//Tydzień 3, koniec wzorca adapter