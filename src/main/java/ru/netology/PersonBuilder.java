package ru.netology;

import static ru.netology.Main.withoutAddress;

public class PersonBuilder {

    public static final int MAX_AGE = 120;

    protected String name;

    protected String sirName;

    protected int age;

    protected String city;

    protected boolean isHasAge = false;

    protected boolean isHasAddress = false;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSirName(String sirName) {
        this.sirName = sirName;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        isHasAge = age != 0;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        isHasAddress = !city.isEmpty();
        return this;
    }

    public Person build() throws IllegalArgumentException, IllegalStateException {
        Person person;
            if (name.isEmpty()) throw new IllegalStateException("Name can not be empty!");
            if (sirName.isEmpty()) throw new IllegalStateException("Sirname can not be empty!");
            if (age < 0 || age > MAX_AGE) throw new IllegalArgumentException("Wrong age! Age must be more than 0 and less than 120. Current value is " +  age + "."  );
        if (isHasAddress) {
            person = new Person(name, sirName, age, city);
        } else {
            person = new Person(name, sirName, age, withoutAddress);
        }
        return person;
    }
}
