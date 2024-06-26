package zaliczenie.wzorceProjekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.ElectricCar;
import zaliczenie.wzorceProjekt.models.Fuel.DieselFuel;
import zaliczenie.wzorceProjekt.models.Fuel.ElectricFuel;
import zaliczenie.wzorceProjekt.models.Fuel.PetrolFuel;
import zaliczenie.wzorceProjekt.repositories.CarsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarsService implements ICarsService {

    private ArrayList<Car> carsToRepair;

    private CarsRepository carsRepository;

    @Override
    public List<Car> getAllEcoCars() {
        List<Car> ecoCars = new ArrayList<>();

        Iterable<Car> allCars = carsRepository.findAll();

        for (Car car : allCars) {
            if (car.isEco()) {
                ecoCars.add(car);
            }
        }

        return ecoCars;
    }

    @Override
    public Car getCarById(int id) {
        Optional<Car> carOptional = carsRepository.findById(id);
        return carOptional.orElse(null);
    }


    // Dodawanie samochodu do listy samochodow do naprawy
    public void addCar(Car car) {
        carsToRepair.add(car);
    }

    //Tydzień 7, Otwarte - zamknięte poprzez sterowanie danymi. Mamy kolekcję różnych obiektów na których wykonujemy określoną operację.
    // W tej liście mogą być różne obiekty np. ElectricCar, CombustionCar, a każdy z nich ma inną implementację metody repair,
    // więc działanie metody repairAllCars będzie zależne od tego jakie obiekty mamy w tej liście.
    public void repairCars() {
        for (Car car : carsToRepair) {
            car.repair();
        }
    }
    // Koniec Tydzień 7, Otwarte - zamknięte

    // Not used
    public boolean carIsEco(Car car) {
        boolean result = false;

        if (car.getFuel_type() instanceof DieselFuel) {
            result = false;
        } else if (car.getFuel_type() instanceof PetrolFuel) {
            result = false;
        } else if (car.getFuel_type() instanceof ElectricFuel) {
            result = true;
        }

        return result;
    }
}
