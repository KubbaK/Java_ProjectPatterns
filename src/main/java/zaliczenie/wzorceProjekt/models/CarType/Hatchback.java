package zaliczenie.wzorceProjekt.models.CarType;

public class Hatchback extends CarType {
    public Hatchback() {
        super(5, 3);
    }

    @Override
    public String getInfo() {
        return "Car type: Hatchback, number of seats: " + numberOfSeats + ", number of doors: " + numberOfDoors;
    }
}
