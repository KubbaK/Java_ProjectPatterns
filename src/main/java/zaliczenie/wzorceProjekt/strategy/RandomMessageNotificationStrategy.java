package zaliczenie.wzorceProjekt.strategy;

public class RandomMessageNotificationStrategy implements NotificationStrategy {
    @Override
    public String sendNotification(String message) {
        return "Nowa wiadomość " + message;
    }
}
