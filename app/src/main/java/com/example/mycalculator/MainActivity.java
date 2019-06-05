package com.example.mycalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(Button) casts    to find something in the layout you will use findViewById
        // R is your resource obj and then another separator to allow you to use id then property
        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9fix);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        Button btnMultiply = (Button) findViewById(R.id.btnMultiply);
        Button btnEquals = (Button) findViewById(R.id.btnEquals);
        Button btnDivide = findViewById(R.id.btnDivide);

        //each new operation stored in a list
        final Operations op = new Operations();

        // this is a bit of an odd method.
        // OnClickListener is defined to be an interface. We cannot instantiate this
        // so we provide implementation on the spot inside the argument

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  { op.push(0); }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.push(1);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  { op.push(2); }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { op.push(3); }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  { op.push(4); }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { op.push(5); }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                op.push(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.push(7);
                 }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { op.push(8); }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { op.push(9); }

        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pushChar('x');
                op.organiseStack();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pushChar('+');
                op.organiseStack();

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pushChar('-');
                op.organiseStack();
            }

        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pushChar('/');
                op.organiseStack();

            }
        });


        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.organiseStack();
                System.out.println(op.stackCalculate());
            }
        });
    }
}
