package ru.netology;

public class Main {

    public static final String withoutAddress = "Без адреса";

    public static void main(String[] args) {
        //create Person object using builder
        Person person = new PersonBuilder()
                .setName("John")
                .setSirName("Smith")
                .setAge(20)
                .setCity("Paris")
                .build();

        System.out.println(person);

        // check having age and address
        System.out.println(person.getName() + " has age: " + person.hasAge());
        System.out.println(person.getName() + " has address: " + person.hasAddress());

        // check increasing age
        person.happyBirthDay();

        System.out.println(person);

        //create child1 using partly fill builder
        Person child1 = person.newChildBuilder()
                .setName("Daniel")
                .build();
        Person child2 = person.newChildBuilder()
                .setName("Karina")
                .build();

        System.out.println(child1);
        System.out.println(child2);

        // check increasing age of children
        child1.happyBirthDay();
        System.out.println(child1);
        child2.happyBirthDay();
        System.out.println(child2);

        //change city
        person.setCity("London");
        System.out.println(person);

        //check throwing exception by empty sirname
        Person personNoSirname = new PersonBuilder()
                .setName("John")
                .setSirName("")
                .setAge(20)
                .setCity("Paris")
                .build();

        //check throwing exception by wrong age
        Person personWrongAge = new PersonBuilder()
                .setName("John")
                .setSirName("Smith")
                .setAge(121)
                .setCity("Paris")
                .build();
    }
}
