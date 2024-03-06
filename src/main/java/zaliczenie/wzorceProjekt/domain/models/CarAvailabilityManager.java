package zaliczenie.wzorceProjekt.domain.models;

import java.util.ArrayList;
import java.util.List;

public class CarAvailabilityManager {
    private static CarAvailabilityManager instance;
    private List<Car> availableCars;

    private CarAvailabilityManager() {
        availableCars = new ArrayList<>();
    }

    public static synchronized CarAvailabilityManager getInstance() {
        if (instance == null) {
            instance = new CarAvailabilityManager();
        }
        return instance;
    }

    public void addCar(Car car) {
        availableCars.add(car);
    }

    public void removeCar(Car car) {
        availableCars.remove(car);
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }
}

