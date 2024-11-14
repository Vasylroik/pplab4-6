package utils;

import models.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LoadFromFileCSV {
    private static final Logger logger = Logger.getLogger(LoadFromFileCSV.class.getName());

    // Метод для завантаження автопарку з CSV файлу
    public static List<Car> load(String filename) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Пропуск заголовка
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String model = data[0];
                double price = Double.parseDouble(data[1]);
                double fuelConsumption = Double.parseDouble(data[2]);
                double speed = Double.parseDouble(data[3]);
                cars.add(new Car(model, price, fuelConsumption, speed));
            }
            logger.info("Fleet data loaded from CSV file.");
        } catch (IOException e) {
            logger.severe("Error loading file: " + e.getMessage());
        }
        return cars;
    }
}
