package utils;

import models.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class TaxiFleet {
    private static final Logger logger = Logger.getLogger(TaxiFleet.class.getName());
    private List<Car> cars = new ArrayList<>();

    public void addCar(String model, double price, double fuelConsumption, double speed) {
        cars.add(new Car(model, price, fuelConsumption, speed));
        logger.info("Авто додано: " + model);
    }

    public void removeCar() {
        if (cars.isEmpty()) {
            System.out.println("Немає авто для видалення.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть можель для видалення: ");
        String model = scanner.nextLine();
        cars.removeIf(car -> car.getModel().equalsIgnoreCase(model));
        logger.info("Авто видалено: " + model);
    }

    public double calculateTotalCost() {
        double totalCost = cars.stream().mapToDouble(Car::getPrice).sum();
        System.out.println("Загальна вартість автопарку: $" + totalCost);
        return totalCost;
    }

    public void sortCarsByFuelConsumption() {
        cars.sort((c1, c2) -> Double.compare(c1.getFuelConsumption(), c2.getFuelConsumption()));
        logger.info("Посортовано за витратою палива.");
    }

    public void findCarsBySpeedRange(double minSpeed, double maxSpeed) {
        cars.stream()
            .filter(car -> car.getSpeed() >= minSpeed && car.getSpeed() <= maxSpeed)
            .forEach(System.out::println);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
