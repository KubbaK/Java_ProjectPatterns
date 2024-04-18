package zaliczenie.wzorceProjekt.models.CarType;

//Tydzień 7, Otwarte - zamknięte poprzez abstrakcję
//Tydzień 8, Liskov
public abstract class CarType {
    protected int numberOfSeats;
    protected int numberOfDoors;

    public CarType(int numberOfSeats, int numberOfDoors) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
    }

    public abstract String getInfo();
}
//Koniec tydzień 8, Liskov
//Koniec tydzień 7, Otwarte - zamknięte

