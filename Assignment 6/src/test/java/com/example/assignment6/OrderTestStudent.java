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
 * from a student or any source. I hav9e not given my code
 * to any student.
 *
 * Print your Name here: Paolo Nessim
 */

public class OrderTestStudent {

  Order orderA, orderB;

  @Before
  public void setUp() throws Exception {
    orderA = new Order(9, Day.TUESDAY, new Customer("Liam", 30));
    orderB = new Order(14, Day.FRIDAY, new Customer("Emma", 19));
  }

  @After
  public void tearDown() throws Exception {
    orderA = orderB = null;
  }

  @Test
  public void testGetBeverage() {
    Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, false);
    Alcohol alcohol = new Alcohol("Wine", Size.LARGE, true);
    Smoothie smoothie = new Smoothie("Berry", Size.SMALL, 2, true);

    orderA.addNewBeverage("Latte", Size.MEDIUM, true, false);
    orderA.addNewBeverage("Wine", Size.LARGE);
    orderA.addNewBeverage("Berry", Size.SMALL, 2, true);

    assertEquals(coffee, orderA.getBeverage(0));
    assertEquals(alcohol, orderA.getBeverage(1));
    assertEquals(smoothie, orderA.getBeverage(2));
  }

  @Test
  public void testAddNewBeverage() {
    assertEquals(0, orderB.getTotalItems());

    orderB.addNewBeverage("Espresso", Size.SMALL, false, true);
    assertEquals(Type.COFFEE, orderB.getBeverage(0).getType());

    orderB.addNewBeverage("Beer", Size.MEDIUM);
    assertEquals(Type.ALCOHOL, orderB.getBeverage(1).getType());

    orderB.addNewBeverage("Tropical", Size.LARGE, 3, false);
    assertEquals(Type.SMOOTHIE, orderB.getBeverage(2).getType());

    assertEquals(3, orderB.getTotalItems());
  }

  @Test
  public void testCalcOrderTotal() {
    orderA.addNewBeverage("Latte", Size.MEDIUM, true, false); // 3.5
    orderA.addNewBeverage("Wine", Size.LARGE); // 3.2
    orderA.addNewBeverage("Berry", Size.SMALL, 2, true); // 4.5

    assertEquals(11.2, orderA.calcOrderTotal(), 0.01);

    orderB.addNewBeverage("Espresso", Size.SMALL, false, true); // 2.5
    orderB.addNewBeverage("Beer", Size.MEDIUM); // 2.6
    orderB.addNewBeverage("Tropical", Size.LARGE, 3, true); // 6.5

    assertEquals(11.6, orderB.calcOrderTotal(), 0.01);
  }
}
