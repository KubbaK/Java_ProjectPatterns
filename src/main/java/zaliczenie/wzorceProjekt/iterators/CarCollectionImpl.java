package zaliczenie.wzorceProjekt.iterators;

import zaliczenie.wzorceProjekt.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarCollectionImpl implements Collection<Car>{

    private List<Car> cars = new ArrayList<>();

    @Override
    public void addCar(Car element) {
        cars.add(element);
    }

    @Override
    public void removeCar(Car element) {
        cars.remove(element);
    }

    @Override
    public Iterator<Car> iterator() {
        return new CarIteratorImpl(cars);
    }
}
