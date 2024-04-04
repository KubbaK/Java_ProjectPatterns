package zaliczenie.wzorceProjekt.state;

import zaliczenie.wzorceProjekt.models.Rent.Rent;

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



