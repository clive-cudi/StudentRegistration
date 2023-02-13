package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MockCoursesDB {
    private List<Course> data;
    private ObjectMapper mapper = new ObjectMapper();
    private File file = new File("mock/courses_db.json");

    public MockCoursesDB() throws IOException {
        System.out.println("Attempting to read from file in: "+ file.getCanonicalPath());
        data = Arrays.asList(mapper.readValue(file, Course[].class));
    }

    public List<Course> getData() {
        return data;
    }

    public void addCourse(Course course) throws IOException {
        data.add(course);
        mapper.writeValue(file, data);
    }

    public void updateCourse(Course updatedCourse) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getCourseID() == updatedCourse.getCourseID()) {
                data.set(i, updatedCourse);

                break;
            }
        }

        mapper.writeValue(file, data);
    }

    public void deleteCourse(String id) throws IOException {
        for (int k = 0; k < data.size(); k++) {
            if (data.get(k).getCourseID() == id) {
                data.remove(k);

                break;
            }
        }

        mapper.writeValue(file, data);
    }

    public boolean existsInDB(String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getCourseID() == id) {
                return true;
            }
        }

        return false;
    }

    public Course getCourse(String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getCourseID() == id) {
                return data.get(i);
            }
        }

        return null;
    }
}
