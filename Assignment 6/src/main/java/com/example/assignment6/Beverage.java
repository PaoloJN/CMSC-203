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

public abstract class Beverage {

  private String name;
  private Type type;
  private Size size;
  protected final double BASE_PRICE = 2.0;
  protected final double SIZE_PRICE = 0.5;

  public Beverage(String name, Type type, Size size) {
    this.name = name;
    this.type = type;
    this.size = size;
  }

  public double addSizePrice() {
    switch (size) {
      case MEDIUM:
        return BASE_PRICE + SIZE_PRICE;
      case LARGE:
        return BASE_PRICE + 2 * SIZE_PRICE;
      default:
        return BASE_PRICE;
    }
  }

  public abstract double calcPrice();

  @Override
  public String toString() {
    return name + ", " + size;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Beverage) {
      Beverage b = (Beverage) obj;
      return name.equals(b.name) && type == b.type && size == b.size;
    }
    return false;
  }

  public String getName() {
    return name;
  }

  public Type getType() {
    return type;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }
}
