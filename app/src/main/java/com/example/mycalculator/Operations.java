package com.example.mycalculator;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 *  This class concerns holding and calculating the values inputted by the user
 * @author Micah Edwards
 */
public class Operations {

    // stack holds all the values of a number to be concatenated e.g [4,5,2] to make 452
    private Deque<Integer> stack = new ArrayDeque<>();

    // this stack will hold all values to be used in calculation e.g 452
    private Deque<Double> organisedStack = new ArrayDeque<>();

    // holds all operators to be used in calculation.
    private Deque<Character> charStack = new ArrayDeque<>();

    private boolean finished_calculation = false;
    // this may be used for an ANS button
    private double previous_result = 0;
    private boolean signal_syntax_error = false;

    public Operations() {

    }

    public void push(int a){
        stack.push(a);
    }

    public void pushChar(char a) {
        charStack.push(a);
    }

    public void pushOrganised(double a) {
        organisedStack.push(a);
    }

    // for debugging purposes
    public double getFirstOrganised() {
        return organisedStack.getFirst();
    }

    public boolean getErrorSignal() { return signal_syntax_error; }

    public boolean getFinishedCalc() { return finished_calculation; }

    public double getAns() { return previous_result; }


    public void setFinished(boolean a) { finished_calculation = a; }

    public void setErrorSignal(boolean a) { signal_syntax_error = false; }


    public double sum() {
        double result = 0;

        for(int i = 0; i < organisedStack.size(); i++)
        {
            result += organisedStack.getFirst();
            organisedStack.pop();
        }

        return result;
    }

    // concatenates numbers together in the stack
    public int organiseStack() {

        StringBuilder result = new StringBuilder();
        int i, a, b, n = stack.size();

        for (i = 0; i < n; i++)
        {
            a = stack.getFirst();
            result.append(a);
            stack.pop();
        }

        // we have been appending values from right to left, so reverse
        result = result.reverse();


        try {
            b = Integer.parseInt(result.toString());
            organisedStack.push((double) b);
            stack.clear();
        }

        catch( Exception error) {
            signal_syntax_error = true;
            stack.clear();
            organisedStack.clear();
            charStack.clear();

            return -1;
        }

        return 1;
    }

    public double stackCalculate() {

        double a = 0, b = 0, result = 0;
        char operator;


        try {

            int n = charStack.size();

            for (int i = 0; i < n; i++) {

                a = organisedStack.getLast();
                organisedStack.removeLast();
                b = organisedStack.getLast();
                organisedStack.removeLast();


                if (a != 0 && b != 0) {
                    operator = charStack.getLast();

                    switch (operator) {

                        case '+':
                            result = a + b;
                            break;

                        case '-':
                            result = a - b;
                            break;

                        case 'x':
                            result = a * b;
                            break;

                        case '/':
                            result = a / b;
                            break;

                    }
                    // pop involved operands and operators off the stack
                    charStack.removeLast();

                    organisedStack.addLast(result);

                    a = 0;
                    b = 0;
                }
            }

            result = sum();

            previous_result = result;
            finished_calculation = true;

            return result;

        }

        catch (Exception error) {
            signal_syntax_error = true;
            return 0;
        }

    }



}