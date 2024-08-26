package animals;

import animals.interfaces.Pettable;

import java.util.Objects;

public class Pet implements Pettable, Animal {
    private String name;
    private int age;
    private String _class;

    public Pet (String name, int age, String _class) {
        this.age = age;
        this.name = name;
        this._class = _class;
    }

    @Override
    public void pet() {
        System.out.println("You pet this animal");
    }

    @Override
    public void play() {
        System.out.println("You play this animal");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String get_Class() {
        return this._class;
    }

    @Override
    public void eat() {
        System.out.println(name + " ate a dinner");
    }

    @Override
    public String toString() {
        return "Pet " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", type = '" + _class + '\'' +
                '\n';
    }
}
