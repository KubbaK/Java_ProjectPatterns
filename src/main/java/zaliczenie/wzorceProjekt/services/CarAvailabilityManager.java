package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.models.Car;

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

    public List<Car> getAvailableEcoCars() {
        List<Car> ecoCars = new ArrayList<>();

        for (Car car : availableCars) {
            if (car.isEco()) {
                ecoCars.add(car);
            }
        }

        return ecoCars;
    }
}
//Koniec Tydzień 1, Wzorzec Singleton