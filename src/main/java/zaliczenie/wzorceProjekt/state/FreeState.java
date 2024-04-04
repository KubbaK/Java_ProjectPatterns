package zaliczenie.wzorceProjekt.state;

import zaliczenie.wzorceProjekt.models.Rent.Rent;

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
