package zaliczenie.wzorceProjekt.Bootstrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import zaliczenie.wzorceProjekt.controllers.CarsController;
import zaliczenie.wzorceProjekt.factories.CarEquipmentFactory;
import zaliczenie.wzorceProjekt.factories.CombustionCarFactory;
import zaliczenie.wzorceProjekt.factories.ElectricCarFactory;
import zaliczenie.wzorceProjekt.models.*;
import zaliczenie.wzorceProjekt.models.Fuel.ElectricFuel;
import zaliczenie.wzorceProjekt.models.Fuel.PetrolFuel;
import zaliczenie.wzorceProjekt.services.CarAvailabilityManager;
import zaliczenie.wzorceProjekt.services.ICarsService;
import zaliczenie.wzorceProjekt.services.ProxyCarsService;

import java.util.Date;

@SpringBootApplication
public class WzorceProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(WzorceProjektApplication.class, args);

        CarAvailabilityManager carManager = CarAvailabilityManager.getInstance();

        var carEquipment1 = CarEquipmentFactory.getCarrEquipment("prestige", true, true, true);
        var carEquipment2 = CarEquipmentFactory.getCarrEquipment("prestige2", true, true, true);

        var tesla = ElectricCarFactory.CreateCar(1, "Tesla", "X",
                new Date(), "Red", "", new ElectricFuel(), carEquipment1,"1000");

        var bmw = CombustionCarFactory.CreateCar(2, "BMW", "M3",
                new Date(), "Black", "", new PetrolFuel(), carEquipment2,"3000");

        var tesla2 = tesla.DeepClone(tesla);
        tesla2.setModel("S");

        carManager.addCar(tesla);
        carManager.addCar(bmw);
        carManager.addCar(tesla2);

        System.out.println("Dostępne samochody:");
        for (Car car : carManager.getAvailableCars()) {
            System.out.println(car.getModel());
        }

        System.out.println("Samochody eco:");
        var ecoCars = carManager.getAvailableEcoCars();
        for (Car car : ecoCars) {
            System.out.println(car.getModel());
        }

        if (carEquipment1 == carEquipment2) {
            System.out.println("carEquipment1 i carEquipment2 wskazuja na ten sam obiekt");
        } else {
            System.out.println("carEquipment1 i carEquipment2 wskazuja na inne obiekty");
        }
    }

}
