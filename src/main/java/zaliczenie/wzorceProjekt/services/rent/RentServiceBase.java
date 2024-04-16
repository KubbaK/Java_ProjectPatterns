package zaliczenie.wzorceProjekt.services.rent;

import org.springframework.http.ResponseEntity;
import zaliczenie.wzorceProjekt.dtos.RentCreateDto;

//Tydzień 8, Odwrócenie zależności
public abstract class RentServiceBase {

    public abstract ResponseEntity<String> createRent(RentCreateDto rentDto);

    public abstract ResponseEntity<String> removeRent(int id);

    public abstract void undo();
}
//Koniec tydzień 8, Odwrócenie zależności