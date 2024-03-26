package zaliczenie.wzorceProjekt.mediators;

import java.util.List;
import zaliczenie.wzorceProjekt.decorators.InvoiceDecorator;
import zaliczenie.wzorceProjekt.decorators.ReceiptDecorator;
import zaliczenie.wzorceProjekt.models.Rent.Rent;
//Tydzień 5, mediator, który służy do wewnętrznego przetwarzania płatności
public class PaymentMediator {
    private InvoiceDecorator invoiceDecorator;
    private ReceiptDecorator receiptDecorator;

    public PaymentMediator(InvoiceDecorator invoiceDecorator, ReceiptDecorator receiptDecorator) {
        this.invoiceDecorator = invoiceDecorator;
        this.receiptDecorator = receiptDecorator;
    }

    public void processPayment(List<Rent> rents) {
        float totalPrice = calculateTotalPrice(rents);
        approvePayment(totalPrice);

        invoiceDecorator.pay(rents);
        receiptDecorator.pay(rents);
    }

    private float calculateTotalPrice(List<Rent> rents) {
        float totalPrice = 0.0f;
        for (Rent rent : rents) {
            totalPrice += rent.getPrice();
        }
        return totalPrice;
    }

    private void approvePayment(float totalPrice) {
        System.out.println("Payment approved for total amount: " + totalPrice);
    }
}
//Tydzień 5, koniec mediatora