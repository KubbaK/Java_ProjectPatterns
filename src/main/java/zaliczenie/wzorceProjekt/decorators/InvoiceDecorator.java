package zaliczenie.wzorceProjekt.decorators;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.Invoice;
import zaliczenie.wzorceProjekt.models.Payment.Payment;
import zaliczenie.wzorceProjekt.models.Rent.Rent;
//Tydzień 3, dekorator, który pozwala na dokonanie płatności i wygenerowanie faktury
public class InvoiceDecorator implements Payment {
    protected Payment decoratedPayment;

    public InvoiceDecorator(Payment decoratedPayment) {
        this.decoratedPayment = decoratedPayment;
    }

    @Override
    public void pay(List<Rent> rents) {
        decoratedPayment.pay(rents);
        Invoice invoice = createInvoice(rents);
        invoice.printInvoice();
    }

    private Invoice createInvoice(List<Rent> rents) {
        float totalPrice = 0.0f;
        for(var rent : rents)
        {
            totalPrice += rent.getPrice();
        }
        return new Invoice("456", new Date(), "Customer", rents, totalPrice);
    }
}
//Tydzień 3, koniec dekoratora