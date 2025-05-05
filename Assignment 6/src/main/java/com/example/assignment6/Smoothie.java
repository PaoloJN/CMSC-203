package com.example.assignment6;

/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Description: This class is part of the Bradley Beverage Shop simulation. It models a component of a beverage ordering system.
 * Due: 05/03/2025
 * Platform/compiler: Java JDK 17 / IntelliJ IDEA
 *
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 *
 * Print your Name here: Paolo Nessim
 */

public class Smoothie extends Beverage {

  private static final double PROTEIN_COST = 1.5;
  private static final double FRUIT_COST = 0.5;

  private int numOfFruits;
  private boolean addProtein;

  public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
    super(name, Type.SMOOTHIE, size);
    this.numOfFruits = numOfFruits;
    this.addProtein = addProtein;
  }

  @Override
  public double calcPrice() {
    double price = addSizePrice();
    price += numOfFruits * FRUIT_COST;
    if (addProtein) price += PROTEIN_COST;
    return price;
  }

  @Override
  public String toString() {
    return (
      super.toString() +
      " [Smoothie, Fruits: " +
      numOfFruits +
      ", Protein: " +
      addProtein +
      ", Price: $" +
      String.format("%.2f", calcPrice()) +
      "]"
    );
  }

  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    Smoothie other = (Smoothie) obj;
    return numOfFruits == other.numOfFruits && addProtein == other.addProtein;
  }

  public int getNumOfFruits() {
    return numOfFruits;
  }

  public boolean getAddProtein() {
    return addProtein;
  }

  public void setNumOfFruits(int numOfFruits) {
    this.numOfFruits = numOfFruits;
  }

  public void setAddProtein(boolean addProtein) {
    this.addProtein = addProtein;
  }
}
