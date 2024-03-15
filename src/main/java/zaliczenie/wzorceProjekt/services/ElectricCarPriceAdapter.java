package zaliczenie.wzorceProjekt.services;

//Tydzień 3, adapter wyliczający cene wypożyczenia samochodu
public class ElectricCarPriceAdapter {
    CarPriceCalculator carPriceCalculator;
    public ElectricCarPriceAdapter(CarPriceCalculator carPriceCalculator){
        this.carPriceCalculator = carPriceCalculator;
    }

    public float calculatePrice(float basePrice) {
        return carPriceCalculator.calculatePrice(basePrice);
    }
}
//Tydzień 3, koniec wzorca adapter