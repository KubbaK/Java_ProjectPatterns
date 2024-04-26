package zaliczenie.wzorceProjekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zaliczenie.wzorceProjekt.services.NotificationManager;
import zaliczenie.wzorceProjekt.strategy.NotificationStrategy;
import zaliczenie.wzorceProjekt.strategy.OrderShippedNotificationStrategy;
import zaliczenie.wzorceProjekt.strategy.PaymentReminderNotificationStrategy;
import zaliczenie.wzorceProjekt.strategy.RandomMessageNotificationStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


public class NotificationManagerTests {

    private NotificationManager notificationManager;

    @BeforeEach
    void setUp() {
        notificationManager = new NotificationManager();
    }

    @Test
    void addNotification_AddsNotificationToList() {
        NotificationStrategy mockNotification = mock(NotificationStrategy.class);
        notificationManager.addNotification(mockNotification);
        assertEquals(1, notificationManager.getNotifications().size());
    }

    @Test
    void sendNotifications_NoNotificationsAdded_NothingSent() {
        NotificationStrategy mockNotification1 = mock(RandomMessageNotificationStrategy.class);
        NotificationStrategy mockNotification2 = mock(PaymentReminderNotificationStrategy.class);
        NotificationStrategy mockNotification3 = mock(OrderShippedNotificationStrategy.class);

        notificationManager.sendNotifications();
        verifyNoInteractions(mockNotification1, mockNotification2, mockNotification3);
    }

    @Test
    void addNotification_AddNotification_NotificationAdded() {
        NotificationStrategy mockNotification = mock(RandomMessageNotificationStrategy.class);
        notificationManager.addNotification(mockNotification);
        assertTrue(notificationManager.getNotifications().contains(mockNotification));
    }

    @Test
    void sendNotifications_SendsNotificationsInOrder() {
        List<String> expectedMessages = new ArrayList<>();
        expectedMessages.add("Nowa wiadomość ");
        expectedMessages.add("Przypomnienie o płatności! ");
        expectedMessages.add("Twoje zamówienie zostało dostarczone! ");

        NotificationStrategy mockNotification1 = mock(RandomMessageNotificationStrategy.class);
        NotificationStrategy mockNotification2 = mock(PaymentReminderNotificationStrategy.class);
        NotificationStrategy mockNotification3 = mock(OrderShippedNotificationStrategy.class);

        notificationManager.addNotification(mockNotification1);
        notificationManager.addNotification(mockNotification2);
        notificationManager.addNotification(mockNotification3);

        notificationManager.sendNotifications();

        for (int i = 0; i < expectedMessages.size(); i++) {
            verify(mockNotification1).sendNotification("");
            verify(mockNotification2).sendNotification("");
            verify(mockNotification3).sendNotification("");
        }
    }

    @Test
    void sendNotifications_SendsCorrectMessage() {
        String message = "Test message";
        NotificationStrategy mockNotification = mock(RandomMessageNotificationStrategy.class);

        notificationManager.addNotification(mockNotification);
        notificationManager.sendNotifications();

        verify(mockNotification).sendNotification("");
    }
}
