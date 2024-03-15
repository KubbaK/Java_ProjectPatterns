package zaliczenie.wzorceProjekt.facade;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.services.CarAvailabilityManager;

public class CarRentFacadeImpl implements CarRentFacade {
    private CarAvailabilityManager availabilityManager;

    @Autowired
    public CarRentFacadeImpl(CarAvailabilityManager availabilityManager) {
        this.availabilityManager = availabilityManager;
    }

    @Override
    public void rentCar(String customer, Car car, Date startDate, Date endDate) {
        if (availabilityManager.getAvailableCars().contains(car)) {
            availabilityManager.removeCar(car);
            System.out.println("Car " + car.getModel() + " rented by " + customer + " from " + startDate + " to " + endDate);
        } else {
            System.out.println("Car is not available for rental.");
        }
    }

    @Override
    public void returnCar(String customer, Car car) {
        availabilityManager.addCar(car);
        System.out.println("Car " + car.getModel() + " returned by " + customer);
    }

    @Override
    public boolean checkAvailability(Car car, Date startDate, Date endDate) {
        List<Car> availableCars = availabilityManager.getAvailableCars();
        return availableCars.contains(car);
    }
}
