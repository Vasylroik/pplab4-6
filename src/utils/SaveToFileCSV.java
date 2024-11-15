package utils;

import models.Car;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import commands.Command;

public class SaveToFileCSV implements Command {
    private TaxiFleet taxiFleet;
    private String fileName;

    public SaveToFileCSV(TaxiFleet taxiFleet, String fileName) {
        this.taxiFleet = taxiFleet;
        this.fileName = fileName;
    }

    public void execute() {
        try (FileWriter writer = new FileWriter(fileName)) {
            List<Car> cars = taxiFleet.getCars();
            for (Car car : cars) {
                writer.append(car.getModel())
                    .append(",")
                    .append(String.valueOf(car.getPrice()))
                    .append(",")
                    .append(String.valueOf(car.getFuelConsumption()))
                    .append(",")
                    .append(String.valueOf(car.getSpeed()))
                    .append("\n");
            }
            System.out.println("Дані успішно збережені " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
