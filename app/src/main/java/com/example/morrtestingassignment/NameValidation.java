package com.example.morrtestingassignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidation {

    public static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
}
