package com.example.morrtestingassignment;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

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

    public static boolean validateFirstName(EditText firstName, TextView firstNameField){
        String firstNameText = firstName.getText().toString();
        if (TextUtils.isEmpty(firstNameText)) {
            firstName.setError("Please Enter Valid Name");
            firstNameField.setText("First Name \n(Please Enter Valid Name)");
            firstNameField.setTextColor(Color.parseColor("#FF0000"));
            firstNameField.setTextSize(14);
        } else {
            if (!NameValidation.isValidName(firstNameText)) {
                firstName.setError("Please Enter Valid Name");
                firstNameField.setText("First Name \n(Please Enter Valid Name)");
                firstNameField.setTextColor(Color.parseColor("#FF0000"));
                firstNameField.setTextSize(14);
            } else {
                firstNameField.setText("First Name");
                firstNameField.setTextColor(Color.parseColor("#FF000000"));
                firstNameField.setTextSize(20);
                return true;
            }
        }
        return false;
    }

    public static boolean validateLastName(EditText lastName, TextView lastNameField){
        String lastNameText = lastName.getText().toString();
        if (TextUtils.isEmpty(lastNameText)) {
            lastName.setError("Please Enter Valid Name");
            lastNameField.setText("Last Name \n(Please Enter Valid Name)");
            lastNameField.setTextColor(Color.parseColor("#FF0000"));
            lastNameField.setTextSize(14);
        } else {
            if (!NameValidation.isValidName(lastNameText)) {
                lastName.setError("Please Enter Valid Name");
                lastNameField.setText("Last Name \n(Please Enter Valid Name)");
                lastNameField.setTextColor(Color.parseColor("#FF0000"));
                lastNameField.setTextSize(14);
            } else {
                lastNameField.setText("Last Name");
                lastNameField.setTextColor(Color.parseColor("#FF000000"));
                lastNameField.setTextSize(20);
                return true;
            }
        }
        return false;
    }
}
