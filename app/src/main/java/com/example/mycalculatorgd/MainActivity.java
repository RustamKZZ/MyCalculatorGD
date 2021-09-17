package com.example.mycalculatorgd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText playEt;
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;

    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivision;
    Button buttonDot;
    Button buttonDelete;
    Button buttonEqual;

    private String strNum = "";
    private double digitOne;
    private char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playEt = findViewById(R.id.display_result);
        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree = findViewById(R.id.button_three);
        buttonFour = findViewById(R.id.button_four);
        buttonFive = findViewById(R.id.button_five);
        buttonSix = findViewById(R.id.button_six);
        buttonSeven = findViewById(R.id.button_seven);
        buttonEight = findViewById(R.id.button_eight);
        buttonNine = findViewById(R.id.button_nine);
        buttonZero = findViewById(R.id.button_zero);

        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonDivision = findViewById(R.id.button_dev);
        buttonDot = findViewById(R.id.button_dot);
        buttonDelete = findViewById(R.id.button_delete);
        buttonEqual = findViewById(R.id.button_equal);

        buttonOne.setOnClickListener(view -> addNumber(1));
        buttonTwo.setOnClickListener(view -> addNumber(2));
        buttonThree.setOnClickListener(view -> addNumber(3));
        buttonFour.setOnClickListener(view -> addNumber(4));
        buttonFive.setOnClickListener(view -> addNumber(5));
        buttonSix.setOnClickListener(view -> addNumber(6));
        buttonSeven.setOnClickListener(view -> addNumber(7));
        buttonEight.setOnClickListener(view -> addNumber(8));
        buttonNine.setOnClickListener(view -> addNumber(9));
        buttonZero.setOnClickListener(view -> addNumber(0));

        buttonPlus.setOnClickListener(view -> mathAction('+'));
        buttonMinus.setOnClickListener(view -> mathAction('-'));
        buttonMultiply.setOnClickListener(view -> mathAction('*'));
        buttonDivision.setOnClickListener(view -> mathAction('/'));

        buttonEqual.setOnClickListener(view -> equalCalculation());

        buttonDot.setOnClickListener(view -> {
            if (!strNum.contains(".")) {
                strNum += ".";
                playEt.setText(strNum);
            }
        });

        buttonDelete.setOnClickListener(view -> {
            playEt.setText("");
            strNum = "";
            operation = 'h';
            digitOne = 0;
        });


    }

    void equalCalculation() {
        double result = 0;
        switch (this.operation) {
            case '+':
                result = this.digitOne + Double.parseDouble(this.strNum);
                break;
            case '-':
                result = this.digitOne - Double.parseDouble(this.strNum);
                break;
            case '*':
                result = this.digitOne * Double.parseDouble(this.strNum);
                break;
            case '/':
                result = this.digitOne / Double.parseDouble(this.strNum);
                break;
        }
        playEt.setText(Double.toString(result));
        this.strNum = "";
        this.operation = 'h';
        this.digitOne = 0;

    }

    private void mathAction(char c) {
        if (this.operation != '+' && this.operation != '-' && this.operation != '*' && this.operation != '/') {
            this.digitOne = Double.parseDouble(this.strNum);
            playEt.setText(String.valueOf(c));
            this.strNum = "";
            this.operation = c;
        }
    }


    void addNumber(int number) {
        this.strNum += Integer.toString(number);
        playEt.setText(strNum);
    }


}
