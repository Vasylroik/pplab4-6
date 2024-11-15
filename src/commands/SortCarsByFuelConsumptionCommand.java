package commands;

import utils.TaxiFleet;

public class SortCarsByFuelConsumptionCommand implements Command {
    private final TaxiFleet fleet;

    public SortCarsByFuelConsumptionCommand(TaxiFleet fleet) {
        this.fleet = fleet;
    }

    public void execute() {
        fleet.sortCarsByFuelConsumption();
    }
}
