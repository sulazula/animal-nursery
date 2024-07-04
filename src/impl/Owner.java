package impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Owner extends Human{
    private List<Animal> animalsList = new ArrayList<>();
    private int phonenumber;

    public Owner(String firstname, String secondname, int phonenumber, int age, LocalDate birthday) {
        super(firstname, secondname, age, birthday);
        this.phonenumber = phonenumber;
        this.animalsList = new ArrayList<>();
    }

    public List<Animal> getAnimalsList() {
        return animalsList;
    }
    public int getPhonenumber() {
        return phonenumber;
    }

    public void addAnimal(Animal animal) {
        animalsList.add(animal);
    }
    public void removeAnimal(Animal animal) {
        animalsList.remove(animal);
    }

}
