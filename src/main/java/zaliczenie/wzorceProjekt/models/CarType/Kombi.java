package zaliczenie.wzorceProjekt.models.CarType;

public class Kombi extends CarType {
    public Kombi() {
        super(5, 5);
    }

    @Override
    public String getInfo() {
        return "Car type: Kombi, number of seats: " + numberOfSeats + ", number of doors: " + numberOfDoors;
    }
}
