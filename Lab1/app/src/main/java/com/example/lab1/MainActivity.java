package com.example.lab1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonZero,
            buttonDivide, buttonPlusMinus, buttonC, buttonBack, buttonMultiply, buttonPlus,
            buttonMinus, buttonSquareRoot, buttonSeven, buttonEight, buttonNine, buttonPersent, buttonReciprocal,
            buttonResult, buttonMC, buttonMR, buttonMS, buttonMPlus, buttonMMinus, buttonDot;

    private TextView errorMessage;

    private double valueOne = Double.NaN;
    private double valueTwo;
    private char CURRENT_ACTION;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char EQU = 0;

    private double memoryValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonZero = findViewById(R.id.buttonZero);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonPlusMinus = findViewById(R.id.buttonPlusMinus);
        buttonC = findViewById(R.id.buttonC);
        buttonBack = findViewById(R.id.buttonBack);
        buttonPersent = findViewById(R.id.buttonPersent);
        buttonReciprocal = findViewById(R.id.buttonReciprocal);
        buttonResult = findViewById(R.id.buttonResult);
        errorMessage = findViewById(R.id.errorMessage);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonSquareRoot = findViewById(R.id.buttonSquareRoot);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMC = findViewById(R.id.buttonMC);
        buttonMR = findViewById(R.id.buttonMR);
        buttonMS = findViewById(R.id.buttonMS);
        buttonMPlus = findViewById(R.id.buttonMPlus);
        buttonMMinus = findViewById(R.id.buttonMMinus);
        buttonDot = findViewById(R.id.buttonDot);


        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("2");
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("3");
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("4");
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("5");
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("6");
            }
        });


        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("7");
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("8");
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("9");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.append("0");
            }
        });

        buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = editText.getText().toString();
                if (!currentText.isEmpty()) {
                    if (currentText.charAt(0) == '-') {
                        editText.setText(currentText.substring(1));
                    } else {
                        editText.setText("-" + currentText);
                    }
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = editText.getText().toString();
                if (!currentText.isEmpty()) {
                    editText.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                clearErrorMessage();

            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperation(DIVISION);

            }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = EQU;
                editText.setText(String.valueOf(valueOne));
                valueOne = Double.NaN;
            }
        });

        buttonPersent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = editText.getText().toString();
                if (!currentText.isEmpty()) {
                    double value = Double.parseDouble(currentText);
                    if (value != 0) {
                        editText.setText(String.valueOf(value / 100));
                    }
                }
            }
        });

        buttonReciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = editText.getText().toString();
                if (!currentText.isEmpty()) {
                    double value = Double.parseDouble(currentText);
                    if (value != 0) {
                        editText.setText(String.valueOf(1 / value));
                    }
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearErrorMessage();
                handleOperation(MULTIPLICATION);

            }
        });


        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearErrorMessage();
                handleOperation(SUBTRACTION);

            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearErrorMessage();
                handleOperation(ADDITION);

            }
        });

        buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = editText.getText().toString();
                if (!currentText.isEmpty()) {
                    double value = Double.parseDouble(currentText);
                    if (value >= 0) {
                        editText.setText(String.valueOf(Math.sqrt(value)));
                    } else {
                        errorMessage.setText("Памылка: нельга вылічваць корань адмоўнага ліку!");
                        errorMessage.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = editText.getText().toString();
                if (!currentText.contains(".")) {
                    editText.append(".");
                }
            }
        });


        buttonMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoryValue = 0;
            }
        });

        buttonMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(String.valueOf(memoryValue));
            }
        });

        buttonMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()) {
                    memoryValue = Double.parseDouble(editText.getText().toString());
                }
            }
        });

        buttonMPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()) {
                    memoryValue += Double.parseDouble(editText.getText().toString());
                }
            }
        });

        buttonMMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()) {
                    memoryValue -= Double.parseDouble(editText.getText().toString());
                }
            }
        });


    }

    private void handleOperation(char operation) {
        clearErrorMessage();

        if (!editText.getText().toString().isEmpty()) {
            compute();
            CURRENT_ACTION = operation;
            editText.setText(null);
        } else {
            CURRENT_ACTION = operation;
        }
    }


    private void compute() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            switch (CURRENT_ACTION) {
                case ADDITION:
                    valueOne += valueTwo;
                    break;
                case SUBTRACTION:
                    valueOne -= valueTwo;
                    break;
                case MULTIPLICATION:
                    valueOne *= valueTwo;
                    break;
                case DIVISION:
                    if (valueTwo != 0)
                        valueOne /= valueTwo;
                    else {
                        errorMessage.setText("Памылка: Нельга дзяліць на нуль!");
                        errorMessage.setVisibility(View.VISIBLE);
                    }
                    break;
            }
        } else {
            try {
                valueOne = Double.parseDouble(editText.getText().toString());
            } catch (Exception e) {
                System.out.println("Штосьці пайшло не так.");
            }
        }
    }

    private void clearErrorMessage() {
        errorMessage.setText("");
        errorMessage.setVisibility(View.GONE);
    }
}
