package com.example.mycalculator;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 *  This class concerns holding and calculating the values inputted by the user
 */
public class Operations {

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Double> organisedStack = new ArrayDeque<>();
    private Deque<Character> charStack = new ArrayDeque<>();

    // this may be used for an ANS button
    private double previous_result;

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



        if (stack.size() <= 0) {
            System.out.println("something went wrong");
        }

        if (stack.size() >= 9) {
            System.out.println("something went wrong2");
        }


        for (i = 0; i < n; i++)
        {
            a = stack.getFirst();
            result.append(a);
            stack.pop();
        }

        // we have been appending values from right to left, so reverse
        result = result.reverse();

        b = Integer.parseInt(result.toString());
        System.out.println((double) b);
        organisedStack.push((double) b);
        stack.clear();

        return 1;
    }

    public double stackCalculate() {

        double a = 0, b = 0, result = 0;
        char operator;

        // generally, there should be n-1 operators in the stack, where n is the number of operands
        if (charStack.size() >= organisedStack.size())
        {
            // *** under construction *** must display this on UI level rather than terminal
            System.out.println("Syntax error");
            return 0.0;
        }

        int n = charStack.size();

        for(int i = 0; i < n; i++)
        {

            a = organisedStack.getLast();
            organisedStack.removeLast();
            b = organisedStack.getLast();
            organisedStack.removeLast();


            if ( a != 0 && b != 0 )
            {
                operator = charStack.getLast();

                switch(operator)    {

                    case '+':
                        result =  a + b;
                        break;

                    case '-':
                        result = a - b;
                        break;

                    case 'x':
                        result =  a * b;
                        break;

                    case '/':
                        result =  a / b;
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

        return result;
    }



}