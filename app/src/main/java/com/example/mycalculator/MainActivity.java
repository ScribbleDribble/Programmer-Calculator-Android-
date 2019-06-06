package com.example.mycalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;



/**
 * @author Micah Edwards
 *
 * This class details the action to be performed  when a type of button has been clicked
 */
class Action {

    public static void setUpOperandBtn(Operations operation, TextView textView,  int btn_number)
    {

        operation.push(btn_number);

        // reset statuses once calculation is finished

        if (operation.getFinishedCalc() || operation.getErrorSignal())
        {
            textView.setText("");
            operation.setFinished(false);
            operation.setErrorSignal(false);
        }

        // display text to user
        textView.append(Integer.toString(btn_number));

    }

    public static void setUpOperatorBtn(Operations operation, TextView textView, char operator)
    {
        operation.pushChar(operator);
        operation.organiseStack();

        if (operation.getErrorSignal())
        {
            textView.setText("Syntax error");
        }

        else{

            if (operator == '/')
                textView.append("÷");

            else
                textView.append(Character.toString(operator));
        }
    }

}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9fix);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnDivide = findViewById(R.id.btnDivide);

        final Operations op = new Operations();
        final TextView numtext = findViewById(R.id.numText);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  { Action.setUpOperandBtn(op, numtext, 0); }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperandBtn(op, numtext, 1); }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  { Action.setUpOperandBtn(op, numtext, 2); }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperandBtn(op, numtext, 3); }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  { Action.setUpOperandBtn(op, numtext, 4); }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperandBtn(op, numtext, 5);}
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  { Action.setUpOperandBtn(op, numtext, 6); }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperandBtn(op, numtext, 7); }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperandBtn(op, numtext, 8); }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperandBtn(op, numtext, 9); }

        });


        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperatorBtn(op, numtext, 'x'); }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperatorBtn(op, numtext, '+'); }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Action.setUpOperatorBtn(op, numtext, '-'); }

        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Action.setUpOperatorBtn(op, numtext, '/');}
        });


        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double result;

                op.organiseStack();
                result = op.stackCalculate();

                numtext.setText("");
                numtext.append(Double.toString(result));
            }
        });

    }
}
