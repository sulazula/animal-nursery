package ui;

import animals.Animal;
import animals.Pack;
import animals.Pet;

import java.util.Scanner;

public class NurseryController {

    private NurseryModel model;
    private NurseryView view;

    public NurseryController(NurseryModel model, NurseryView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean work = true;
        while (work) {
            view.displayMenu();
            view.showPrompt();

            int option = Integer.parseInt(new Scanner(System.in).nextLine());

            switch (option) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    checkAnimalCommands();
                    break;
                case 3:

            }
        }
    }

    public void addNewAnimal() {
        String type = getAnimalType();
        switch (type) {
            case "Pack":
                System.out.println("Enter a name: ");
                String packAnimalName = (new Scanner(System.in)).nextLine();
                System.out.println("Enter an age: ");
                int packAge = (new Scanner(System.in)).nextInt();
                System.out.println("Enter a subclass: ");
                String packClassName = (new Scanner(System.in)).nextLine();

                model.addPack(new Pack(packAnimalName, packAge, packClassName));
                break;
            case "Pet":
                System.out.println("Enter a name: ");
                String petAnimalName = (new Scanner(System.in)).nextLine();
                System.out.println("Enter an age: ");
                int petAge = (new Scanner(System.in)).nextInt();
                System.out.println("Enter a subclass: ");
                String petClassName = (new Scanner(System.in)).nextLine();

                model.addPet(new Pet(petAnimalName, petAge, petClassName));
                break;
        }
    }

    private String getAnimalType() {
        int option;
        do {
            System.out.println("Choose a class: \n 1 - Pack \n 2 - Pet");
            option = Integer.parseInt(new Scanner(System.in).nextLine());
        } while (option != 1 && option != 2);
            return option == 1 ? "Pack" : "Pet";
    }

    private void checkAnimalCommands() {
        String type = getAnimalType();
        String name = view.getAnimalName();
        if (type.equalsIgnoreCase("Pack")) {
            if (model.animalExists(name, model.getPackList())) {
                view.displayAnimalCommands(name, model.getCommands(name).toArray(new String[0]) );
            }
        }
        if (type.equalsIgnoreCase("Pet")) {
            if (model.animalExists(name, model.getPetList())) {
                view.displayAnimalCommands(name, model.getCommands(name).toArray(new String[0]) );
            }
        }

    }
    private void teachAnimalCommands() {
        String type = getAnimalType();
        String name = view.getAnimalName();
        if (type.equalsIgnoreCase("Pack")) {
            if (model.animalExists(name, model.getPackList())) {
                System.out.print("Enter a new command: ");
                String command = view.getCommand();
                model.addCommand(n);
            }
        }
    }
}
