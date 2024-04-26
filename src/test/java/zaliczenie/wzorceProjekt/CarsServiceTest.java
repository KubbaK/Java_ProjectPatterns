package zaliczenie.wzorceProjekt;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.Fuel.ElectricFuel;
import zaliczenie.wzorceProjekt.repositories.CarsRepository;
import zaliczenie.wzorceProjekt.services.CarsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import zaliczenie.wzorceProjekt.models.Fuel.DieselFuel;
import zaliczenie.wzorceProjekt.models.Fuel.PetrolFuel;

public class CarsServiceTest {

    @Mock
    private CarsRepository carsRepository;

    private List<Car> carsToRepair = new ArrayList<>();
  

    @InjectMocks
    private CarsService carsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        carsToRepair = new ArrayList<>();
        Field field = null;
    try {
        field = CarsService.class.getDeclaredField("carsRepository");
        field.setAccessible(true);
        field.set(carsService, carsRepository);
    } catch (NoSuchFieldException | IllegalAccessException e) {
        e.printStackTrace();
    }
    }

    @Test
    public void testGetAllEcoCars() {
        Car ecoCar1 = mock(Car.class);
        when(ecoCar1.getId()).thenReturn(1);
        when(ecoCar1.getBrand()).thenReturn("Tesla");
        when(ecoCar1.getModel()).thenReturn("Model S");

        Car ecoCar2 = mock(Car.class);
        when(ecoCar2.getId()).thenReturn(2);
        when(ecoCar2.getBrand()).thenReturn("Nissan");
        when(ecoCar2.getModel()).thenReturn("Leaf");

        Car nonEcoCar = mock(Car.class);

        List<Car> allCars = new ArrayList<>();
        allCars.add(ecoCar1);
        allCars.add(nonEcoCar);
        allCars.add(ecoCar2);

        when(carsRepository.findAll()).thenReturn(allCars);

        List<Car> result = carsService.getAllEcoCars();

        assertEquals(0, result.size());
    }

    @Test
    public void testGetCarById() {
        Car electricCar = mock(Car.class);
        when(electricCar.getId()).thenReturn(1);
        when(electricCar.getBrand()).thenReturn("Tesla");
        when(electricCar.getModel()).thenReturn("Model S");


        when(carsRepository.findById(1)).thenReturn(Optional.of(electricCar));

        Car result = carsService.getCarById(1);

        assertEquals(1, result.getId());
        assertEquals("Tesla", result.getBrand());
        assertEquals("Model S", result.getModel());
    }

    @Test
    public void testCarIsEco() {
        
        Car electricCar = mock(Car.class);
        when(electricCar.getFuel_type()).thenReturn(new ElectricFuel());

        Car dieselCar = mock(Car.class);
        when(dieselCar.getFuel_type()).thenReturn(new DieselFuel()); 

        Car petrolCar = mock(Car.class);
        when(petrolCar.getFuel_type()).thenReturn(new PetrolFuel());

        
        assertTrue(carsService.carIsEco(electricCar)); 
        assertFalse(carsService.carIsEco(dieselCar));
        assertFalse(carsService.carIsEco(petrolCar)); 
    }
    @Test
    public void testRepairCars() {
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);

        List<Car> carsToRepair = new ArrayList<>();
        carsToRepair.add(car1);
        carsToRepair.add(car2);

        try {
            Field field = CarsService.class.getDeclaredField("carsToRepair");
            field.setAccessible(true);
            field.set(carsService, carsToRepair);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        when(carsRepository.findAll()).thenReturn(carsToRepair);

        carsService.repairCars();

        verify(car1, times(1)).repair();
        verify(car2, times(1)).repair();
    }

    @Test
    public void testRepairCars_NoCarsToRepair() {
        when(carsRepository.findById(1)).thenReturn(Optional.empty());
        Car result = carsService.getCarById(1);
        assertEquals(null, result);
    }
}
