package commands;

import utils.TaxiFleet;
import models.Car;
import java.util.Scanner;

public class AddCarCommand implements Command {
    private TaxiFleet taxiFleet;

    public AddCarCommand(TaxiFleet taxiFleet) {
        this.taxiFleet = taxiFleet;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть модель авто: ");
        String model = scanner.nextLine();
        System.out.print("Введіть ціну: ");
        double price = scanner.nextDouble();
        System.out.print("Введіть розхід палива: ");
        double fuelConsumption = scanner.nextDouble();
        System.out.print("Введіть швидкість авто: ");
        double speed = scanner.nextDouble();

        taxiFleet.addCar(model, price, fuelConsumption, speed);
    }
}
