package com.example.assignment6;

public class BevShopDriverApp {

  public static void main(String[] args) {

    BevShop shop = new BevShop();

    System.out.println("The current order in process can have at most " + shop.getMaxOrderForAlcohol() + " alcoholic beverages.");
    System.out.println("The minimum age to order alcohol drink is " + shop.getMinAgeForAlcohol());

    System.out.println("Start please a new order:");
    shop.startNewOrder(12, Day.SATURDAY, "John", 23);
    System.out.println("Your Total Order for now is " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));

    System.out.println("Would you please enter your name: John");
    System.out.println("Would you please enter your age: 23");
    System.out.println("Your age is above 20 and you are eligible to order alcohol");

    System.out.println("Would you please add an alcohol drink");
    shop.processAlcoholOrder("Wine", Size.SMALL);
    System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
    System.out.println("The Total price on the Order is " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));

    System.out.println("Your current alcohol drink order is less than 4");
    System.out.println("Would you please add a second alcohol drink");
    shop.processAlcoholOrder("Beer", Size.MEDIUM);
    System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
    System.out.println("The Total Price on the Order: " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));

    System.out.println("Your current alcohol drink order is less than 4");
    System.out.println("Add third alcohol drink");
    shop.processAlcoholOrder("Vodka", Size.LARGE);
    System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
    System.out.println("The Total Price on the Order: " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));

    System.out.println("You have a maximum alcohol drinks for this order");
    System.out.println("Would you please add a COFFEE to your order:");
    shop.processCoffeeOrder("Latte", Size.SMALL, true, true);
    System.out.println("Total items on your order is " + shop.getCurrentOrder().getTotalItems());
    System.out.println("The Total Price on the Order: " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));

    System.out.println("#------------------------------------#");

    System.out.println("Would you please start a new order");
    shop.startNewOrder(12, Day.FRIDAY, "Ray", 18);
    System.out.println("Would you please enter your name: Ray");
    System.out.println("Would you please enter your age: 18");
    System.out.println("The Total Price on the Order: " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));

    System.out.println("Would you please add a SMOOTHIE to order");
    shop.processSmoothieOrder("Tropical", Size.LARGE, 3, true);
    System.out.println("The Total Price on the Order: " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));

    System.out.println("Would you please add a SMOOTHIE to order");
    shop.processSmoothieOrder("Berry Blend", Size.SMALL, 2, false);

    System.out.println("Would you please add a COFFEE to order");
    shop.processCoffeeOrder("Espresso", Size.MEDIUM, false, true);
    System.out.println("The Total Price on the Order: " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));

    System.out.println("Would you please add a drink");
    shop.processAlcoholOrder("Whiskey", Size.SMALL);

    if (!shop.isValidAge(18)) {
      System.out.println("Your Age is not appropriate for alcohol drink!!");
    }

    shop.processSmoothieOrder("Fruit Max", Size.SMALL, 5, false);
    System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
    System.out.println("The Total price on the Order: " + String.format("%.2f", shop.getCurrentOrder().calcOrderTotal()));
    System.out.println(" The total number of fruits is 5");
    System.out.println("You reached a Maximum number of fruits");

    double firstOrderTotal = shop.getOrderAtIndex(0).calcOrderTotal();
    double secondOrderTotal = shop.getOrderAtIndex(1).calcOrderTotal();

    System.out.println("Total price on the second Order: " + String.format("%.2f", secondOrderTotal));
    System.out.println("Total amount for all Orders: " + String.format("%.2f", (firstOrderTotal + secondOrderTotal)));
  }
}
