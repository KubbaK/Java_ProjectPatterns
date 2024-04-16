package zaliczenie.wzorceProjekt.models.CarType;

public class Sedan extends CarType {
    public Sedan() {
        super(4, 5);
    }

    @Override
    public String getInfo() {
        return "Car type: Sedan, number of seats: " + numberOfSeats + ", number of doors: " + numberOfDoors;
    }
}