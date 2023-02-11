package com.company;

import java.util.UUID;

public class Course {
    private static String courseID;
    private static String courseName;
    private static double cost;

    public Course(String name, double courseCost) {
        courseID = UUID.randomUUID().toString();
        courseName = name;
        cost = courseCost;
    }

    public static double changeCourseCost(double amount) {
        cost = amount;

        return cost;
    }

    public static String changeCourseName(String newCourseName) {
        courseName = newCourseName;

        return courseName;
    }

    public static String getCourseID() {
        return courseID;
    }

    public static String getCourseName() {
        return courseName;
    }

    public static double getCost() {
        return cost;
    }
}
