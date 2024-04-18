package zaliczenie.wzorceProjekt.models.Payment;

import zaliczenie.wzorceProjekt.models.Rent.Rent;

import java.util.List;

//Tydzień 7, Otwarte - zamknięte poprzez abstrakcję
public interface Payment {
    void pay(List<Rent> rents);
}
//Koniec tydzień 7, Otwarte - zamknięte