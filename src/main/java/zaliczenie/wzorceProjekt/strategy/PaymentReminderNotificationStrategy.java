package zaliczenie.wzorceProjekt.strategy;

public class PaymentReminderNotificationStrategy implements NotificationStrategy {
    @Override
    public String sendNotification(String message) {
        return "Przypomnienie o płatności! " + message;
    }
}