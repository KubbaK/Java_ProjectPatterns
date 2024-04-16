package zaliczenie.wzorceProjekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zaliczenie.wzorceProjekt.dtos.RentCreateDto;
import zaliczenie.wzorceProjekt.services.rent.RentServiceBase;
import zaliczenie.wzorceProjekt.services.rent.RentsService;

@Controller
@RequestMapping("api/v1/rents")
public class RentsController {

    @Autowired
    RentServiceBase rentsService;

    @PostMapping
    public ResponseEntity<String> createRent(@RequestBody RentCreateDto rent) {
        return rentsService.createRent(rent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRent(@PathVariable Integer id) {
        return rentsService.removeRent(id);
    }
}
