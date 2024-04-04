package zaliczenie.wzorceProjekt.strategy;

public class OrderShippedNotificationStrategy implements NotificationStrategy {
    @Override
    public String sendNotification(String message) {
        return "Twoje zamówienie zostało dostarczone! " + message;
    }
}
