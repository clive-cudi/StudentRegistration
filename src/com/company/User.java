package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public static String name;
    public static String id;
    public static String usertype;
    public static boolean isVerified;

    public static String getId() {
        return id;
    }
}
