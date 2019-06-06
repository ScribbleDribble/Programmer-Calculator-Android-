package com.example.mycalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        final TextView numtext = findViewById(R.id.numText);



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {


                op.push(0);

                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }

                numtext.append("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.push(1);

                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }

                numtext.append("1");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                op.push(2);
                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }
                numtext.append("2");


            ;}
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.push(3);
                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }
                numtext.append("3");

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {

                op.push(4);
                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }
                numtext.append("4");

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.push(5);
                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }
                numtext.append("5");

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {

                op.push(6);
                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }
                numtext.append("6");


            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }
                op.push(7);
                numtext.append("7");

                 }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }
                op.push(8);
                numtext.append("8");

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (op.getFinishedCalc() || op.getErrorSignal())
                {
                    numtext.setText("");
                    op.setFinished(false);
                    op.setErrorSignal(false);
                }
                op.push(9);
                numtext.append("9");

            }

        });


        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                op.pushChar('x');

                op.organiseStack();

                if (op.getErrorSignal())
                {
                    numtext.setText("Syntax error");
                }

                else
                    numtext.append("x");

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pushChar('+');
                op.organiseStack();

                if (op.getErrorSignal())
                {
                    numtext.setText("Syntax error");
                }

                else
                    numtext.append("+");

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pushChar('-');
                op.organiseStack();

                if (op.getErrorSignal())
                {
                    numtext.setText("Syntax error");
                }

                else
                    numtext.append("-");
            }

        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op.pushChar('/');
                op.organiseStack();

                if (op.getErrorSignal())
                {
                    numtext.setText("Syntax error");
                }

                else
                    numtext.append("÷");

            }
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
