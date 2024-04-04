package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.observers.Observer;
import zaliczenie.wzorceProjekt.observers.Subject;

import java.util.ArrayList;
import java.util.List;

//Tydzień 1, Wzorzec Singleton, tworzy zarządce do zarządzania wypożyczeniami, zapewniając jedną instancje w systemie.
public class CarAvailabilityManager implements Subject{
    private static CarAvailabilityManager instance;
    private final List<Car> availableCars;
    private List<Observer> observers;

    private CarAvailabilityManager() {
        availableCars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized CarAvailabilityManager getInstance() {
        if (instance == null) {
            instance = new CarAvailabilityManager();
        }
        return instance;
    }

    public void addCar(Car car) {
        availableCars.add(car);
        notifyObservers();
    }

    public void removeCar(Car car) {
        availableCars.remove(car);
        notifyObservers();
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
    
    //Tydzień 6, Wzorzec Obserwator, tworzy system informowania użytkownika o zmianie na stanie dostępnych samochodów w menedzerze i
    //daje możliwość dołączenia lub odłączenia się od systemu za pomocą subskrybcji do systemu

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    // Koniec Tydzień 6, Wzorzec Obserwator
}
//Koniec Tydzień 1, Wzorzec Singleton