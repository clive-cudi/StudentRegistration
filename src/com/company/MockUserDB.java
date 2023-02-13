package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MockUserDB {
    private List<Person> data;
    private ObjectMapper mapper = new ObjectMapper();
    private File file = new File("mock/user_db.json");

    public MockUserDB() throws IOException {
        System.out.println("Attempting to read from file in: "+ file.getCanonicalPath());
        data = mapper.readValue(file, new TypeReference<List<Person>>() {});
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i).name);
        }
    }

    public List<Person> getData() {
        return data;
    }

    public void addUser(Person user) throws IOException {
        data.add(user);
        mapper.writeValue(file, data);
    }

    public void updateUser(Person user) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == user.getId()) {
                data.set(i, user);

                break;
            }
        }

        mapper.writeValue(file, data);
    }

    public void deleteUser(String id) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id) {
                data.remove(i);

                break;
            }
        }

        mapper.writeValue(file, data);
    }

    public boolean existsInDB(String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id) {
                return true;
            }
        }

        return false;
    }
}
