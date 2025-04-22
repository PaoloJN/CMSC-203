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

public class TwoDimRaggedArrayUtilityTestStudent {

    private static final double DELTA = 0.01;

    double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0},
            {5.0, 6.0}
    };

    @Test
    public void testGetTotal() {
        assertEquals(21.0, TwoDimRaggedArrayUtility.getTotal(data), DELTA);
    }

    @Test
    public void testGetAverage() {
        assertEquals(3.5, TwoDimRaggedArrayUtility.getAverage(data), DELTA);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(data, 0), DELTA);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(10.0, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), DELTA);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 0), DELTA);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 0), DELTA);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInColumn(data, 0), DELTA);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(data, 0), DELTA);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInArray(data), DELTA);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(data), DELTA);
    }
}
