package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.company.Main.getIntInput;

public class Student extends Person {
    // user to be prompted for details that will be used to instantiate the class
    public Student() {
    }
    public Student(String name) {
          super(name);
    }
    public static Course register() {
        try {
            MockCoursesDB coursesDB = new MockCoursesDB();

            List<Course> availableCourses = coursesDB.getData();
            // display available courses
            String courseChoicePrompt = "";
            int[] courseChoiceOptions = {};
            Map<Integer, String> choiceIDMap = new HashMap<Integer, String>();
            for (int i = 0; i < availableCourses.size(); i++) {
                courseChoicePrompt = courseChoicePrompt + "" + (i + 1) + ". " + availableCourses.get(i).name + "\n";
                courseChoiceOptions = addItemToArray(courseChoiceOptions, i+1);
                choiceIDMap.put((i+1), availableCourses.get(i).getCourseID());
            }
            int courseChoiceInput = getIntInput(courseChoicePrompt, courseChoiceOptions);
            Course chosenCourse = coursesDB.getCourse(choiceIDMap.get(courseChoiceInput));

            return chosenCourse;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("An Error Occurred.");

            return null;
        }
    }

    private static int[] addItemToArray(int[] arr, int item) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = item;

        return newArr;
    }


    public static void payFees(double amount) {}

}
