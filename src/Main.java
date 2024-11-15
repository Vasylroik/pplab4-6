import commands.*;
import utils.TaxiFleet;
import utils.SaveToFileCSV;
import utils.LoadFromFileCSV;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaxiFleet fleet = new TaxiFleet();
        Map<Integer, Command> commands = new HashMap<>();

        commands.put(1, new AddCarCommand(fleet));
        commands.put(2, new RemoveCarCommand(fleet));
        commands.put(3, new CalculateFleetCostCommand(fleet));
        commands.put(4, new SortCarsByFuelConsumptionCommand(fleet));
        commands.put(5, new FindCarBySpeedRangeCommand(fleet));
        commands.put(6, new SaveToFileCSV(fleet, "fleet_data.csv"));
        commands.put(7, new LoadFromFileCSV(fleet, "fleet_data.csv"));
        commands.put(0, new ExitCommand());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Додати автомобіль\n2. Видалити автомобіль\n3. Підрахувати загальну суму\n4. Сортувати за витратою палива\n5. Знайти авто за швидкістю\n6. Зберегти в файл\n7. Завантажити з файлу\n0. Завершити");
            System.out.print("Виберіть операцію: ");
            int choice = scanner.nextInt();

            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Неможливий варіант. Оберіть знову.");
            }
        }
    }
}
