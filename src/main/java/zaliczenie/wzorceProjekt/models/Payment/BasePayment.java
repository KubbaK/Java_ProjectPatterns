package zaliczenie.wzorceProjekt.models.Payment;

public class BasePayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Wykonano płatność.");
    }
}
