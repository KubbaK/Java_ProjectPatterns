package zaliczenie.wzorceProjekt.repositories;

import org.springframework.data.repository.CrudRepository;
import zaliczenie.wzorceProjekt.models.Car;

public interface CarRepo extends CrudRepository<Car,Integer> {
    
}
