package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
    public String id;
    public String name;
    public double cost;
    public boolean onOffer;
    public static int capacity;

    public Course() {

    }

    public Course(String id, String name, double cost, boolean onOffer, int capacity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.onOffer = onOffer;
        this.capacity = capacity;

    }

    public double changeCourseCost(double amount) {
        cost = amount;

        return this.cost;
    }

    public String changeCourseName(String newCourseName) {
        name = newCourseName;

        return name;
    }

    public String getCourseID() {
        return id;
    }

    public String getCourseName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
