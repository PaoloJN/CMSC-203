package com.example.management;/*
 * Class: CMSC203 
 * Instructor:
 * Description: Manages properties, ensures they do not overlap, and calculates rent/fees.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse/Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __________
 */

public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Constructors
    public ManagementCompany() {
        this("", "", 0);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = new Plot(otherCompany.plot);
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
        this.numberOfProperties = otherCompany.numberOfProperties;
    }

    // Add property overloads
    public int addProperty(Property property) {
        if (numberOfProperties >= MAX_PROPERTY) return -1;
        if (property == null) return -2;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        properties[numberOfProperties] = new Property(property);
        return numberOfProperties++;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner,
                           int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Accessors
    public String getName() { return name; }
    public Plot getPlot() { return plot; }
    public Property[] getProperties() { return properties; }
    public int getPropertiesCount() { return numberOfProperties; }
    public boolean isPropertiesFull() { return numberOfProperties >= MAX_PROPERTY; }
    public boolean isManagementFeeValid() { return mgmFee >= 0 && mgmFee <= 100; }

    // Remove last
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    // Rent helpers
    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;

        Property highest = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name)
          .append(", taxID: ").append(taxID).append("\n")
          .append("______________________________________________________\n");
        
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }

        sb.append("______________________________________________________\n\n");
        double totalRent = getTotalRent();
        sb.append(" total management Fee: ").append(String.format("%.2f", totalRent * (mgmFee / 100)));

        return sb.toString();
    }
}
