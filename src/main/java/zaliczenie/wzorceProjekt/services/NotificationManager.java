package zaliczenie.wzorceProjekt.services;

import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.strategy.NotificationStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NotificationManager {
    private List<NotificationStrategy> notifications = new ArrayList<>();

    public void addNotification(NotificationStrategy notificationStrategy) {
        notifications.add(notificationStrategy);
    }

    //Tydzień 7, Otwarte - zamknięte poprzez sterowanie danymi. Mamy kolekcję różnych obiektów na których wykonujemy określoną operację w określonej kolejności. W tym przypadku rozne rodzaje powiadomien.
    public void sendNotifications() {
        for (NotificationStrategy notification : notifications) {
            notification.sendNotification("");
        }
    }
    // Koniec Tydzień 7, Otwarte - zamknięte
}
