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

public class CustomerTestStudent {

  Customer customer1, customer2;

  @Before
  public void setUp() throws Exception {
    customer1 = new Customer("Alice", 30);
    customer2 = new Customer(customer1);
  }

  @After
  public void tearDown() throws Exception {
    customer1 = customer2 = null;
  }

  @Test
  public void testConstructorAndGetters() {
    assertEquals("Alice", customer1.getName());
    assertEquals(30, customer1.getAge());
  }

  @Test
  public void testSetters() {
    customer1.setName("Bob");
    customer1.setAge(22);
    assertEquals("Bob", customer1.getName());
    assertEquals(22, customer1.getAge());
  }

  @Test
  public void testCopyConstructor() {
    assertNotSame(customer1, customer2);
    assertEquals(customer1.getName(), customer2.getName());
    assertEquals(customer1.getAge(), customer2.getAge());
  }

  @Test
  public void testToString() {
    String result = customer1.toString();
    assertTrue(result.contains("Customer Name:"));
    assertTrue(result.contains("Age:"));
  }
}
