package ui;

public interface NurseryView {

    void showMessage(String message);
    String getAnimalName();
    String getCommand();
    void displayAnimalCommands(String animalName, String[] commands);
    void displayMenu();
    void showPrompt();
}
