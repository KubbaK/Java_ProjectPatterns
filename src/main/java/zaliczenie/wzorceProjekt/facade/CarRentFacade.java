package zaliczenie.wzorceProjekt.facade;

import java.util.Date;
import zaliczenie.wzorceProjekt.models.Car;

public interface CarRentFacade {
    void rentCar(String customer, Car car, Date startDate, Date endDate);
    void returnCar(String customer, Car car);
    boolean checkAvailability(Car car, Date startDate, Date endDate);
}