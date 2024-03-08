package zaliczenie.wzorceProjekt.domain.models;

import java.util.Date;
//Tydzień 1, Wzorzec Budowniczy, budowniczy służy do wytworzenia obiektu wypożyczenia
public class RentBuilder {
    private Rent rent;

    public RentBuilder(Car car, String customerName, Date startDate) {
        rent = new Rent();
        rent.setCar(car);
        rent.setCustomerName(customerName);
        rent.setStartDate(startDate);
    }

    public RentBuilder withEndDate(Date endDate) {
        rent.setEndDate(endDate);
        return this;
    }

    public Rent build() {
        return rent;
    }
}
//Koniec tydzień 1, Wzorzec Budowniczy