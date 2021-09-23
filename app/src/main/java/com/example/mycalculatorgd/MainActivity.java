package com.example.mycalculatorgd;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView playEt;
    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button zeroButton;

    Button plusButton;
    Button minusButton;
    Button multiplyButton;
    Button divisionButton;
    Button dotButton;
    Button deleteButton;
    Button equalButton;

    private String strNum = "";
    private double digitOne;
    private char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null && savedInstanceState.containsKey("saved_double_num")
                && savedInstanceState.containsKey("saved_key_str") && savedInstanceState.containsKey("saved_char_operation")){
            digitOne = savedInstanceState.getDouble("saved_double_num");
            strNum = savedInstanceState.getString("saved_key_str");
            operation = savedInstanceState.getChar("saved_char_operation");
        }

        playEt = findViewById(R.id.result_display);
        oneButton = findViewById(R.id.one_button);
        twoButton = findViewById(R.id.two_button);
        threeButton = findViewById(R.id.three_button);
        fourButton = findViewById(R.id.four_button);
        fiveButton = findViewById(R.id.five_button);
        sixButton = findViewById(R.id.six_button);
        sevenButton = findViewById(R.id.seven_button);
        eightButton = findViewById(R.id.eight_button);
        nineButton = findViewById(R.id.nine_button);
        zeroButton = findViewById(R.id.zero_button);

        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        multiplyButton = findViewById(R.id.multiply_button);
        divisionButton = findViewById(R.id.dev_button);
        dotButton = findViewById(R.id.dot_button);
        deleteButton = findViewById(R.id.delete_button);
        equalButton = findViewById(R.id.equal_button);

        oneButton.setOnClickListener(view -> addNumber(1));
        twoButton.setOnClickListener(view -> addNumber(2));
        threeButton.setOnClickListener(view -> addNumber(3));
        fourButton.setOnClickListener(view -> addNumber(4));
        fiveButton.setOnClickListener(view -> addNumber(5));
        sixButton.setOnClickListener(view -> addNumber(6));
        sevenButton.setOnClickListener(view -> addNumber(7));
        eightButton.setOnClickListener(view -> addNumber(8));
        nineButton.setOnClickListener(view -> addNumber(9));
        zeroButton.setOnClickListener(view -> addNumber(0));

        plusButton.setOnClickListener(view -> mathAction('+'));
        minusButton.setOnClickListener(view -> mathAction('-'));
        multiplyButton.setOnClickListener(view -> mathAction('*'));
        divisionButton.setOnClickListener(view -> mathAction('/'));

        equalButton.setOnClickListener(view -> equalCalculation());

        dotButton.setOnClickListener(view -> {
            if (!strNum.contains(".")) {
                strNum += ".";
                playEt.setText(strNum);
            }
        });

        deleteButton.setOnClickListener(view -> {
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putDouble("saved_double_num", digitOne);
        outState.putString("saved_key_str", strNum);
        outState.putChar("saved_char_operation", operation);
        super.onSaveInstanceState(outState);
    }
}
