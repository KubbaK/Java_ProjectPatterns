package zaliczenie.wzorceProjekt.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import zaliczenie.wzorceProjekt.models.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Tydzień 4, Wzorzec Proxy, tworzy pełnomocnika który przechowuje dane w pamieci podręcznej
//Tydzień 7, Zasada pojedynczej odpowiedzialności
//Ta klasa jest odpowiedzialna wyłącznie za obsługę żądań proxy i delegowanie ich do właściwego serwisu. Odpowiada za komunikację z zewnętrznym światem i udostępnianie interfejsu do pobierania danych o samochodach.
@Service
@Primary
public class ProxyCarsService implements ICarsService{
    private CarsService carsService = new CarsService();
    private CarsCacheManager cacheManager = new CarsCacheManagerImpl();

    @Override
    public List<Car> getAllEcoCars() {
        List<Car> ecoCars = cacheManager.getAllEcoCars();
        if (ecoCars.isEmpty()) {
            ecoCars = carsService.getAllEcoCars();
            cacheManager.setAllEcoCars(ecoCars);
        }
        return ecoCars;
    }

    @Override
    public Car getCarById(int id) {
        Car car = cacheManager.getCarById(id);
        if (car == null) {
            car = carsService.getCarById(id);
            cacheManager.addCarToCache(id, car);
        }
        return car;
    }
}
//Koniec Tydzień 4, Wzorzec Proxy
//Koniec Tydzień 7, Zasada pojedynczej odpowiedzialności