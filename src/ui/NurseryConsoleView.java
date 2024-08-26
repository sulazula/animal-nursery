package ui;

import java.util.Scanner;

public class NurseryConsoleView implements NurseryView {
    Scanner scanner = new Scanner(System.in);

    public NurseryConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getAnimalName() {
        System.out.print("Enter animal name: ");
        return scanner.nextLine();
    }

    @Override
    public String getCommand() {
        System.out.print("Enter a command you want to teach for: ");
        return scanner.nextLine();
    }

    @Override
    public void displayAnimalCommands(String animalName, String[] commands) {
        System.out.println("Commands " + animalName + " can do: ");
        for (String command : commands) {
            System.out.println(" - " + command);
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\nMenu");
        System.out.println("1. Add a new animal");
        System.out.println("2. Check animal commands");
        System.out.println("3. Teach animal");
        System.out.println("4. Display all animals");
        System.out.println("5. Exit");
    }

    @Override
    public void showPrompt() {
        System.out.print("Please enter a command: ");
    }
}
