package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int choice = getIntInput("Choose your role:\n1. Student\n2. Accountant", new int[]{1, 2});

        System.out.println("You chose: " + choice);


    }

    public static int getIntInput(String prompt, int[] optionsRange) {
        Scanner console = new Scanner(System.in);

        // loop to prompt the user for the input and breaks only when the user enters the correct input type
        while (true) {
            System.out.println(prompt);
            if (console.hasNextInt()) {
                int choice = console.nextInt();

                if (existsInArray(optionsRange, choice)) {
                    return choice;
                } else {
                    System.out.println("Invalid choice.");
                    console.nextLine();
                }
            } else {
                System.out.println("Invalid input. Please try again.");
                console.nextLine();
            }
        }
    }

    public static boolean existsInArray(int[] array, int value) {
        for (int element: array) {
            if (element == value) {
                return true;
            }
        }

        return false;
    }
}