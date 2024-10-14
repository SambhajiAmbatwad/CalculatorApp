//package com.example.calculaterapp;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//public class MainActivity extends AppCompatActivity {
//
//    private EditText display;
//    private double firstNumber = 0;
//    private String operator = "";
//    private boolean isNewOperation = true;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        display = findViewById(R.id.display);
//
//        // Set up the number buttons (0-9)
//        int[] numberIds = {
//                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
//                R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
//                R.id.button_8, R.id.button_9
//        };
//
//        View.OnClickListener numberClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Button button = (Button) view;
//                String number = button.getText().toString();
//
//                if (isNewOperation) {
//                    display.setText(number);
//                    isNewOperation = false;
//                } else {
//                    display.append(number);
//                }
//            }
//        };
//
//        for (int id : numberIds) {
//            findViewById(id).setOnClickListener(numberClickListener);
//        }
//
//        // Set up operator buttons (+, -, *, /)
//        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onOperatorClicked("+");
//            }
//        });
//        findViewById(R.id.button_subtract).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onOperatorClicked("-");
//            }
//        });
//        findViewById(R.id.button_multiply).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onOperatorClicked("*");
//            }
//        });
//        findViewById(R.id.button_divide).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onOperatorClicked("/");
//            }
//        });
//
//        // Equals button
//        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculateResult();
//            }
//        });
//
//        // Clear button
//        findViewById(R.id.button_clear).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clearDisplay();
//            }
//        });
//
//
//        // Double Zero button
//        findViewById(R.id.button_double_zero).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isNewOperation) {
//                    display.setText("00");
//                    isNewOperation = false;
//                } else {
//                    display.append("00");
//                }
//            }
//        });
//
//        // Dot button
//        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isNewOperation) {
//                    display.setText("0.");
//                    isNewOperation = false;
//                } else {
//                    if (!display.getText().toString().contains(".")) {
//                        display.append(".");
//                    }
//                }
//            }
//        });
//
//        // Modulo button
//        findViewById(R.id.button_modulus).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onOperatorClicked("%");
//            }
//        });
//
//        // Delete button
//        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String currentText = display.getText().toString();
//                if (currentText.length() > 0) {
//                    display.setText(currentText.substring(0, currentText.length() - 1));
//                }
//            }
//        });
//    }
//
//    // Handles operator clicks
//    private void onOperatorClicked(String op) {
//        firstNumber = Double.parseDouble(display.getText().toString());
//        operator = op;
//        isNewOperation = true;
//    }
//
//    // Performs the calculation
//    private void calculateResult() {
//        double secondNumber = Double.parseDouble(display.getText().toString());
//        double result = 0;
//
//        switch (operator) {
//            case "+":
//                result = firstNumber + secondNumber;
//                break;
//            case "-":
//                result = firstNumber - secondNumber;
//                break;
//            case "*":
//                result = firstNumber * secondNumber;
//                break;
//            case "/":
//                if (secondNumber != 0) {
//                    result = firstNumber / secondNumber;
//                } else {
//                    display.setText("Error");
//                    return;
//                }
//                break;
//        }
//
//        display.setText(String.valueOf(result));
//        isNewOperation = true;
//    }
//
//    // Clears the display
//    private void clearDisplay() {
//        display.setText("");
//        firstNumber = 0;
//        operator = "";
//        isNewOperation = true;
//    }
//}

package com.example.calculaterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        Typeface myfont=Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/digital-7.ttf");
        display.setTypeface(myfont);

        // Set up the number buttons (0-9)
        int[] numberIds = {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
                R.id.button_8, R.id.button_9
        };

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String number = button.getText().toString();

                if (isNewOperation) {
                    display.setText(number);
                    isNewOperation = false;
                } else {
                    display.append(number);
                }
            }
        };

        for (int id : numberIds) {
            findViewById(id).setOnClickListener(numberClickListener);
        }

        // Set up operator buttons (+, -, *, /, %)
        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("+");
            }
        });
        findViewById(R.id.button_subtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("-");
            }
        });
        findViewById(R.id.button_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("*");
            }
        });
        findViewById(R.id.button_divide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("/");
            }
        });
        findViewById(R.id.button_modulus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorClicked("%");
            }
        });

        // Equals button
        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        // Clear button
        findViewById(R.id.button_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearDisplay();
            }
        });

        // Double Zero button
        findViewById(R.id.button_double_zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    display.setText("00");
                    isNewOperation = false;
                } else {
                    display.append("00");
                }
            }
        });

        // Dot button
        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    display.setText("0.");
                    isNewOperation = false;
                } else {
                    if (!display.getText().toString().contains(".")) {
                        display.append(".");
                    }
                }
            }
        });

        // Delete button
        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = display.getText().toString();
                if (currentText.length() > 0) {
                    display.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });
    }

    // Handles operator clicks
    private void onOperatorClicked(String op) {
        String currentText = display.getText().toString();

        // If it's a new operation, just start fresh with the operator after the first number
        if (isNewOperation) {
            display.setText(currentText + op);
            isNewOperation = false;
        } else {
            if (!operator.isEmpty()) {
                // Replace the previous operator if already one is there at the end
                display.setText(currentText.substring(0, currentText.length() - 1) + op);
            } else {
                display.append(op);
            }
        }

        // Store the first number and set the operator
        firstNumber = Double.parseDouble(currentText);
        operator = op;
    }

    // Performs the calculation
    private void calculateResult() {
        String[] parts = display.getText().toString().split("[+\\-*/%]");
        if (parts.length < 2) {
            return; // No valid operation to perform
        }

        double secondNumber = Double.parseDouble(parts[1]);
        double result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
            case "%":
                result = firstNumber % secondNumber;
                break;
        }

        display.setText(String.valueOf(result));
        isNewOperation = true;
        operator = "";  // Clear operator after calculation
    }

    // Clears the display
    private void clearDisplay() {
        display.setText("");
        firstNumber = 0;
        operator = "";
        isNewOperation = true;
    }
}

