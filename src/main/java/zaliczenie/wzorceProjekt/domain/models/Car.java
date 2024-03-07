package zaliczenie.wzorceProjekt.domain.models;

import org.hibernate.id.GUIDGenerator;

public abstract class Car {

    private int id;
    private String brand;
    private String model;
    private int production_date;
    private String color;
    private String photo_url;

    public Car() {
    }
    
    public Car(int id, String brand, String model, int production_date, String color, String photo_url) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.production_date = production_date;
        this.color = color;
        this.photo_url = photo_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProduction_date() {
        return production_date;
    }

    public void setProduction_date(int production_date) {
        this.production_date = production_date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Car DeepClone(Car car, Car copyCar){
        copyCar.brand = car.brand;
        copyCar.color = car.color;
        copyCar.photo_url = car.photo_url;
        copyCar.model = car.model;
        copyCar.production_date = car.production_date;
        return car;
    }

}
