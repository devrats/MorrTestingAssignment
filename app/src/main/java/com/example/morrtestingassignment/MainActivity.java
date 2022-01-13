package com.example.morrtestingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                validCardNumber = CardNumberValidation.validateCard(cardNumber, cardNumberField);
            }
        });

        expiryDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                validExpiryDate = ExpiryDateValidation.validateExpirationDate(expiryDate, expiryDateField);
            }
        });

        CVV.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                validCVV = CVVValidation.validateCVV(CVV, CVVField);
            }
        });

        firstName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                validFirstName = NameValidation.validateFirstName(firstName, firstNameField);
            }
        });

        lastName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                validLastName = NameValidation.validateLastName(lastName, lastNameField);
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
                if (TextUtils.isEmpty(cardNumberText) || TextUtils.isEmpty(CVVText) || TextUtils.isEmpty(expiryDateText) ||
                        TextUtils.isEmpty(firstNameText) || TextUtils.isEmpty(lastNameText)) {
                    Toast.makeText(getApplicationContext(), "Enter Valid Values", Toast.LENGTH_SHORT).show();
                }
                validCardNumber = CardNumberValidation.validateCard(cardNumber, cardNumberField);
                validExpiryDate = ExpiryDateValidation.validateExpirationDate(expiryDate, expiryDateField);
                validCVV = CVVValidation.validateCVV(CVV, CVVField);
                validFirstName = NameValidation.validateFirstName(firstName, firstNameField);
                validLastName = NameValidation.validateLastName(lastName, lastNameField);
                if (validCardNumber && validCVV && validExpiryDate && validFirstName && validLastName) {
                    DialogBox dialogBox = new DialogBox();
                    dialogBox.show(getSupportFragmentManager(), "");
                    Toast.makeText(getApplicationContext(), "Payment Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}