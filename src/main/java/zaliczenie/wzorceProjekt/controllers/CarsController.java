package zaliczenie.wzorceProjekt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.services.CarsService;
import zaliczenie.wzorceProjekt.services.ICarsService;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarsController {

    @Qualifier("proxyCarsService")
    private final ICarsService carsService = new CarsService();

    @GetMapping("/eco")
    public List<Car> getEcoFriendlyCars() {
        return carsService.getAllEcoCars();
    }

    @GetMapping("/hello")
    public String greetings() {
        return "Hey";
    }
}
