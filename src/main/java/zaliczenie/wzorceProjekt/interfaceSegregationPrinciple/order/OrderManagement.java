package zaliczenie.wzorceProjekt.interfaceSegregationPrinciple.order;

//Tydzień 8, Zasada segregacji interfejsów
public interface OrderManagement {
    void createOrder();
    void cancelOrder();
    void processPayment();
    void updateOrderStatus();
    void generateInvoice();
    void calculateShippingCost();
    void applyDiscount();
}

interface BasicOrderOperations {
    void createOrder();
    void cancelOrder();
    void updateOrderStatus();
    void trackOrder();
}

interface PaymentOperations {
    void processPayment();
    void generateInvoice();
}

interface ShippingAndDiscountOperations {
    void calculateShippingCost();
    void applyDiscount();
}
//Koniec Tydzień 8, Zasada segregacji interfejsów