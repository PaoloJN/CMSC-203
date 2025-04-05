package com.example.management;/*
 * Class: CMSC203 
 * Instructor:
 * Description: This class defines a Plot with coordinates and dimensions, and checks overlaps and encompassing.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse/Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __________
 */

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    // Getters/Setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getDepth() { return depth; }
    public void setDepth(int depth) { this.depth = depth; }

    // Check overlap
    public boolean overlaps(Plot other) {
        return !(other.x >= this.x + this.width ||
                 other.x + other.width <= this.x ||
                 other.y >= this.y + this.depth ||
                 other.y + other.depth <= this.y);
    }

    // Check if this encompasses the other
    public boolean encompasses(Plot other) {
        return (other.x >= this.x &&
                other.y >= this.y &&
                other.x + other.width <= this.x + this.width &&
                other.y + other.depth <= this.y + this.depth);
    }

    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
