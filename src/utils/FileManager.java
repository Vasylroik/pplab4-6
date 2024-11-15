package utils;

import models.Car;
import java.io.*;
import java.util.List;
import java.util.logging.Logger;

public class FileManager {
    private static final Logger logger = Logger.getLogger(FileManager.class.getName());

    public static void saveToFile(List<Car> cars, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(cars);
            logger.info("дані про автопарк збережені в файл.");
        } catch (IOException e) {
            logger.severe("помилка збереження: " + e.getMessage());
        }
    }

    public static List<Car> loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            List<Car> cars = (List<Car>) in.readObject();
            logger.info("дані про автопарк завантажені з файлу.");
            return cars;
        } catch (IOException | ClassNotFoundException e) {
            logger.severe("помилка завантаження: " + e.getMessage());
            return null;
        }
    }
}
