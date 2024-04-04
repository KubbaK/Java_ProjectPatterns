package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.strategy.NotificationStrategy;
//Tydzień 6, Wzorzec Strategy, w zależności od wybranej strategii wysyłana jest inna notyfikacja, która dodatkowo można modyfikować
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
//Koniec Tydzień 6, Wzorzec Strategy
}
