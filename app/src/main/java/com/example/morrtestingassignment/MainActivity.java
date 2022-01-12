package com.example.morrtestingassignment;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {

    boolean validCardNumber;
    boolean validExpiryDate;
    boolean validCVV;
    boolean validFirstName;
    boolean validLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView cardNumberField = findViewById(R.id.cardNumber);
        TextView expiryDateField = findViewById(R.id.expiryDate);
        TextView CVVField = findViewById(R.id.CVV);
        TextView firstNameField = findViewById(R.id.firstName);
        TextView lastNameField = findViewById(R.id.lastName);
        EditText cardNumber = findViewById(R.id.cardNumberInput);
        EditText expiryDate = findViewById(R.id.expiryDateInput);
        EditText CVV = findViewById(R.id.CVVInput);
        EditText firstName = findViewById(R.id.firstNameInput);
        EditText lastName = findViewById(R.id.lastNameInput);
        Button button = findViewById(R.id.button);

        cardNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String cardNumberText = cardNumber.getText().toString();
                if (TextUtils.isEmpty(cardNumberText)) {
                    cardNumber.setError("Please Enter Valid Number");
                    cardNumberField.setText("Card Number \n(Please Enter Valid Number)");
                    cardNumberField.setTextColor(Color.parseColor("#FF0000"));
                    cardNumberField.setTextSize(14);
                } else {
                    if (!CardNumberValidation.isValidAccordingLuhnAlgorithm(cardNumberText)) {
                        cardNumber.setError("Please Enter Valid Number");
                        cardNumberField.setText("Card Number \n(Please Enter Valid Number)");
                        cardNumberField.setTextColor(Color.parseColor("#FF0000"));
                        cardNumberField.setTextSize(14);
                    } else {
                        if (CardNumberValidation.isValidAccordingAmericanExpress(cardNumberText) ||
                                CardNumberValidation.isValidAccordingDiscover(cardNumberText) ||
                                CardNumberValidation.isValidAccordingVisa(cardNumberText) ||
                                CardNumberValidation.isValidAccordingMasterCard(cardNumberText)) {
                            //valid number
                            cardNumberField.setText("Card Number");
                            cardNumberField.setTextColor(Color.parseColor("#FF000000"));
                            cardNumberField.setTextSize(20);
                            validCardNumber = true;
                        } else {
                            cardNumber.setError("Please Enter Valid Number");
                            cardNumberField.setText("Card Number \n(Please Enter Valid Number)");
                            cardNumberField.setTextColor(Color.parseColor("#FF000000"));
                            cardNumberField.setTextSize(14);
                        }
                    }
                }
            }
        });

        expiryDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String expirationDateText = expiryDate.getText().toString();
                if (TextUtils.isEmpty(expirationDateText)) {
                    expiryDate.setError("Please Enter Valid Expiry Date");
                    expiryDateField.setText("Expiry Date \n(Please Enter Valid Expiry Date)");
                    expiryDateField.setTextColor(Color.parseColor("#FF0000"));
                    expiryDateField.setTextSize(14);
                } else {
                    if (!ExpiryDateValidation.isValidExpiryDate(expirationDateText)) {
                        expiryDate.setError("Please Enter Valid Expiry Date");
                        expiryDateField.setText("Expiry Date \n(Please Enter Valid Expiry Date)");
                        expiryDateField.setTextColor(Color.parseColor("#FF0000"));
                        expiryDateField.setTextSize(14);
                    } else {
                        expiryDateField.setText("Expiry Date");
                        expiryDateField.setTextColor(Color.parseColor("#FF000000"));
                        expiryDateField.setTextSize(20);
                        validExpiryDate = true;
                    }
                }
            }
        });

        CVV.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
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
                        CVVField.setTextColor(Color.parseColor("#FF000000"));
                        CVVField.setTextSize(20);
                        validCVV = true;
                    }
                }
            }
        });

        firstName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
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
                        validFirstName = true;
                    }
                }
            }
        });

        lastName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
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
                        validLastName = true;
                    }
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardNumberText = cardNumber.getText().toString();
                String CVVText = CVV.getText().toString();
                String expiryDateText = expiryDate.getText().toString();
                String firstNameText = firstName.getText().toString();
                String lastNameText = lastName.getText().toString();
                if(TextUtils.isEmpty(cardNumberText) || TextUtils.isEmpty(CVVText) || TextUtils.isEmpty(expiryDateText) ||
                TextUtils.isEmpty(firstNameText) || TextUtils.isEmpty(lastNameText)){
                    Toast.makeText(getApplicationContext(), "Enter Valid Values", Toast.LENGTH_SHORT).show();
                }
                if(validCardNumber && validCVV && validExpiryDate && validFirstName && validLastName){
                    DialogBox dialogBox = new DialogBox();
                    dialogBox.show(getSupportFragmentManager(),"");
                    Toast.makeText(getApplicationContext(), "Payment Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}