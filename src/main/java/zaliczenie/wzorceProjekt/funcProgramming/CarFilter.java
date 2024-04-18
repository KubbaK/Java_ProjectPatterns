package zaliczenie.wzorceProjekt.funcProgramming;
import zaliczenie.wzorceProjekt.models.Car;

@FunctionalInterface
public interface CarFilter {
    boolean filter(Car car);
}