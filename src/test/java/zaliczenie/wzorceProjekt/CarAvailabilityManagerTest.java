package zaliczenie.wzorceProjekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.observers.Observer;

import java.util.ArrayList;
import java.util.List;
import zaliczenie.wzorceProjekt.services.CarAvailabilityManager;

public class CarAvailabilityManagerTest {

    private CarAvailabilityManager carAvailabilityManager;
    private List<Car> availableCars;
    private List<Observer> observers;

    @BeforeEach
    public void setUp() {
        carAvailabilityManager = CarAvailabilityManager.getInstance();
        availableCars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Test
    public void testAddCar() {
        Car car = mock(Car.class);
        carAvailabilityManager.addCar(car);
        assertEquals(1, carAvailabilityManager.getAvailableCars().size());
        assertEquals(car, carAvailabilityManager.getAvailableCars().get(0));
        carAvailabilityManager.removeCar(car);
    }

    @Test
    public void testRemoveCar() {
        assertEquals(0, carAvailabilityManager.getAvailableCars().size());
        
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        
        carAvailabilityManager.addCar(car1);
        carAvailabilityManager.addCar(car2);
        assertEquals(2, carAvailabilityManager.getAvailableCars().size());
        carAvailabilityManager.removeCar(car1);
        assertEquals(1, carAvailabilityManager.getAvailableCars().size());
        assertEquals(car2, carAvailabilityManager.getAvailableCars().get(0));
        carAvailabilityManager.removeCar(car2);

    }

    @Test
    public void testGetAvailableCars() {
        Car car3 = mock(Car.class);
        Car car4 = mock(Car.class);
        availableCars.add(car3);
        availableCars.add(car4);
        carAvailabilityManager.addCar(car3);
        carAvailabilityManager.addCar(car4);
        assertEquals(availableCars, carAvailabilityManager.getAvailableCars());
        
        carAvailabilityManager.removeCar(car3);
        carAvailabilityManager.removeCar(car4);
    }

    @Test
    public void testGetAvailableEcoCars() {
        Car ecoCar1 = mock(Car.class);
        when(ecoCar1.isEco()).thenReturn(true);
        Car ecoCar2 = mock(Car.class);
        when(ecoCar2.isEco()).thenReturn(true);
        Car nonEcoCar = mock(Car.class);
        when(nonEcoCar.isEco()).thenReturn(false);

        availableCars.add(ecoCar1);
        availableCars.add(ecoCar2);
        availableCars.add(nonEcoCar);
        carAvailabilityManager.addCar(ecoCar1);
        carAvailabilityManager.addCar(ecoCar2);
        carAvailabilityManager.addCar(nonEcoCar);

        List<Car> expectedEcoCars = new ArrayList<>();
        expectedEcoCars.add(ecoCar1);
        expectedEcoCars.add(ecoCar2);

        assertEquals(expectedEcoCars, carAvailabilityManager.getAvailableEcoCars());
        assertEquals(2,carAvailabilityManager.getAvailableEcoCars().size());
        
        carAvailabilityManager.removeCar(ecoCar1);
        carAvailabilityManager.removeCar(ecoCar2);
        carAvailabilityManager.removeCar(nonEcoCar);
    }

    @Test
    public void testSubscribeAndNotifyObservers() {
        Observer observer1 = mock(Observer.class);
        Observer observer2 = mock(Observer.class);
        carAvailabilityManager.subscribe(observer1);
        carAvailabilityManager.subscribe(observer2);

        carAvailabilityManager.notifyObservers();

        verify(observer1, times(1)).update();
        verify(observer2, times(1)).update();
    }
}
