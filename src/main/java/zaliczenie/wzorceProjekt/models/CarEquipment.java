package zaliczenie.wzorceProjekt.models;

public class CarEquipment {
    private String name;
    private boolean audioSystem;
    private boolean gpsNavigation;
    private boolean heatedSeats;

    public CarEquipment(String name, boolean audioSystem, boolean gpsNavigation, boolean heatedSeats) {
        this.name = name;
        this.audioSystem = audioSystem;
        this.gpsNavigation = gpsNavigation;
        this.heatedSeats = heatedSeats;
    }
}
