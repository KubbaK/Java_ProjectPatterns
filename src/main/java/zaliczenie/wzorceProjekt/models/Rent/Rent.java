package zaliczenie.wzorceProjekt.models.Rent;

import java.util.Date;
import zaliczenie.wzorceProjekt.models.Car;
import zaliczenie.wzorceProjekt.models.CombustionCar;
import zaliczenie.wzorceProjekt.models.ElectricCar;
import zaliczenie.wzorceProjekt.services.CarPriceCalculator;
import zaliczenie.wzorceProjekt.services.CombustionCarPriceAdapter;
import zaliczenie.wzorceProjekt.services.ElectricCarPriceAdapter;
import zaliczenie.wzorceProjekt.services.ICarPriceService;
import zaliczenie.wzorceProjekt.state.FreeState;
import zaliczenie.wzorceProjekt.state.State;

public class Rent {
    private Long id;
    private Car car;
    private String customerName;
    private Date startDate;
    private Date endDate;
    private float price;
    private State state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        ICarPriceService carPriceService = null;

        if (car instanceof ElectricCar) {
            this.price = new ElectricCarPriceAdapter(new CarPriceCalculator()).calculatePrice(car.getPrice());
        } else if (car instanceof CombustionCar) {
            this.price = new CombustionCarPriceAdapter(new CarPriceCalculator(),((CombustionCar) car).getFuelTankCapacity()*7)
                    .calculatePrice(car.getPrice());
        }
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    public Rent() {
        this.state = new FreeState(this);
    }

    public void rent() {
        state.rent();
    }

    public void returnCar() {
        state.returnCar();
    }

    public void setState(State state) {
        this.state = state;
    }
    
}