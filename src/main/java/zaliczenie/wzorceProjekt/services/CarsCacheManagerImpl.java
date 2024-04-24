package zaliczenie.wzorceProjekt.services;

import org.springframework.stereotype.Service;
import zaliczenie.wzorceProjekt.models.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Tydzień 7, Zasada pojedynczej odpowiedzialności
// Ta klasa jest odpowiedzialna wyłącznie za zarządzanie pamięcią podręczną dla samochodów. Odpowiada za przechowywanie i aktualizację danych w pamięci podręcznej.
@Service
public class CarsCacheManagerImpl implements CarsCacheManager{
    private List<Car> ecoCarsCache = new ArrayList<>();
    private Map<Integer, Car> carsDictionaryCache = new HashMap<>();

    public List<Car> getAllEcoCars() {
        return ecoCarsCache;
    }

    public void setAllEcoCars(List<Car> ecoCars) {
        this.ecoCarsCache = ecoCars;
    }

    public Car getCarById(int id) {
        return carsDictionaryCache.get(id);
    }

    public void addCarToCache(int id, Car car) {
        carsDictionaryCache.put(id, car);
    }
}
//Koniec Tydzień 7, Zasada pojedynczej odpowiedzialności
