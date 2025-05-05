package com.example.assignment6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

public class BevShopTestStudent {

  BevShop shop;

  @Before
  public void setUp() throws Exception {
    shop = new BevShop();
  }

  @After
  public void tearDown() throws Exception {
    shop = null;
  }

  @Test
  public void testStartNewOrderAndGetters() {
    shop.startNewOrder(10, Day.MONDAY, "John", 25);
    Order current = shop.getCurrentOrder();
    assertEquals("John", current.getCustomer().getName());
    assertEquals(10, current.getOrderTime());
    assertEquals(Day.MONDAY, current.getOrderDay());
  }

  @Test
  public void testProcessOrdersAndAlcoholLimit() {
    shop.startNewOrder(12, Day.SATURDAY, "Mike", 30);
    shop.processAlcoholOrder("Wine", Size.SMALL);
    shop.processAlcoholOrder("Beer", Size.MEDIUM);
    shop.processAlcoholOrder("Vodka", Size.LARGE);
    shop.processAlcoholOrder("Rum", Size.SMALL);

    assertEquals(3, shop.getNumOfAlcoholDrink());
    assertEquals(3, shop.getCurrentOrder().getTotalItems());
  }

  @Test
  public void testProcessCoffeeAndSmoothieOrders() {
    shop.startNewOrder(11, Day.TUESDAY, "Anna", 20);
    shop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
    shop.processSmoothieOrder("Berry", Size.SMALL, 2, true);

    assertEquals(2, shop.getCurrentOrder().getTotalItems());
    assertEquals(Type.COFFEE, shop.getCurrentOrder().getBeverage(0).getType());
    assertEquals(
      Type.SMOOTHIE,
      shop.getCurrentOrder().getBeverage(1).getType()
    );
  }

  @Test
  public void testTotalMonthlySaleAndOrderLookup() {
    shop.startNewOrder(10, Day.FRIDAY, "Ray", 19);
    shop.processSmoothieOrder("Green", Size.LARGE, 3, true);
    int orderNo = shop.getCurrentOrder().getOrderNo();

    shop.startNewOrder(9, Day.SUNDAY, "Lily", 23);
    shop.processAlcoholOrder("Beer", Size.MEDIUM);

    double total = shop.totalMonthlySale();
    assertEquals(shop.totalNumOfMonthlyOrders(), 2);
    assertEquals(
      total,
      shop.getOrderAtIndex(0).calcOrderTotal() +
      shop.getOrderAtIndex(1).calcOrderTotal(),
      0.01
    );
    assertEquals(0, shop.findOrder(orderNo));
    assertEquals(
      shop.getOrderAtIndex(0).calcOrderTotal(),
      shop.totalOrderPrice(orderNo),
      0.01
    );
  }

  @Test
  public void testValidations() {
    assertTrue(shop.isValidTime(10));
    assertFalse(shop.isValidTime(7));

    assertTrue(shop.isValidAge(21));
    assertFalse(shop.isValidAge(18));

    assertTrue(shop.isMaxFruit(6));
    assertFalse(shop.isMaxFruit(3));
  }

  @Test
  public void testSortOrders() {
    shop.startNewOrder(10, Day.MONDAY, "One", 25);
    int id1 = shop.getCurrentOrder().getOrderNo();
    shop.startNewOrder(11, Day.TUESDAY, "Two", 25);
    int id2 = shop.getCurrentOrder().getOrderNo();
    shop.startNewOrder(12, Day.WEDNESDAY, "Three", 25);
    int id3 = shop.getCurrentOrder().getOrderNo();

    shop.sortOrders();

    int sorted0 = shop.getOrderAtIndex(0).getOrderNo();
    int sorted1 = shop.getOrderAtIndex(1).getOrderNo();
    int sorted2 = shop.getOrderAtIndex(2).getOrderNo();

    assertTrue(sorted0 <= sorted1 && sorted1 <= sorted2);
  }
}
