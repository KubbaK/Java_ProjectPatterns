package zaliczenie.wzorceProjekt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zaliczenie.wzorceProjekt.models.Car;

@Repository
public interface CarsRepository extends CrudRepository<Car,Integer> {
    
}
