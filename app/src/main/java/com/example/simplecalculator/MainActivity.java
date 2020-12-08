package com.example.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import static com.example.simplecalculator.Operator.ADD;
import static com.example.simplecalculator.Operator.DIV;
import static com.example.simplecalculator.Operator.MUL;
import static com.example.simplecalculator.Operator.SUB;

public class MainActivity extends AppCompatActivity {

    private Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button_div, button_multiple, button_addition,
            button_subtract, button_equals, button_clear;
    private EditText input;
    private Operator operator;
    private boolean nextValue;
    private int mValueOne, mValueTwo;
    private String a = "";
    private HashMap<Operator, Calculation> map = new HashMap<Operator, Calculation>() {{
        put(ADD, new AddCalculator());
        put(SUB, new SubCalculator());
        put(DIV, new DivCalculator());
        put(MUL, new MulCalculator());
    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        input = findViewById(R.id.input);
        button_div = findViewById(R.id.button_div);
        button_multiple = findViewById(R.id.button_multiple);
        button_addition = findViewById(R.id.button_addition);
        button_subtract = findViewById(R.id.button_subtract);
        button_equals = findViewById(R.id.button_equals);
        button_clear = findViewById(R.id.button_clear);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((TextView) v).getText().toString();
                input.setText(input.getText().toString() + text);
                if (nextValue) {
                    a += text;
                    mValueTwo = Integer.parseInt(a);
                }
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


        button_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Integer.parseInt(input.getText() + "");
                nextValue = true;
                operator = ADD;
                input.setText(input.getText() + "+");
            }
        });

        button_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Integer.parseInt(input.getText() + "");
                nextValue = true;
                operator = SUB;
                input.setText(input.getText() + "-");
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                mValueOne = 0;
                mValueTwo = 0;
                a = "";
                operator = null;
                nextValue = false;

            }
        });

        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Integer.parseInt(input.getText() + "");
                nextValue = true;
                operator = DIV;
                input.setText(input.getText() + "/");
            }
        });

        button_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Integer.parseInt(input.getText() + "");
                nextValue = true;
                operator = MUL;
                input.setText(input.getText() + "*");
            }
        });

        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText() + "=");
                int finalValue = map.get(operator).calculate(mValueOne, mValueTwo);

                input.setText(String.valueOf(finalValue));
                mValueOne = 0;
                mValueTwo = 0;
                a = "";
                operator = null;

            }
        });


    }

}
