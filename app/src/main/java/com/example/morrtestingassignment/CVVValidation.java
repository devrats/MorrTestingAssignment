package com.example.morrtestingassignment;

public class CVVValidation {

    public static boolean isValidCVV(String number) {
        if (number.length() == 3 || number.length() == 4) {
            return true;
        }
        return false;
    }
}
