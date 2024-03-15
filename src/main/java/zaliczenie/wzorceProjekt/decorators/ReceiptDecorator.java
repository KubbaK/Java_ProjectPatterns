package zaliczenie.wzorceProjekt.decorators;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.Payment.Payment;
import zaliczenie.wzorceProjekt.models.Receipt;
import zaliczenie.wzorceProjekt.models.Rent.Rent;
//Tydzień 3 dekorator, który pozwala na dokonanie płatności i wygenerowanie paragonu
public class ReceiptDecorator implements Payment {
    private Payment decoratedPayment;

    public ReceiptDecorator(Payment decoratedPayment) {
        this.decoratedPayment = decoratedPayment;
    }

    @Override
    public void pay(List<Rent> rents) {
        decoratedPayment.pay(rents);
        createReceipt(rents);
    }

    private void createReceipt(List<Rent> rents) {
        float totalPrice = 0.0f;
        for(var rent : rents)
        {
            totalPrice += rent.getPrice();
        }
        Receipt receipt = new Receipt("123", new Date(), "Klient", rents, totalPrice);
        receipt.printReceipt();
    }
}
//Tydzień 3, koniec dekoratora
