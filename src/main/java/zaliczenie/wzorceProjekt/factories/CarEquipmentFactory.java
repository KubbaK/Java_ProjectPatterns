package zaliczenie.wzorceProjekt.factories;

import zaliczenie.wzorceProjekt.models.CarEquipment;

import java.util.HashMap;
import java.util.Map;

//Tydzień 3, Wzorzec Flyweight, dzięki niemu obiekty tego samego typu są tworzone tylko raz
public class CarEquipmentFactory {
    static Map<String, CarEquipment> carEquipments = new HashMap<>();

    public static CarEquipment getCarrEquipment(String name, Boolean audioSystem, Boolean gpsNavigation, Boolean heatedSeats) {
        CarEquipment result = carEquipments.get(name);
        if (result == null) {
            result = new CarEquipment(name, audioSystem, gpsNavigation, heatedSeats);
            carEquipments.put(name, result);
        }
        return result;
    }
}
//Koniec tydzien 3, Flyweight