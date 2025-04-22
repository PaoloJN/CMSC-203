package com.example.assignment5;

import java.io.*;
import java.util.*;

/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Due: 04/20/2025
 * Platform/compiler: IntelliJ / vscode-javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList < double[] > list = new ArrayList < > ();

        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split(" ");
            double[] row = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Double.parseDouble(tokens[i]);
            }
            list.add(row);
        }

        scanner.close();
        return list.toArray(new double[list.size()][]);
    }

    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (double[] row: data) {
            for (double value: row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row: data) {
            for (double value: row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        int count = 0;
        double total = 0;
        for (double[] row: data) {
            for (double value: row) {
                total += value;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double val: data[row]) {
            total += val;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length) {
                total += data[row][col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double max = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
            }
        }
        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > data[row][index]) {
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double min = data[row][0];
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
            }
        }
        return min;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < data[row][index]) {
                index = i;
            }
        }
        return index;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length && data[row][col] > max) {
                max = data[row][col];
            }
        }
        return max;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length && data[row][col] > max) {
                max = data[row][col];
                index = row;
            }
        }
        return index;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length && data[row][col] < min) {
                min = data[row][col];
            }
        }
        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length && data[row][col] < min) {
                min = data[row][col];
                index = row;
            }
        }
        return index;
    }

    public static double getHighestInArray(double[][] data) {
        double max = data[0][0];
        for (double[] row: data) {
            for (double value: row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    public static double getLowestInArray(double[][] data) {
        double min = data[0][0];
        for (double[] row: data) {
            for (double value: row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }
}