package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.models.Car;

import java.util.List;

public interface CarsCacheManager {
    List<Car> getAllEcoCars();
    void setAllEcoCars(List<Car> ecoCars);
    Car getCarById(int id);
    void addCarToCache(int id, Car car);
}
