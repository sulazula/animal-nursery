package ui;

import animals.Animal;
import animals.Pack;
import animals.Pet;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class NurseryModel {

    private static final String LOG_PATH = "app/src/data/db.json";
    private Map<Pack, Set<String>> packList;
    private Map<Pet, Set<String>> petList;
    private Gson gson = new Gson();


    public NurseryModel(Map<Pack, Set<String>> packList, Map<Pet, Set<String>> petMap) {
        this.packList = new HashMap<>();
        this.petList = new HashMap<>();
        loadAnimalsFromJson();
    }

    public void addPack(Pack animal) {

        if (!packList.containsKey(animal)) {
            packList.put(animal, new HashSet<>());
            saveAnimalsToJson();
        }

    }
    public void addPet(Pet animal) {
        if (!petList.containsKey(animal)) {
            petList.put(animal, new HashSet<>());
            saveAnimalsToJson();
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
                saveAnimalsToJson();
            } else if (animal instanceof Pet) {
                petList.get(animal).add(command);
                saveAnimalsToJson();
            }
        } else {
            System.err.println("Animal not found");
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

    private void loadAnimalsFromJson() {
        try (FileReader reader = new FileReader(LOG_PATH)) {
            Type combinedDataType = new TypeToken<Map<String, Object>>() {}.getType();
            Map<String, Object> combinedData = gson.fromJson(reader, combinedDataType);

            Map<String, Map<String, Object>> animalData = (Map<String, Map<String, Object>>) combinedData.get("animals");
            if (animalData != null) {
                if (animalData.containsKey("Pack")) {
                    Map<String, Object> packData = animalData.get("Pack");
                    for (Map.Entry<String, Object> entry : packData.entrySet()) {
                        String name = entry.getKey();
                        Map<String, Object> attributes = (Map<String, Object>) entry.getValue();
                        int age = ((Number) attributes.get("age")).intValue();
                        String subclass = (String) attributes.get("subclass");

                        Pack pack = new Pack(name, age, subclass);
                        packList.put(pack, new HashSet<>());
                    }
                }

                if (animalData.containsKey("Pet")) {
                    Map<String, Object> petData = animalData.get("Pet");
                    for (Map.Entry<String, Object> entry : petData.entrySet()) {
                        String name = entry.getKey();
                        Map<String, Object> attributes = (Map<String, Object>) entry.getValue();
                        int age = ((Number) attributes.get("age")).intValue();
                        String subclass = (String) attributes.get("subclass");

                        Pet pet = new Pet(name, age, subclass);
                        petList.put(pet, new HashSet<>());
                    }
                }
            }

            Map<String, Object> commandsData = (Map<String, Object>) combinedData.get("commands");
            if (commandsData != null) {
                for (Map.Entry<String, Object> entry : commandsData.entrySet()) {
                    String name = entry.getKey();
                    List<String> commandList = (List<String>) entry.getValue();
                    Set<String> commands = new HashSet<>(commandList);

                    Animal animal = getAnimalByName(name);
                    if (animal != null) {
                        if (animal instanceof Pack) {
                            packList.put((Pack) animal, commands);
                        } else if (animal instanceof Pet) {
                            petList.put((Pet) animal, commands);
                        }
                    }
                }
            }
        } catch (IOException e) {
            packList = new HashMap<>();
            petList = new HashMap<>();
        }
    }


    private void saveAnimalsToJson() {
        Map<String, Map<String, Object>> dataToSave = new HashMap<>();

        Map<String, Object> packData = new HashMap<>();
        for (Pack pack : packList.keySet()) {
            Map<String, Object> packInfo = new HashMap<>();
            packInfo.put("age", pack.getAge());
            packInfo.put("subclass", pack.get_Class());
            packData.put(pack.getName(), packInfo);
        }
        dataToSave.put("Pack", packData);

        Map<String, Object> petData = new HashMap<>();
        for (Pet pet : petList.keySet()) {
            Map<String, Object> petInfo = new HashMap<>();
            petInfo.put("age", pet.getAge());
            petInfo.put("subclass", pet.get_Class());
            petData.put(pet.getName(), petInfo);
        }
        dataToSave.put("Pet", petData);

        Map<String, Set<String>> commands = new HashMap<>();
        for (Pack pack : packList.keySet()) {
            commands.put(pack.getName(), packList.get(pack));
        }
        for (Pet pet : petList.keySet()) {
            commands.put(pet.getName(), petList.get(pet));
        }

        Map<String, Object> combinedData = new HashMap<>();
        combinedData.put("animals", dataToSave);
        combinedData.put("commands", commands);

        try (FileWriter writer = new FileWriter(LOG_PATH)) {
            gson.toJson(combinedData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}