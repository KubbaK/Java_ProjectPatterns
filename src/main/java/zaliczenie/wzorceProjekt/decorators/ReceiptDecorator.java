package zaliczenie.wzorceProjekt.decorators;

import java.util.Collections;
import java.util.Date;
import zaliczenie.wzorceProjekt.models.Payment.Payment;
import zaliczenie.wzorceProjekt.models.Receipt;

public class ReceiptDecorator implements Payment {
    private Payment decoratedPayment;

    public ReceiptDecorator(Payment decoratedPayment) {
        this.decoratedPayment = decoratedPayment;
    }

    @Override
    public void pay() {
        decoratedPayment.pay();
        createReceipt();
    }

    private void createReceipt() {
        Receipt receipt = new Receipt("123", new Date(), "Klient", Collections.emptyList());
        receipt.printReceipt();
    }
}
