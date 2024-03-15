package zaliczenie.wzorceProjekt.models;

import zaliczenie.wzorceProjekt.models.Fuel.IFuelType;

import java.util.Date;

public abstract class Car {

    private int id;
    private String brand;
    private String model;
    private Date production_date;
    private String color;
    private String photo_url;
    private IFuelType fuel_type;
    private CarEquipment carEquipment;
    private float price;
    public Car() {
    }
    
    public Car(int id, String brand, String model, Date production_date, String color, String photo_url, IFuelType fuel_type, CarEquipment carEquipment, float price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.production_date = production_date;
        this.color = color;
        this.photo_url = photo_url;
        this.fuel_type = fuel_type;
        this.carEquipment = carEquipment;
        this.price = price;
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

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
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
    //Tydzien 1, prototyp pozwalający na klonowanie samochodu
    public Car DeepClone(Car car, Car copyCar){
        copyCar.brand = car.brand;
        copyCar.color = car.color;
        copyCar.photo_url = car.photo_url;
        copyCar.model = car.model;
        copyCar.production_date = car.production_date;
        copyCar.fuel_type = car.fuel_type;
        copyCar.carEquipment = car.carEquipment;
        copyCar.price = car.price;
        return car;
    }
    //Koniec tydzien 1, prototyp

    public IFuelType getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(IFuelType fuel_type) {
        this.fuel_type = fuel_type;
    }

    //Tydzień 2, Wzorzec Bridge, pozwala na ustawienie różnych typów paliw i pobranie informacji czy są eco
    public Boolean isEco() {
        return fuel_type.isEco();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    //Koniec tydzien 2, Bridge
}
