package models;

public class Car {
    private String model;
    private double price;
    private double fuelConsumption;
    private double speed;

    public Car(String model, double price, double fuelConsumption, double speed) {
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getSpeed() {
        return speed;
    }

    public String toString() {
        return "-" +
            "модель='" + model + '\'' +
            ", ціна=" + price +
            ", витрата палива=" + fuelConsumption +
            ", швидкість=" + speed +
            '-';
    }
}
