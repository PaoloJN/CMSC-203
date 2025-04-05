package com.example.management;/*
 * Class: CMSC203 
 * Instructor:
 * Description: This class defines a Property with name, location, rent, owner, and a Plot.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse/Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __________
 */

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Constructors
    public Property() {
        this("", "", 0.0, "", 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner,
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);  // Deep copy
    }

    // Getters/Setters
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public double getRentAmount() { return rentAmount; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public Plot getPlot() { return plot; }
    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }

    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
