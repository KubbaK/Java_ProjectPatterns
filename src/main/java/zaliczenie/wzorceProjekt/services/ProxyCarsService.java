package zaliczenie.wzorceProjekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import zaliczenie.wzorceProjekt.models.Car;

import java.util.List;

//Tydzień 4, Wzorzec Proxy, tworzy pełnomocnika który przechowuje dane w pamieci podręcznej
//Tydzień 7, Zasada pojedynczej odpowiedzialności
//Ta klasa jest odpowiedzialna wyłącznie za obsługę żądań proxy i delegowanie ich do właściwego serwisu. Odpowiada za komunikację z zewnętrznym światem i udostępnianie interfejsu do pobierania danych o samochodach.
//Tydzień 7, Otwarte - zamknięte poprzez abstrakcję. Umożliwia wstrzyknięcie różnych implementacji pod carsService oraz cacheManager przez co można zmienić działanie metod bez ingerencji w nie.
@Service
@Primary
public class ProxyCarsService implements IProxyCarsService {

    @Autowired
    private ICarsService carsService;

    @Autowired
    private CarsCacheManager cacheManager;


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
//Koniec Tydzień 7, Otwarte - zamknięte poprzez abstrakcję.