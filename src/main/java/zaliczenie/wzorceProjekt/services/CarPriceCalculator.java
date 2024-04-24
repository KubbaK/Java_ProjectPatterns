package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.CarType.Hatchback;
import zaliczenie.wzorceProjekt.models.CarType.Kombi;
import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;

public class CarPriceCalculator implements ICarPriceService {
    @Override
    public float calculatePrice(float basePrice) {
        return basePrice;
    }

    // Not used
    public float calculatePrice(Car car)
    {
        float price = 0;

        if (car instanceof ElectricCar) {
            price = 30.0f;
        } else if (car instanceof CombustionCar) {
            price = 100.0f;
        }

        return price;
    }

    // Not used
    public float calculatePriceForType(Car car) {
        float price = 0;

        if (car.getCarType() instanceof Hatchback) {
            price = 30.0f;
        } else if (car.getCarType() instanceof Kombi) {
            price = 100.0f;
        } else {
            price = 50.0f;
        }

        return price;
    }

}
