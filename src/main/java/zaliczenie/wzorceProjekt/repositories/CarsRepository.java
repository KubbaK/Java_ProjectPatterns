package zaliczenie.wzorceProjekt.repositories;

import org.springframework.data.repository.CrudRepository;
import zaliczenie.wzorceProjekt.models.Car;

public interface CarsRepository extends CrudRepository<Car,Integer> {
    
}
