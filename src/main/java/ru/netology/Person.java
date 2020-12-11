package ru.netology;

import lombok.*;
import org.w3c.dom.ls.LSOutput;

import static ru.netology.Main.withoutAddress;

@EqualsAndHashCode
@ToString
@Getter
public class Person {
    private String name;
    private String sirName;

    private int age = 0;

    private String city = withoutAddress;

    public Person() {
    }
    public Person(String name, String sirName, int age, String city) {
        this.name = name;
        this.sirName = sirName;
        this.age = age;
        this.city = city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public Person(String name, String sirName, int age) {
        this.name = name;
        this.sirName = sirName;
        this.age = age;
    }

    public boolean hasAge(){
        return age != 0;
    }

    public boolean hasAddress(){
        return !city.equals(withoutAddress);
    }


     public void happyBirthDay(){
        System.out.println("Happy Birth Day, " + name + "!");
         age += 1;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAge(0)
                .setSirName(sirName)
                .setCity(city);
    }
}
