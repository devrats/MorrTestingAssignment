package com.example.morrtestingassignment;

import java.util.Date;

public class ExpiryDateValidation {

    public static boolean isValidExpiryDate(String date) {
        Date currentDate = new Date();
        int currentMonth = currentDate.getMonth() + 1;
        int currentYear = currentDate.getYear() + 1900;
        try{
            if (date.charAt(2) == '/') {
                int month = Integer.parseInt(date.substring(0, 2));
                int year = Integer.parseInt(date.substring(3)) + 2000;
                if (year > currentYear) {
                    return true;
                }
                if (currentYear == year) {
                    if (month > currentMonth) {
                        return true;
                    }
                }
            }
        } catch (StringIndexOutOfBoundsException exception){
            return false;
        }
        return false;
    }
}
