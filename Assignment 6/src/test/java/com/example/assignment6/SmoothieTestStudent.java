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

public class SmoothieTestStudent {

  Smoothie smoothie1, smoothie2, smoothie3;

  @Before
  public void setUp() throws Exception {
    smoothie1 = new Smoothie("Berry Blast", Size.SMALL, 2, false);
    smoothie2 = new Smoothie("Green Detox", Size.LARGE, 4, true);
    smoothie3 = new Smoothie("Green Detox", Size.LARGE, 4, true);
  }

  @After
  public void tearDown() throws Exception {
    smoothie1 = smoothie2 = smoothie3 = null;
  }

  @Test
  public void testGetters() {
    assertEquals("Berry Blast", smoothie1.getName());
    assertEquals(Size.SMALL, smoothie1.getSize());
    assertEquals(Type.SMOOTHIE, smoothie1.getType());
    assertEquals(2, smoothie1.getNumOfFruits());
    assertFalse(smoothie1.getAddProtein());
  }

  @Test
  public void testSetters() {
    smoothie1.setNumOfFruits(5);
    smoothie1.setAddProtein(true);
    assertEquals(5, smoothie1.getNumOfFruits());
    assertTrue(smoothie1.getAddProtein());
  }

  @Test
  public void testEquals() {
    assertTrue(smoothie2.equals(smoothie3));
    assertFalse(smoothie1.equals(smoothie2));
  }

  @Test
  public void testCalcPrice() {
    double expectedPrice1 = 2.0 + (2 * 0.5);
    assertEquals(expectedPrice1, smoothie1.calcPrice(), 0.01);

    double expectedPrice2 = 2.0 + (2 * 0.5) + (4 * 0.5) + 1.5;
    assertEquals(expectedPrice2, smoothie2.calcPrice(), 0.01);
  }

  @Test
  public void testToString() {
    String result = smoothie2.toString();
    assertTrue(result.contains("Green Detox"));
    assertTrue(result.contains("Fruits: 4"));
    assertTrue(result.contains("Protein: true"));
  }
}
