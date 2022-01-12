package com.example.morrtestingassignment;

public class CardNumberValidation {

    public static boolean isValidAccordingLuhnAlgorithm(String number){
        try{
            int counter = 0;
            boolean flag = false;
            for (int index = number.length()-1; index >= 0; index--) {
                int value = Integer.parseInt(Character.toString(number.charAt(index)));
                if (flag) {
                    value = value * 2;
                    counter += value / 10;
                    counter += value % 10;
                    flag = false;
                } else {
                    counter += value;
                    flag = true;
                }
            }
            if (counter % 10 == 0) {
                return true;
            }
        } catch (NumberFormatException exception){
            return false;
        }
        return false;
    }

    public static boolean isValidAccordingAmericanExpress(String number) {
        if (number.charAt(0) == '3') {
            if (number.charAt(1) == '4' || number.charAt(1) == '7') {
                if (number.length() == 15) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidAccordingMasterCard(String number) {
        if (number.charAt(0) == '5') {
            if (number.length() == 16) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidAccordingDiscover(String number) {
        if (number.charAt(0) == '6') {
            if (number.length() == 16) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidAccordingVisa(String number) {
        if (number.charAt(0) == '4') {
            if (number.length() == 13 || number.length() == 16) {
                return true;
            }
        }
        return false;
    }
}
