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

public class Customer {

  private String name;
  private int age;

  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Customer(Customer other) {
    this.name = other.name;
    this.age = other.age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Customer Name: " + name + ", Age: " + age;
  }
}
