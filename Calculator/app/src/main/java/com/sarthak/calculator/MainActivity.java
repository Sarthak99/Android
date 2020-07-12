package com.sarthak.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private EditText newEntry;
    private TextView displayOperation;

    private Double operand1 = null;
    private String pendingOperation = "=";

    private static final String STATE_PENDING_OPERATIONS = "pendingOperation";
    private static final String STATE_PENDING_OPERAND = "operand1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        newEntry = findViewById(R.id.newEntry);
        displayOperation = findViewById(R.id.operation);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDot = findViewById(R.id.buttonDecimal);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEqual);

        /**
         * Click listener for all number widgets.
         * When a number button is pressed, then update the newEntry with the number value.
         * All the no. buttons are defined by corresponding texts and can be fetched by button.getText() call.
         */
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                newEntry.append(b.getText().toString());
            }
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        /**
         * Click listener for all arithmetic button operators.
         * When an arithmetic button is pressed, look for any pending entries in the newEntry field.
         * If yes, then perform the operation with the newEntry and the result.Post that display the pending operation widget with the operator.
         * If no, then just display the pending operation widget with the operator.
         */

        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = newEntry.getText().toString();
                if (value.length() != 0) {
                    try {
                        Double doubleValue = Double.valueOf(value);
                        performOperation(doubleValue, op);
                    } catch (NumberFormatException n) {
                        //This is to handle "." entry after an operator is entered.
                        newEntry.setText("");
                    }
                }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }
        };

        buttonAdd.setOnClickListener(opListener);
        buttonSubtract.setOnClickListener(opListener);
        buttonMultiply.setOnClickListener(opListener);
        buttonDivide.setOnClickListener(opListener);
        buttonEquals.setOnClickListener(opListener);

        /**
         * Click listener for all Negate button operators.
         * When the negate button is pressed, then it should negate the newEntry widget pending value.
         * If negate is pressed but there is no newEntry value, reset the newEntry widget to blank value.
         * If negate is pressed on a "."or "-", reset the newEntry widget to blank value by catching number format exception.
         */
        Button buttonNeg = findViewById(R.id.buttonNeg);
        buttonNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = newEntry.getText().toString();
                if(value.length() == 0){
                    newEntry.setText("");
                } else {
                    try{
                        Double doubleValue = Double.valueOf(value);
                        doubleValue *= -1;
                        newEntry.setText(doubleValue.toString());
                    } catch(NumberFormatException n){
                        //if the value entered is "." or "-", clear the newEntry widget
                        newEntry.setText("");
                    }
                }

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_PENDING_OPERATIONS, pendingOperation);
        if(operand1 != null){
            outState.putDouble(STATE_PENDING_OPERAND, operand1);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATIONS);
        operand1 = savedInstanceState.getDouble(STATE_PENDING_OPERAND);
        displayOperation.setText(pendingOperation);
    }

    private void performOperation(Double value, String operation) {

        if (operand1 == null) {
            operand1 = Double.valueOf(value);
        } else {
            if (pendingOperation.equals("=")) {
                pendingOperation = operation;
            }
            switch (pendingOperation) {
                case "=":
                    operand1 = value;
                    break;
                case "+":
                    operand1 += value;
                    break;
                case "-":
                    operand1 -= value;
                    break;
                case "*":
                    operand1 = operand1 * value;
                    break;
                case "/":
                    if (value == 0) {
                        operand1 = 0.0;
                    } else {
                        operand1 = operand1 / value;
                    }
                    break;
            }
        }
        result.setText(operand1.toString());
        newEntry.setText("");
    }
}