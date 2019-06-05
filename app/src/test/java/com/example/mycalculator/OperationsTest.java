package com.example.mycalculator;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class OperationsTest {

    @Test
    public void push() {
    }

    @Test
    public void pushChar() {
    }

    @Test
    public void clearStack() {
    }

    @Test
    public void printStack() {
    }

    @Test
    public void organiseStack() {

        Operations opTest = new Operations();
        Operations opTest2 = new Operations();
        Operations opTest3 = new Operations();
/*
        for(int i = 0; i < 10; i++)
        {
            opTest.push(9);
        }
*/

        opTest.push(9);
        opTest.push(8);

        opTest.organiseStack();

        double actual = opTest.getFirstOrganised();
        double expected = 98;


        assertEquals(expected, actual, 0);
    }

    @Test
    public void test_stackCalculate() {

        Operations opTest = new Operations();

        //÷

        opTest.pushChar('/');
        opTest.pushOrganised(70);
        opTest.pushOrganised(2);

        double actual = opTest.stackCalculate();
        double expected = 35;

        assertEquals(expected, actual, 0);

    }


}