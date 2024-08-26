package ui;

import animals.Animal;
import animals.Pack;
import animals.Pet;

import java.util.*;

public class NurseryModel {

    private Map<Pack, Set<String>> packList;
    private Map<Pet, Set<String>> petList;

    public NurseryModel(Map<Pack, Set<String>> packList, Map<Pet, Set<String>> petMap) {
        this.packList = new HashMap<>();
        this.petList = new HashMap<>();
    }

    public void addPack(Pack animal) {

        if (!packList.containsKey(animal)) {
            packList.put(animal, new HashSet<>());
        }
    }
    public void addPet(Pet animal) {
        if (!petList.containsKey(animal)) {
            petList.put(animal, new HashSet<>());
        }
    }

    public boolean animalExists(String name, Map<? extends Animal, Set<String>> animalList) {
        for (Animal animal : animalList.keySet()) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return true;
            }
        };
        return false;
    }

    public void addCommand(String name, String command) {
        Animal animal = getAnimalByName(name);
        if (animal != null) {
            if (animal instanceof Pack) {
                packList.get(animal).add(command);
            } else if (animal instanceof Pet) {
                petList.get(animal).add(command);
            }
        } else {
            System.out.println("Animal not found");
        }
    }

    private Animal getAnimalByName(String name) {
        // Поиск в списке Pack
        for (Pack pack : packList.keySet()) {
            if (pack.getName().equals(name)) {
                return pack;
            }
        }

        // Поиск в списке Pet
        for (Pet pet : petList.keySet()) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }

        return null;
    }

    public Set<String> getCommands(String name) {
        Animal animal = getAnimalByName(name);

        if (animal != null) {
            if (animal instanceof Pack) {
                return packList.get(animal);
            } else if (animal instanceof Pet) {
                return petList.get(animal);
            }
        }
        return new HashSet<>();
    }
    public List<String> getAllAnimals() {
        List<String> animals = new ArrayList<>();

        for (Pack pack : packList.keySet()) {
            animals.add(pack.toString());
        }
        for (Pet pet : petList.keySet()) {
            animals.add(pet.toString());
        }
        return animals;
    }

    public Map<Pack, Set<String>> getPackList() {
        return packList;
    }

    public Map<Pet, Set<String>> getPetList() {
        return petList;
    }
}
