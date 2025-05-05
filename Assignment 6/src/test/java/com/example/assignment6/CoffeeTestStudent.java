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

public class CoffeeTestStudent {

  Coffee coffee1, coffee2, coffee3;

  @Before
  public void setUp() throws Exception {
    coffee1 = new Coffee("Latte", Size.SMALL, false, false);
    coffee2 = new Coffee("Espresso", Size.LARGE, true, true);
    coffee3 = new Coffee("Espresso", Size.LARGE, true, true);
  }

  @After
  public void tearDown() throws Exception {
    coffee1 = coffee2 = coffee3 = null;
  }

  @Test
  public void testGetters() {
    assertEquals("Latte", coffee1.getName());
    assertEquals(Size.SMALL, coffee1.getSize());
    assertEquals(Type.COFFEE, coffee1.getType());
    assertFalse(coffee1.getExtraShot());
    assertFalse(coffee1.getExtraSyrup());
  }

  @Test
  public void testSetters() {
    coffee1.setExtraShot(true);
    coffee1.setExtraSyrup(true);
    assertTrue(coffee1.getExtraShot());
    assertTrue(coffee1.getExtraSyrup());
  }

  @Test
  public void testEquals() {
    assertTrue(coffee2.equals(coffee3));
    assertFalse(coffee1.equals(coffee2));
  }

  @Test
  public void testCalcPrice() {
    double expectedPrice = 2.0 + (2 * 0.5) + 0.5 + 0.5;
    assertEquals(expectedPrice, coffee2.calcPrice(), 0.01);

    assertEquals(2.0, coffee1.calcPrice(), 0.01);
  }

  @Test
  public void testToString() {
    String result = coffee2.toString();
    assertTrue(result.contains("Espresso"));
    assertTrue(result.contains("Extra Shot: true"));
    assertTrue(result.contains("Extra Syrup: true"));
  }
}
