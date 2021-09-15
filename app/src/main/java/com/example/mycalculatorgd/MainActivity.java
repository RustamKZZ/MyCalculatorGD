package com.example.mycalculatorgd;

import android.os.Bundle;
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

    String strNum = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playEt = findViewById(R.id.display_result);
        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree= findViewById(R.id.button_three);
        buttonFour = findViewById(R.id.button_four);
        buttonFive = findViewById(R.id.button_five);
        buttonSix = findViewById(R.id.button_six);
        buttonSeven = findViewById(R.id.button_seven);
        buttonEight = findViewById(R.id.button_eight);
        buttonNine = findViewById(R.id.button_nine);
        buttonZero = findViewById(R.id.button_zero);

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
    }

    void addNumber(int number) {
        strNum += Integer.toString(number);
        playEt.setText(strNum);
    }
}
