package ui;

import animals.Animal;
import animals.Pack;
import animals.Pet;

import java.util.*;

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
                    teachAnimalCommands();
                    break;
                case 4:
                    displayAllAnimals();
                    break;
            }
        }
    }

    public void addNewAnimal() {
        String type = getAnimalType();
        switch (type) {
            case "Pack":
                System.out.print("Enter a name: ");
                String packAnimalName = (new Scanner(System.in)).nextLine();
                System.out.print("Enter an age: ");
                int packAge = (new Scanner(System.in)).nextInt();
                System.out.print("Enter a subclass: ");
                String packClassName = (new Scanner(System.in)).nextLine();

                model.addPack(new Pack(packAnimalName, packAge, packClassName));
                break;
            case "Pet":
                System.out.print("Enter a name: ");
                String petAnimalName = (new Scanner(System.in)).nextLine();
                System.out.print("Enter an age: ");
                int petAge = (new Scanner(System.in)).nextInt();
                System.out.print("Enter a subclass: ");
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
        } while (option > 2 || option < 1);
        if (option == 1) {
            return "Pack";
        }
        if (option == 2) {
            return "Pet";
        }
        return null;
    }

    private void checkAnimalCommands() {
        String type = getAnimalType();
        String name = view.getAnimalName();

        Map<? extends Animal, Set<String>> animalMap = null;

        if (type.equalsIgnoreCase("Pack")) {
            animalMap = model.getPackList();
        } else if (type.equalsIgnoreCase("Pet")) {
            animalMap = model.getPetList();
        } else {
            System.out.println("Invalid animal type");
        }

        if (model.animalExists(name, animalMap)) {
            view.displayAnimalCommands(name, model.getCommands(name).toArray(new String[0]));
        } else {
            System.out.println("Animal does not exist");
        }
    }

    private void teachAnimalCommands() {
        String type = getAnimalType();
        String name = view.getAnimalName();
        if (type.equalsIgnoreCase("Pack")) {
            if (model.animalExists(name, model.getPackList())) {
                String command = view.getCommand();
                model.addCommand(name, command);
            }
        }
    }
    private void displayAllAnimals() {
        System.out.println(model.getAllAnimals());
    }
}
