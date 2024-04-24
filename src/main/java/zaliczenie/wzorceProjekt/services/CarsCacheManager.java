package zaliczenie.wzorceProjekt.services;

import org.springframework.stereotype.Service;
import zaliczenie.wzorceProjekt.models.Car;

import java.util.List;

//Tydzień 8, Odwrócenie zależności
@Service
public interface CarsCacheManager {
    List<Car> getAllEcoCars();
    void setAllEcoCars(List<Car> ecoCars);
    Car getCarById(int id);
    void addCarToCache(int id, Car car);
}
//Koniec tydzień 8, Odwrócenie zależności