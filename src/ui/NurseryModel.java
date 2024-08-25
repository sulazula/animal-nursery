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
        return animalList.containsKey(name);
    }

    public void addCommand(String name, String packList) {
        if (packList.contains(name)) {
            packList.
        }
    }

    public Set<String> getCommands(String name) {
        if (packList.containsKey(name)) {
            return packList.get(name);
        } else if (petList.containsKey(name)) {
            return petList.get(name);
        }
        return Collections.emptySet();
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
