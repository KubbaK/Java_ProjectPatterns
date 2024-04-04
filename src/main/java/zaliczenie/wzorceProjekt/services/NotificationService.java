package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.strategy.NotificationStrategy;

public class NotificationService {
    private NotificationStrategy notificationStrategy;

    public NotificationService(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void notifyCustomer(String message) {
        String notificationContent = notificationStrategy.sendNotification(message);
        System.out.println("Nowa notyfikacja: " + notificationContent);
    }
}
