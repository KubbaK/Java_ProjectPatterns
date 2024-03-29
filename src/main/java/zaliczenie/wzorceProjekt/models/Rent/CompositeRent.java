package zaliczenie.wzorceProjekt.models.Rent;

import zaliczenie.wzorceProjekt.models.Rent.RentComponent;
import java.util.ArrayList;
import java.util.List;
//Tydzień 3, kompozyt, grupujący komponenty wypożyczenia
public class CompositeRent implements RentComponent{
    private List<RentComponent> rentComponents = new ArrayList<>();

    public void addRentComponent(RentComponent rentComponent) {
        rentComponents.add(rentComponent);
    }

    public void removeRentComponent(RentComponent rentComponent) {
        rentComponents.remove(rentComponent);
    }

    @Override
    public void printRentDetails() {
        for (RentComponent rentComponent : rentComponents) {
            rentComponent.printRentDetails();
        }
    }
    
}
//Tydzień 3, koniec wzorca kompozyt