package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Random;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private static String id;
    public static String name;
    private static String usertype;
    private static boolean isVerified;

    public Person() {
        Random random = new Random();
        int randomNum = random.nextInt(900);
        id = "student_" + randomNum;
    }

    public Person(String personName) {
        name = personName;
        Random random = new Random();
        int randomNum = random.nextInt(900);
        id = "student_" + randomNum;
    }

    public static String setName(String newName) {
        name = newName;
        return name;
    }

    public static String getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static void verify() {
        isVerified = true;
    }
}
