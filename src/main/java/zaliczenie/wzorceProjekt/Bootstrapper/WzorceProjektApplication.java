package zaliczenie.wzorceProjekt.Bootstrapper;

import zaliczenie.wzorceProjekt.models.Rent.CompositeRent;
import zaliczenie.wzorceProjekt.models.Rent.SingleRent;
import zaliczenie.wzorceProjekt.models.Rent.Rent;
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
import zaliczenie.wzorceProjekt.builders.RentBuilder;
import zaliczenie.wzorceProjekt.decorators.ReceiptDecorator;
import zaliczenie.wzorceProjekt.facade.CarRentFacade;
import zaliczenie.wzorceProjekt.facade.CarRentFacadeImpl;
import zaliczenie.wzorceProjekt.models.Payment.BasePayment;
import zaliczenie.wzorceProjekt.models.Payment.Payment;

@SpringBootApplication
public class WzorceProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(WzorceProjektApplication.class, args);

        CarAvailabilityManager carManager = CarAvailabilityManager.getInstance();

        var carEquipment1 = CarEquipmentFactory.getCarrEquipment("prestige", true, true, true);
        var carEquipment2 = CarEquipmentFactory.getCarrEquipment("prestige", true, true, true);

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
        
        System.out.println();
        Rent rent1 = new RentBuilder(tesla, "Adam Adamski", new Date())
                        .withEndDate(new Date())
                        .build();

        Rent rent2 = new RentBuilder(bmw, "Maciej Maciejski", new Date())
                        .withEndDate(new Date())
                        .build();

        Rent rent3 = new RentBuilder(bmw, "Adam Adamski", new Date())
                        .withEndDate(new Date())
                        .build();

        CompositeRent compositeRent = new CompositeRent();
        CompositeRent adamAdamskiCompositeRent = new CompositeRent();
        CompositeRent maciejMaciejskiCompositeRent = new CompositeRent();

        SingleRent firstRent= new SingleRent(rent1);
        SingleRent secondRent = new SingleRent(rent2);
        SingleRent thirdRent = new SingleRent(rent3);

        compositeRent.addRentComponent(firstRent);
        compositeRent.addRentComponent(secondRent);
        compositeRent.addRentComponent(thirdRent);

        adamAdamskiCompositeRent.addRentComponent(firstRent);
        adamAdamskiCompositeRent.addRentComponent(thirdRent);
        maciejMaciejskiCompositeRent.addRentComponent(secondRent);

        System.out.println("Wszystkie wypożyczenia:");
        compositeRent.printRentDetails();

        System.out.println("\nWypożyczenia Adama Adamskiego:");
        adamAdamskiCompositeRent.printRentDetails();

        System.out.println("\nWypożyczenia Macieja Maciejskiego:");
        maciejMaciejskiCompositeRent.printRentDetails();
        
        System.out.println();
        Payment payment = new BasePayment();
        payment = new ReceiptDecorator(payment);
        payment.pay();
        
        
        CarRentFacade carRentalFacade = new CarRentFacadeImpl(carManager);
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + (1000 * 60 * 60 * 24 * 7)); 

        carRentalFacade.rentCar("Monika Kowalska", bmw, startDate, endDate);

        boolean isAvailable = carRentalFacade.checkAvailability(bmw, startDate, endDate);
        System.out.println("Car is available: " + isAvailable);

        carRentalFacade.returnCar("Monika Kowalska", bmw);
    }

}
