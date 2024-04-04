package zaliczenie.wzorceProjekt.state;

import zaliczenie.wzorceProjekt.models.Rent.Rent;
//Tydzień 6, Wzorzec State, modyfikuje działanie metody rent w zależności od obecnego stanu 
public class RentedState implements State {
    private Rent rent;

    public RentedState(Rent rent) {
        this.rent = rent;
    }

    @Override
    public void rent() {
        System.out.println("Car is already rented");
    }

    @Override
    public void returnCar() {
        rent.setState(new FreeState(rent));
        System.out.println("Car is returned");
    }
}
// Koniec Tydzień 6, Wzorzec Rent


