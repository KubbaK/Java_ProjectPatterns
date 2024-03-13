package zaliczenie.wzorceProjekt.exceptions;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(int carId) {
        super("Cannot find car with id = " + carId);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
