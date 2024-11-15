package commands;

import utils.TaxiFleet;
import java.util.Scanner;

public class FindCarBySpeedRangeCommand implements Command {
    private final TaxiFleet fleet;

    public FindCarBySpeedRangeCommand(TaxiFleet fleet) {
        this.fleet = fleet;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть мінімальну швидкість: ");
        double minSpeed = scanner.nextDouble();
        System.out.print("Введіть максимальну швидкість: ");
        double maxSpeed = scanner.nextDouble();
        fleet.findCarsBySpeedRange(minSpeed, maxSpeed);
    }
}
