package utils;

import commands.Command;
import models.Car;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadFromFileCSV implements Command {
    private TaxiFleet taxiFleet;
    private String filePath;

    public LoadFromFileCSV(TaxiFleet taxiFleet, String filePath) {
        this.taxiFleet = taxiFleet;
        this.filePath = filePath;
    }

    public void execute() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(",");
                if (carData.length == 4) {
                    String model = carData[0];
                    double price = Double.parseDouble(carData[1]);
                    double fuelConsumption = Double.parseDouble(carData[2]);
                    double speed = Double.parseDouble(carData[3]);

                    taxiFleet.addCar(model, price, fuelConsumption, speed);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
