package zaliczenie.wzorceProjekt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import zaliczenie.wzorceProjekt.models.Car;

@NoRepositoryBean
public interface CarsRepository extends CrudRepository<Car,Integer> {
    
}
