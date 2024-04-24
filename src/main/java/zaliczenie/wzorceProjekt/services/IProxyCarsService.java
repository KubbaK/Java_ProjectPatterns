package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.models.Car;

import java.util.List;

public interface IProxyCarsService {
    List<Car> getAllEcoCars();
    Car getCarById(int id);
}
