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

public class Coffee extends Beverage {

  private final double EXTRA_SHOT_COST = 0.5;
  private final double EXTRA_SYRUP_COST = 0.5;
  private boolean extraShot;
  private boolean extraSyrup;

  public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
    super(name, Type.COFFEE, size);
    this.extraShot = extraShot;
    this.extraSyrup = extraSyrup;
  }

  @Override
  public double calcPrice() {
    double price = addSizePrice();
    if (extraShot) price += EXTRA_SHOT_COST;
    if (extraSyrup) price += EXTRA_SYRUP_COST;
    return price;
  }

  @Override
  public String toString() {
    return (
      super.toString() +
      " [Coffee, Extra Shot: " +
      extraShot +
      ", Extra Syrup: " +
      extraSyrup +
      ", Price: $" +
      String.format("%.2f", calcPrice()) +
      "]"
    );
  }

  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    Coffee other = (Coffee) obj;
    return extraShot == other.extraShot && extraSyrup == other.extraSyrup;
  }

  public boolean getExtraShot() {
    return extraShot;
  }

  public boolean getExtraSyrup() {
    return extraSyrup;
  }

  public void setExtraShot(boolean extraShot) {
    this.extraShot = extraShot;
  }

  public void setExtraSyrup(boolean extraSyrup) {
    this.extraSyrup = extraSyrup;
  }
}
