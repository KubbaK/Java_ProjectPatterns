package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.models.Car;

import java.util.List;

//Tydzień 8, Odwrócenie zależności
public interface CarsCacheManager {
    List<Car> getAllEcoCars();
    void setAllEcoCars(List<Car> ecoCars);
    Car getCarById(int id);
    void addCarToCache(int id, Car car);
}
//Koniec tydzień 8, Odwrócenie zależności