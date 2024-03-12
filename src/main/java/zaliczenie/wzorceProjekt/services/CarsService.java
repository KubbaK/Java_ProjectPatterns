package zaliczenie.wzorceProjekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.repositories.CarsRepository;

import java.util.ArrayList;
import java.util.List;

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
}
