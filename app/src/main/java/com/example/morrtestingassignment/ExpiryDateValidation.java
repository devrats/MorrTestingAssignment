package com.example.morrtestingassignment;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class ExpiryDateValidation {

    public static boolean isValidExpiryDate(String date) {
        Date currentDate = new Date();
        int currentMonth = currentDate.getMonth() + 1;
        int currentYear = currentDate.getYear() + 1900;
        try {
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
        } catch (StringIndexOutOfBoundsException exception) {
            return false;
        }
        return false;
    }

    public static boolean validateExpirationDate(EditText expiryDate, TextView expiryDateField) {
        String expirationDateText = expiryDate.getText().toString();
        if (TextUtils.isEmpty(expirationDateText)) {
            expiryDate.setError("Please Enter Valid Expiry Date");
            expiryDateField.setText("Expiry Date " + "\n" +
                    "(Please Enter Valid Expiry Date)");
            expiryDateField.setTextColor(Color.parseColor("#FF0000"));
            expiryDateField.setTextSize(14);
        } else {
            if (!ExpiryDateValidation.isValidExpiryDate(expirationDateText)) {
                expiryDate.setError("Please Enter Valid Expiry Date");
                expiryDateField.setText("Expiry Date " + "\n" +
                        "(Please Enter Valid Expiry Date)");
                expiryDateField.setTextColor(Color.parseColor("#FF0000"));
                expiryDateField.setTextSize(14);
            } else {
                expiryDateField.setText("Expiry Date");
                expiryDateField.setTextColor(Color.parseColor("#FF000000"));
                expiryDateField.setTextSize(20);
                return true;
            }
        }
        return false;
    }
}
