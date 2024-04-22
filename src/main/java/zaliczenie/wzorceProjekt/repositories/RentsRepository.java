package zaliczenie.wzorceProjekt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import zaliczenie.wzorceProjekt.models.Rent.Rent;

@NoRepositoryBean
public interface RentsRepository extends CrudRepository<Rent,Integer> {

}
