package commands;

public class ExitCommand implements Command {
    public void execute() {
        System.out.println("Exiting the program.");
        System.exit(0);
    }
}
