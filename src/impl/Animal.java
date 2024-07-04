package impl;

import java.time.LocalDate;

public class Animal {
    private String name;
    private String breed; // порода(тип) животного
    private int age;

    public Animal(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public Animal() {
        this.name = "Bobik";
        this.breed = "Dog";
        this.age = LocalDate.now().getYear();
    }

    public void sleep() {
        System.out.println(name + " is going to sleep");
    }
    public void eat() {
        System.out.println(name + " is eating");
    }

}
