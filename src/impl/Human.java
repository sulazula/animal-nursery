package impl;

import java.time.LocalDate;

public class Human {
    private String firstname;
    private String secondname;
    private int phonenumber;
    private int age;
    private LocalDate birthday;

    public Human(String firstname, String secondname, int age, LocalDate birthday) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.age = age;
        this.birthday = birthday;
    }

    public Human() {
        this.firstname = "Jack";
        this.secondname = "Daniels";
        this.age = 22;
        this.birthday = LocalDate.now();
    }
}
