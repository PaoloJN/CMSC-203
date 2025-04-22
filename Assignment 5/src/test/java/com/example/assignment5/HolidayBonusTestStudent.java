package com.example.assignment5;

import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 04/20/2025
 * Platform/compiler: IntelliJ / vscode-javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */

public class HolidayBonusTestStudent {

    private static final double DELTA = 0.01;

    @Test
    public void testSingleColumn() {
        double[][] data = {
                {100.0},
                {300.0},
                {200.0}
        };

        double[] result = HolidayBonus.calculateHolidayBonus(data);

        assertEquals(1000.0, result[0], DELTA); // lowest
        assertEquals(5000.0, result[1], DELTA); // highest
        assertEquals(2000.0, result[2], DELTA); // other
    }

    @Test
    public void testTwoColumns() {
        double[][] data = {
                {200.0, 400.0},
                {300.0, 100.0},
                {100.0, 500.0}
        };

        double[] result = HolidayBonus.calculateHolidayBonus(data);

        assertEquals(4000.0, result[0], DELTA);
        assertEquals(6000.0, result[1], DELTA);
        assertEquals(6000.0, result[2], DELTA);
    }


    @Test
    public void testTotalBonus() {
        double[][] data = {
                {100.0},
                {200.0},
                {300.0}
        };

        double total = HolidayBonus.calculateTotalHolidayBonus(data);

        assertEquals(8000.0, total, DELTA);
    }
}
