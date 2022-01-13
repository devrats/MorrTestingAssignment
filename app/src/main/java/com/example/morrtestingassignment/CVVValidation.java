package com.example.morrtestingassignment;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

public class CVVValidation {

    public static boolean isValidCVV(String number) {
        if (number.length() == 3 || number.length() == 4) {
            return true;
        }
        return false;
    }

    public static boolean validateCVV(EditText CVV, TextView CVVField){
        int currentTextColor = CVV.getCurrentTextColor();
        String CVVText = CVV.getText().toString();
        if (TextUtils.isEmpty(CVVText)) {
            CVV.setError("Please Enter Valid CVV");
            CVVField.setText("CVV \n(Please Enter Valid CVV)");
            CVVField.setTextColor(Color.parseColor("#FF0000"));
            CVVField.setTextSize(14);
        } else {
            if (!CVVValidation.isValidCVV(CVVText)) {
                CVV.setError("Please Enter Valid CVV");
                CVVField.setText("CVV \n(Please Enter Valid CVV)");
                CVVField.setTextColor(Color.parseColor("#FF0000"));
                CVVField.setTextSize(14);
            } else {
                CVVField.setText("CVV");
                CVVField.setTextColor(currentTextColor);
                CVVField.setTextSize(20);
                return true;
            }
        }
        return false;
    }
}
