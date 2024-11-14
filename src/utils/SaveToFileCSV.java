package utils;

import models.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class SaveToFileCSV {
    private static final Logger logger = Logger.getLogger(SaveToFileCSV.class.getName());

    // Метод для збереження автопарку в CSV файл
    public static void save(List<Car> cars, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Запис заголовка
            writer.write("Model,Price,Fuel Consumption,Speed\n");
            // Запис кожного автомобіля
            for (Car car : cars) {
                writer.write(String.format("%s,%.2f,%.2f,%.2f\n", car.getModel(), car.getPrice(), car.getFuelConsumption(), car.getSpeed()));
            }
            logger.info("Fleet data saved to CSV file.");
        } catch (IOException e) {
            logger.severe("Error saving file: " + e.getMessage());
        }
    }
}
