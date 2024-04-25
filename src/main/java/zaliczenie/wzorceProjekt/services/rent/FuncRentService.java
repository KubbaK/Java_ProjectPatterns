package zaliczenie.wzorceProjekt.services.rent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import zaliczenie.wzorceProjekt.funcProgramming.CarFilter;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.services.CarAvailabilityManager;


public class FuncRentService {
    private final CarAvailabilityManager carAvailabilityManager;

    public FuncRentService(CarAvailabilityManager carAvailabilityManager) {
        this.carAvailabilityManager = carAvailabilityManager;
    }

    public List<Car> getAllAvailableCars() {
        return new ArrayList<>(carAvailabilityManager.getAvailableCars());
    }

    public double getTotalPriceOfAvailableCars() {
        return carAvailabilityManager.getAvailableCars().stream()
                .mapToDouble(Car::getPrice)
                .sum();
    }

    public List<Car> getCarsByCriteria(CarFilter filter) {
        return carAvailabilityManager.getAvailableCars().stream()
                .filter(filter::filter)
                .collect(Collectors.toList());
    }
}
