package zaliczenie.wzorceProjekt.Bootstrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zaliczenie.wzorceProjekt.domain.models.*;

@SpringBootApplication
public class WzorceProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(WzorceProjektApplication.class, args);
                
                CarAvailabilityManager carManager = CarAvailabilityManager.getInstance();
                ElectricCarFactory electricCarFactory = new ElectricCarFactory();
                carManager.addCar(electricCarFactory.createCar());

                CombustionCarFactory combustionCarFactory = new CombustionCarFactory();
                carManager.addCar(combustionCarFactory.createCar());

                System.out.println("Dostępne samochody:");
                for (Car car : carManager.getAvailableCars()) {
                    System.out.println(car.getModel());
                    }
                }

}
