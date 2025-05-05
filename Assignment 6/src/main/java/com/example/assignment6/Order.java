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

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

  private int orderNumber;
  private int orderTime;
  private Day orderDay;
  private Customer customer;
  private ArrayList<Beverage> beverages;

  public Order(int orderTime, Day orderDay, Customer customer) {
    this.orderNumber = generateOrder();
    this.orderTime = orderTime;
    this.orderDay = orderDay;
    this.customer = new Customer(customer);
    this.beverages = new ArrayList<>();
  }

  public int generateOrder() {
    return new Random().nextInt(80001) + 10000;
  }

  public void addNewBeverage(
    String bevName,
    Size size,
    boolean extraShot,
    boolean extraSyrup
  ) {
    beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
  }

  public void addNewBeverage(
    String bevName,
    Size size,
    int numOfFruits,
    boolean addProtein
  ) {
    beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
  }

  public void addNewBeverage(String bevName, Size size) {
    beverages.add(new Alcohol(bevName, size, isWeekend()));
  }

  public Beverage getBeverage(int itemNo) {
    if (itemNo >= 0 && itemNo < beverages.size()) {
      return beverages.get(itemNo);
    }
    return null;
  }

  public int findNumOfBeveType(Type type) {
    int count = 0;
    for (Beverage b : beverages) {
      if (b.getType() == type) {
        count++;
      }
    }
    return count;
  }

  public double calcOrderTotal() {
    double total = 0;
    for (Beverage b : beverages) {
      total += b.calcPrice();
    }
    return total;
  }

  public boolean isWeekend() {
    return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
  }

  public int compareTo(Order other) {
    return Integer.compare(this.orderNumber, other.orderNumber);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Order #: ").append(orderNumber).append("\n");
    sb.append("Time: ").append(orderTime).append("\n");
    sb.append("Day: ").append(orderDay).append("\n");
    sb.append("Customer: ").append(customer).append("\n");
    sb.append("Beverages:\n");
    for (Beverage b : beverages) {
      sb.append(" - ").append(b.toString()).append("\n");
    }
    sb
      .append("Total Price: $")
      .append(String.format("%.2f", calcOrderTotal()))
      .append("\n");
    return sb.toString();
  }

  public int getOrderNo() {
    return orderNumber;
  }

  public int getOrderTime() {
    return orderTime;
  }

  public Day getOrderDay() {
    return orderDay;
  }

  public Customer getCustomer() {
    return new Customer(customer);
  }

  public int getTotalItems() {
    return beverages.size();
  }
}
