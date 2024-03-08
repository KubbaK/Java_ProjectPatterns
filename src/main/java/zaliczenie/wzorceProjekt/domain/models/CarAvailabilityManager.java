package zaliczenie.wzorceProjekt.domain.models;

import java.util.ArrayList;
import java.util.List;
//Tydzień 1, Wzorzec Singleton, tworzy zarządce do zarządzania wypożyczeniami, zapewniając jedną instancje w systemie.
public class CarAvailabilityManager {
    private static CarAvailabilityManager instance;
    private final List<Car> availableCars;

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
//Koniec Tydzień 1, Wzorzec Singleton