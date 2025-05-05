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

public class AlcoholTestStudent {

  Alcohol alcohol1, alcohol2, alcohol3;

  @Before
  public void setUp() throws Exception {
    alcohol1 = new Alcohol("Beer", Size.SMALL, false);
    alcohol2 = new Alcohol("Wine", Size.LARGE, true);
    alcohol3 = new Alcohol("Wine", Size.LARGE, true);
  }

  @After
  public void tearDown() throws Exception {
    alcohol1 = alcohol2 = alcohol3 = null;
  }

  @Test
  public void testGetters() {
    assertEquals("Beer", alcohol1.getName());
    assertEquals(Size.SMALL, alcohol1.getSize());
    assertEquals(Type.ALCOHOL, alcohol1.getType());
    assertFalse(alcohol1.getIsWeekend());
  }

  @Test
  public void testSetters() {
    alcohol1.setIsWeekend(true);
    assertTrue(alcohol1.getIsWeekend());
  }

  @Test
  public void testEquals() {
    assertTrue(alcohol2.equals(alcohol3));
    assertFalse(alcohol1.equals(alcohol2));
  }

  @Test
  public void testCalcPrice() {
    double expectedPrice1 = 2.0;
    assertEquals(expectedPrice1, alcohol1.calcPrice(), 0.01);

    double expectedPrice2 = 2.0 + (2 * 0.5) + 0.6;
    assertEquals(expectedPrice2, alcohol2.calcPrice(), 0.01);
  }

  @Test
  public void testToString() {
    String result = alcohol2.toString();
    assertTrue(result.contains("Wine"));
    assertTrue(result.contains("Weekend: true"));
  }
}
