package zaliczenie.wzorceProjekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;
import zaliczenie.wzorceProjekt.services.CarsCacheManagerImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CarsCacheManagerImplTests {
    private CarsCacheManagerImpl carsCacheManager;

    @BeforeEach
    void setUp() {
        carsCacheManager = new CarsCacheManagerImpl();
    }

    @Test
    void getAllEcoCars_ReturnsEmptyList_WhenNoCarsAdded() {
        List<Car> ecoCars = carsCacheManager.getAllCars();
        assertEquals(0, ecoCars.size());
    }

    @Test
    void setAllEcoCars_SetsEcoCarsList() {
        List<Car> ecoCars = Arrays.asList(new ElectricCar(), new CombustionCar());
        carsCacheManager.setAllCars(ecoCars);
        assertEquals(2, carsCacheManager.getAllCars().size());
    }

    @Test
    void getCarById_ReturnsNull_WhenCarNotInCache() {
        assertNull(carsCacheManager.getCarById(1));
    }

    @Test
    void addCarToCache_AddsCarToDictionary() {
        Car car = new ElectricCar();
        carsCacheManager.addCarToCache(1, car);
        assertEquals(car, carsCacheManager.getCarById(1));
    }

    @Test
    void addCarToCache_OverridesExistingCar() {
        Car car1 = new ElectricCar();
        Car car2 = new CombustionCar();
        carsCacheManager.addCarToCache(1, car1);
        carsCacheManager.addCarToCache(1, car2);
        assertEquals(car2, carsCacheManager.getCarById(1));
    }
}
