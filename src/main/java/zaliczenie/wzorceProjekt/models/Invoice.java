package zaliczenie.wzorceProjekt.models;

import zaliczenie.wzorceProjekt.models.Rent.Rent;

import java.util.Date;
import java.util.List;

public class Invoice {
    private String invoiceNumber;
    private Date date;
    private String customerName;
    private List<Rent> rents;
    private float totalPrice;

    public Invoice(String invoiceNumber, Date date, String customerName, List<Rent> rents, float totalPrice) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.customerName = customerName;
        this.rents = rents;
        this.totalPrice = totalPrice;
    }

    public void printInvoice() {
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Date: " + date);
        System.out.println("Customer: " + customerName);
        System.out.println("Cars:");
        for (Rent rent : rents) {
            System.out.println(rent.getCar().getBrand() + " - " + rent.getCar().getModel());
        }
        System.out.println("Total Price: " + totalPrice);
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
