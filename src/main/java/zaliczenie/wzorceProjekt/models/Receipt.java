package zaliczenie.wzorceProjekt.models;

import java.util.Date;
import java.util.List;

public class Receipt {
    private String receiptNumber;
    private Date date;
    private String customerName;
    private List<Car> cars;

    public Receipt(String receiptNumber, Date date, String customerName, List<Car> cars) {
        this.receiptNumber = receiptNumber;
        this.date = date;
        this.customerName = customerName;
        this.cars = cars;
    }

    // Metoda do wydruku paragonu
    public void printReceipt() {
        System.out.println("Receipt Number: " + receiptNumber);
        System.out.println("Date: " + date);
        System.out.println("Customer: " + customerName);
        System.out.println("Items:");
        for (Car car : cars) {
            System.out.println(car.getBrand() + " - " + car.getModel());
        }
    }
}

