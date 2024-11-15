package commands;

import utils.TaxiFleet;

public class RemoveCarCommand implements Command {
    private final TaxiFleet fleet;

    public RemoveCarCommand(TaxiFleet fleet) {
        this.fleet = fleet;
    }

    public void execute() {
        fleet.removeCar();
    }
}
