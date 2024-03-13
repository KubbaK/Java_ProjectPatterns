package zaliczenie.wzorceProjekt.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import zaliczenie.wzorceProjekt.models.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Tydzień 3, Wzorzec Proxy, tworzy pełnomocnika który przechowuje dane w pamieci podręcznej
@Service
@Primary
public class ProxyCarsService implements ICarsService{
    private CarsService carsService = new CarsService();
    private List<Car> ecoCarsCache = new ArrayList<>();
    private Map<Integer, Car> carsDictionaryCache = new HashMap<>();

    @Override
    public List<Car> getAllEcoCars() {
        if (ecoCarsCache == null || ecoCarsCache.isEmpty()) {
            ecoCarsCache = carsService.getAllEcoCars();
        }
        return ecoCarsCache;
    }

    @Override
    public Car getCarById(int id) {
        if (carsDictionaryCache.containsKey(id)) {
            return carsDictionaryCache.get(id);
        } else {
            var car = carsService.getCarById(id);
            carsDictionaryCache.put(id, car);
            return car;
        }
    }
}
//Koniec Tydzień 3, Wzorzec Proxy