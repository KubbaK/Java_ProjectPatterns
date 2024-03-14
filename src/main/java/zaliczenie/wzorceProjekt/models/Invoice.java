package zaliczenie.wzorceProjekt.models;

import java.util.Date;
import java.util.List;

public class Invoice {
    private String invoiceNumber;
    private Date date;
    private String customerName;
    private List<Car> cars; 

    public Invoice(String invoiceNumber, Date date, String customerName, List<Car> cars) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.customerName = customerName;
        this.cars = cars;
    }

    public void printInvoice() {
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Date: " + date);
        System.out.println("Customer: " + customerName);
        System.out.println("Cars:");
        for (Car car : cars) {
            System.out.println(car.getBrand() + " - " + car.getModel());
        }
    }
}
