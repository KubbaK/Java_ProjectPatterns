package zaliczenie.wzorceProjekt.Bootstrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zaliczenie.wzorceProjekt.domain.models.*;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class WzorceProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(WzorceProjektApplication.class, args);
                
                CarAvailabilityManager carManager = CarAvailabilityManager.getInstance();


                var tesla = ElectricCarFactory.CreateCar(1, "Tesla", "X",
                new Date(), "Red", "", new FuelType("Electric"), "1000");

                var bmw = CombustionCarFactory.CreateCar(2, "BMW", "M3",
                        new Date(), "Black", "", new FuelType("Petrol"), "3000");

                var tesla2 = tesla.DeepClone(tesla);
                tesla2.setModel("S");

                carManager.addCar(tesla);
                carManager.addCar(bmw);
                carManager.addCar(tesla2);



                System.out.println("Dostępne samochody:");
                for (Car car : carManager.getAvailableCars()) {
                    System.out.println(car.getModel());
                    }
                }

}
