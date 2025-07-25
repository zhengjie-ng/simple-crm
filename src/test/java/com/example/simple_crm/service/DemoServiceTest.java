package com.example.simple_crm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoServiceTest {
    private DemoService demoService;

    @BeforeEach
    public void init() {
        demoService = new DemoService();
    }

    // @Test - one test case that checks a specific scenario in your code
    @Test
    public void testAdd() {
        // 1. SETUP / ARRANGE
        // Create the instance of the class to test
        // DemoService demoService = new DemoService();
        // Define expected result
        int expectedResult = 8;

        // 2. EXECUTE / ACT
        int actualResult = demoService.add(3, 5);

        // 3. ASSERT
        // Compare the actual result with the expected result
        assertEquals(expectedResult, actualResult, "3 + 5 should be 8");

    }

    @Test
    public void testSubtract() {
        // 1.SETUP / ARRANGE
        // Create the instance of the class to test
        // DemoService demoService = new DemoService();
        // Define expected result
        int expectedResult = 2;

        // 2. EXECUTE / ACT
        int actualResult = demoService.substract(5, 3);

        // 3. ASSERT
        // Compare the actual result with the expected result
        assertEquals(expectedResult, actualResult, "5 - 3 should be 2");

    }

    @Test
    public void testMultiply() {
        // ARRANGE
        int expectedResult = 15;

        // ACT
        int actualResult = demoService.multiply(3, 5);

        // ASSERT
        assertEquals(expectedResult, actualResult, "3 * 5 should be 15");
    }

    @Test
    public void testDivide() {
        // ARRANGE
        int expectedResult = 2;

        // ACT
        int actualResult = demoService.divide(10, 5);

        // ASSERT
        assertEquals(expectedResult, actualResult, "10 / 5 should be 2");
    }

    @Test
    public void divide_byZero_throwsArithmeticException() {

        assertThrows(ArithmeticException.class, () -> demoService.divide(10, 0));
    }

    @Test
    public void testIsEven() {
        // ARRANGE

        // ACT
        boolean actualResult1 = demoService.isEven(2);
        boolean actualResult2 = demoService.isEven(23);

        // ASSERT
        assertEquals(true, actualResult1, "2 is an even number");
        assertEquals(false, actualResult2, "3 is an even number");
    }

    // How to design test cases
    /*
     * 1. What is the purpose of the method?
     * to test whether an int is an even number
     * 2. What are the valid input ranges and equivalent partitions (groups)?
     * inputs: Integer.MIN_VALUE to Integer.MAX_VALUE
     * group of even numbers : .., -2, 0, 2, 4, ...
     * group of odd numbers: ..., -1, 1, 3, 5, ...
     * 3. Boundary values / Edge cases
     * Integer.MIN_VALUE and Integer.MAX_VALUE
     * 
     * Test cases
     * 1. test a number is even returns true
     * 2. test a number is odd returns false
     * 3. test Integer.MIN_VALUE returns true (..8)
     * 4. test Integer.MAX_VALUE returns false (...7)
     * 
     * methodName_scenario_expectedOutcome
     * isEven_evenNumber_returnsTrue()
     * isEven_oddNumber_returnsFalse()
     * isEven_minInt_returnsTrue()
     * isEven_maxInt_returnsFalse()
     * 
     */

    @Test
    public void isEven_evenNumber_returnsTrue() {
        int number = 4;

        boolean result = demoService.isEven(number);

        assertEquals(true, result, number + " should be even");
    }

    @Test
    public void isEven_oddNumber_returnsFalse() {
        int number = 5;
        boolean result = demoService.isEven(number);
        assertEquals(false, result, number + " should not be even");
    }

    @Test
    public void isEven_minInt_returnsTrue() {
        int number = Integer.MIN_VALUE;
        boolean result = demoService.isEven(number);
        assertEquals(true, result, number + " should be even");
    }

    @Test
    public void isEven_maxInt_returnsFalse() {
        int number = Integer.MAX_VALUE;
        boolean result = demoService.isEven(number);
        assertEquals(false, result, number + " should not be even");
    }

}
