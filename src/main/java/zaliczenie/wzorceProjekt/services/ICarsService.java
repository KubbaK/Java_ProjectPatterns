package zaliczenie.wzorceProjekt.services;

import org.springframework.stereotype.Service;
import zaliczenie.wzorceProjekt.models.Car;

import java.util.List;

@Service
public interface ICarsService {
    List<Car> getAllEcoCars();
    Car getCarById(int id);
}
