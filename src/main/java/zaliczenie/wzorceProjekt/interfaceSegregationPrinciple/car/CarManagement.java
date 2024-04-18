package zaliczenie.wzorceProjekt.interfaceSegregationPrinciple.car;

//Tydzień 8, Zasada segregacji interfejsów
public interface CarManagement {
    void addCar();
    void removeCar();
    void updateCar();
    void getCarDetails();
    void adjustInventory();
    void generateLicensePlate();
    void calculateRentalPrice();
    void trackCarHistory();
}

interface BasicCarOperations {
    void addCar();
    void removeCar();
    void updateCar();
    void getCarDetails();
}

// Interfejs związany z operacjami na stanie samochodów w wypożyczalni
interface InventoryOperations {
    void adjustInventory();
    void trackCarHistory();
}

// Interfejs związany z operacjami związanymi z generowaniem tablic rejestracyjnych i obliczaniem cen wynajmu
interface LicensePlateAndPriceOperations {
    void generateLicensePlate();
    void calculateRentalPrice();
}
//Koniec Tydzień 8, Zasada segregacji interfejsów