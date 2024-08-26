package animals;

import animals.interfaces.Ridable;

public class Pack implements Ridable, Animal {

    private int age;
    private String name;
    private String _class;

    public Pack (String name, int age, String _class) {
        this.age = age;
        this.name = name;
        this._class = _class;
    }

    @Override
    public void ride() {

    }

    @Override
    public void toChallenge() {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return age;
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
        return "\nPack " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", type = '" + _class + '\'';
    }
}
