package zaliczenie.wzorceProjekt.domain.models;

import java.util.Date;

public class RentBuilder {
    private Rent rent;

    public RentBuilder() {
        rent = new Rent();
    }

    public RentBuilder withCar(Car car) {
        rent.setCar(car);
        return this;
    }

    public RentBuilder withCustomerName(String customerName) {
        rent.setCustomerName(customerName);
        return this;
    }

    public RentBuilder withStartDate(Date startDate) {
        rent.setStartDate(startDate);
        return this;
    }

    public RentBuilder withEndDate(Date endDate) {
        rent.setEndDate(endDate);
        return this;
    }

    public Rent build() {
        return rent;
    }
}
