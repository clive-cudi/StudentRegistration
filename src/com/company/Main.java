package com.company;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static final String STUDENT_USERNAME = "student";
    public static final String STUDENT_PASSWORD = "pass";
    public static final String ACC_USERNAME = "accountant";
    public static final String ACC_PASSWORD = "pass";
    public static Accountant accountant = new Accountant(ACC_USERNAME);
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int choice = getIntInput("Choose your role:\n1. Student\n2. Accountant", new int[]{1});

        try {
            MockCoursesDB coursesDB = new MockCoursesDB();

            // display a list of available courses
            List<Course> availableCourses = coursesDB.getData();

            switch (choice) {
                case 1:
                    System.out.println("Student");
                    System.out.println("Choose an action: ");

                    int authChoice = getIntInput("1. Register\n2. Login", new int[]{1, 2});
                    if (authChoice == 1) {
                        handleAuth("register", "student");

                    } else if (authChoice == 2) {
                        handleAuth("login", "student");
                    }
                    System.out.println("====== COURSE REGISTRATION ======");
                    System.out.println("Register for a course");
                    Course chosenCourse = Student.register();
                    if (chosenCourse != null) {
                        System.out.printf("You Chose %s\n", chosenCourse.name);
                        // generate a new invoice;
                        System.out.println("Generating Invoice...");

                        accountant.invoiceFeePayment(chosenCourse.getCost(), STUDENT_USERNAME, LocalDate.now().plusDays(4));

                        // Initialize payment
                        System.out.println("Enter amount for payment:");
                        handlePayment(chosenCourse);
                    } else {
                        System.out.println("Couldn't find course details");
                    }
                    break;
                case 2:
                    System.out.println("Accountant");
                    System.out.println("Choose an action");
                    int accAuthChoice = getIntInput("1. Register\n2.Login", new int[]{1, 2});
                    if (accAuthChoice == 1) {
                        handleAuth("register", "accountant");

                    } else if (accAuthChoice == 2) {
                        handleAuth("login", "accountant");
                    }
                    break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }


    }
    public static boolean handleAuth(String choice, String userType) {
        Scanner input = new Scanner(System.in);
        if (choice == "login") {
            while (true) {
                System.out.println("Enter username:");
                String username = input.nextLine();
                System.out.println("Enter Password");
                String password = input.nextLine();
                if (username.equals(STUDENT_USERNAME) && password.equals(STUDENT_PASSWORD)) {
                    System.out.println("Login successful");
                    break;
                } else {
                    System.out.println("Invalid credentials. Please try Again");
                }
            }
            return true;
        } else if (choice == "register") {
            System.out.println("Enter username");
            String username = input.nextLine();
            while (true) {
                System.out.println("Enter password");
                String password = input.nextLine();
                System.out.println("Confirm password");
                String passwordConfirm = input.nextLine();
                if (password.equals(passwordConfirm)) {
                    break;
                } else {
                    System.out.println("Passwords do not match!!\nPlease Try Again");
                }
            }
            return true;
        }

        return false;
    }

    public static void handlePayment(Course course) {
        final double cost = course.getCost();
        while (true) {
            Scanner input = new Scanner(System.in);
            double amountPaid = input.nextDouble();
            if (amountPaid == cost) {
                System.out.println("Amount paid successfully");
                accountant.receiptFeePayment(amountPaid, STUDENT_USERNAME, 0);
                break;
            }
            if (amountPaid > cost) {
                System.out.println("Calculating balance...");
                accountant.receiptFeePayment(amountPaid, STUDENT_USERNAME, amountPaid - cost);
                break;
            }
            if (amountPaid < cost) {
                System.out.println("Insufficient funds");
                input.nextLine();
            }
        }
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

    public static int[] addItemToArray(int[] arr, int item) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = item;

        return newArr;
    }
}