package commands;

import utils.TaxiFleet;

public class CalculateFleetCostCommand implements Command {
    private final TaxiFleet fleet;

    public CalculateFleetCostCommand(TaxiFleet fleet) {
        this.fleet = fleet;
    }

    public void execute() {
        fleet.calculateTotalCost();
    }
}
