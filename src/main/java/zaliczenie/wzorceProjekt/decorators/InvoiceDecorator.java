package zaliczenie.wzorceProjekt.decorators;

import java.util.Arrays;
import java.util.Date;
import zaliczenie.wzorceProjekt.models.Invoice;
import zaliczenie.wzorceProjekt.models.Payment.Payment;

public class InvoiceDecorator implements Payment {
    protected Payment decoratedPayment;

    public InvoiceDecorator(Payment decoratedPayment) {
        this.decoratedPayment = decoratedPayment;
    }

    @Override
    public void pay() {
        decoratedPayment.pay();
        Invoice invoice = createInvoice();
        invoice.printInvoice();
    }

    private Invoice createInvoice() {
        return new Invoice("456", new Date(), "Customer", Arrays.asList());
    }
}
