package zaliczenie.wzorceProjekt.iterators;

import zaliczenie.wzorceProjekt.models.Car;

import java.util.List;


public class CarIteratorImpl implements Iterator<Car>{
    private List<Car> cars;
    private int index;

    public CarIteratorImpl(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean hasNext() {
        return index < cars.size();
    }

    @Override
    public Car next() {
        return cars.get(index++);
    }
}
