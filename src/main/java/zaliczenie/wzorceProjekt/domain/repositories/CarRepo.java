package zaliczenie.wzorceProjekt.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import zaliczenie.wzorceProjekt.domain.models.Car;

public interface CarRepo extends CrudRepository<Car,Integer> {
    
}
