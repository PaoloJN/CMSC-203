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

public class Alcohol extends Beverage {

  private final double WEEKEND_COST = 0.6;
  private boolean isWeekend;

  public Alcohol(String name, Size size, boolean isWeekend) {
    super(name, Type.ALCOHOL, size);
    this.isWeekend = isWeekend;
  }

  @Override
  public double calcPrice() {
    double price = BASE_PRICE;
    if (getSize() == Size.MEDIUM) {
      price += SIZE_PRICE;
    } else if (getSize() == Size.LARGE) {
      price += 2 * SIZE_PRICE;
    }
    if (isWeekend) {
      price += WEEKEND_COST;
    }
    return price;
  }

  @Override
  public String toString() {
    return (
      super.toString() +
      " [Alcohol, Weekend: " +
      isWeekend +
      ", Price: $" +
      String.format("%.2f", calcPrice()) +
      "]"
    );
  }

  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    Alcohol other = (Alcohol) obj;
    return isWeekend == other.isWeekend;
  }

  public boolean getIsWeekend() {
    return isWeekend;
  }

  public void setIsWeekend(boolean weekend) {
    isWeekend = weekend;
  }
}
