package zaliczenie.wzorceProjekt.state;

import zaliczenie.wzorceProjekt.models.Rent.Rent;
//Tydzień 6, Wzorzec State, modyfikuje działanie metody rent w zależności od obecnego stanu 
public class FreeState implements State {
    private Rent rent;

    public FreeState(Rent rent) {
        this.rent = rent;
    }

    @Override
    public void rent() {
        System.out.println("Car is available for rent");
        rent.setState(new RentedState(rent));
    }

    @Override
    public void returnCar() {
        System.out.println("Car is already returned");
    }
}
// Koniec Tydzień 6, Wzorzec Rent