package com.company;

public class Person {
    private static String id;
    private static String name;

    public Person(String personName) {
        name = personName;
    }

    public static String setName(String newName) {
        name = newName;
        return name;
    }

    public static String getId() {
        return id;
    }
}
