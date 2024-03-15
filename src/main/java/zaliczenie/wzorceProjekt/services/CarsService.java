package zaliczenie.wzorceProjekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.repositories.CarsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarsService implements ICarsService {

    @Autowired
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
}
