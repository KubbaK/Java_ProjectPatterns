package zaliczenie.wzorceProjekt.models.Payment;

import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.Rent.Rent;

import java.util.List;

public class BasePayment implements Payment {
    @Override
    public void pay(List<Rent> rents) {
        System.out.println("Wykonano płatność.");
    }
}
