package zaliczenie.wzorceProjekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.services.ICarsService;
import zaliczenie.wzorceProjekt.services.IProxyCarsService;

import java.util.List;

//Tydzień 7, Otwarte - zamknięte poprzez abstrakcję. Umożliwia wstrzyknięcie różnych implementacji pod carsService przez co zmieni się np. działanie metody getEcoFriendlyCars
@RestController
@RequestMapping("api/v1/cars")
public class CarsController {

    @Autowired
    private IProxyCarsService carsService;


    @GetMapping("/eco")
    public List<Car> getEcoFriendlyCars() {
        return carsService.getAllEcoCars();
    }

    @GetMapping("/hello")
    public String greetings() {
        return "Hey";
    }
}
//Koniec Tydzień 7, Otwarte - zamknięte poprzez abstrakcję.