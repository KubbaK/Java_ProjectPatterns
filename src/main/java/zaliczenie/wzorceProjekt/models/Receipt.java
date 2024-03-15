package zaliczenie.wzorceProjekt.models;

import zaliczenie.wzorceProjekt.models.Rent.Rent;

import java.util.Date;
import java.util.List;

public class Receipt {
    private String receiptNumber;
    private Date date;
    private String customerName;
    private List<Rent> rents;
    private float totalPrice;

    public Receipt(String receiptNumber, Date date, String customerName, List<Rent> rents, float totalPrice) {
        this.receiptNumber = receiptNumber;
        this.date = date;
        this.customerName = customerName;
        this.rents = rents;
        this.totalPrice = totalPrice;
    }

    // Metoda do wydruku paragonu
    public void printReceipt() {
        System.out.println("Receipt Number: " + receiptNumber);
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

