package zaliczenie.wzorceProjekt.exceptions;

public class RentNotFoundException extends RuntimeException{
    public RentNotFoundException(int rentId) {
        super("Cannot find rent with id = " + rentId);
    }
}
