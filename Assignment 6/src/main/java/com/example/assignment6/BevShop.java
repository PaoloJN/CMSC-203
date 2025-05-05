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

public class BevShop implements BevShopInterface {

  private int numOfAlcoholInCurrentOrder;
  private ArrayList<Order> orders;
  private Order currentOrder;

  public BevShop() {
    orders = new ArrayList<>();
  }

  public boolean isValidTime(int time) {
    return time >= MIN_TIME && time <= MAX_TIME;
  }

  public int getMaxNumOfFruits() {
    return MAX_FRUIT;
  }

  public int getMinAgeForAlcohol() {
    return MIN_AGE_FOR_ALCOHOL;
  }

  public boolean isMaxFruit(int numOfFruits) {
    return numOfFruits > MAX_FRUIT;
  }

  public int getMaxOrderForAlcohol() {
    return MAX_ORDER_FOR_ALCOHOL;
  }

  public boolean isEligibleForMore() {
    return numOfAlcoholInCurrentOrder < MAX_ORDER_FOR_ALCOHOL;
  }

  public int getNumOfAlcoholDrink() {
    return numOfAlcoholInCurrentOrder;
  }

  public boolean isValidAge(int age) {
    return age >= MIN_AGE_FOR_ALCOHOL;
  }

  public void startNewOrder(
    int time,
    Day day,
    String customerName,
    int customerAge
  ) {
    currentOrder =
      new Order(time, day, new Customer(customerName, customerAge));
    orders.add(currentOrder);
    numOfAlcoholInCurrentOrder = 0;
  }

  public void processCoffeeOrder(
    String bevName,
    Size size,
    boolean extraShot,
    boolean extraSyrup
  ) {
    currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
  }

  public void processAlcoholOrder(String bevName, Size size) {
    if (isEligibleForMore()) {
      currentOrder.addNewBeverage(bevName, size);
      numOfAlcoholInCurrentOrder++;
    }
  }

  public void processSmoothieOrder(
    String bevName,
    Size size,
    int numOfFruits,
    boolean addProtein
  ) {
    currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
  }

  public int findOrder(int orderNo) {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getOrderNo() == orderNo) {
        return i;
      }
    }
    return -1;
  }

  public double totalOrderPrice(int orderNo) {
    int index = findOrder(orderNo);
    if (index != -1) {
      return orders.get(index).calcOrderTotal();
    }
    return 0.0;
  }

  public double totalMonthlySale() {
    double total = 0;
    for (Order order : orders) {
      total += order.calcOrderTotal();
    }
    return total;
  }

  public int totalNumOfMonthlyOrders() {
    return orders.size();
  }

  public Order getCurrentOrder() {
    return currentOrder;
  }

  public Order getOrderAtIndex(int index) {
    if (index >= 0 && index < orders.size()) {
      return orders.get(index);
    }
    return null;
  }

  public void sortOrders() {
    for (int i = 0; i < orders.size() - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < orders.size(); j++) {
        if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        Order temp = orders.get(i);
        orders.set(i, orders.get(minIndex));
        orders.set(minIndex, temp);
      }
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Order order : orders) {
      sb.append(order.toString()).append("\n");
    }
    sb
      .append("Total Monthly Sale: $")
      .append(String.format("%.2f", totalMonthlySale()));
    return sb.toString();
  }
}
