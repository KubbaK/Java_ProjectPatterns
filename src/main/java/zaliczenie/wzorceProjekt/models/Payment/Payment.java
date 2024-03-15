package zaliczenie.wzorceProjekt.models.Payment;

import zaliczenie.wzorceProjekt.models.Rent.Rent;

import java.util.List;

public interface Payment {
    void pay(List<Rent> rents);
}
