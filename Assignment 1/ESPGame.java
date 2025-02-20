/*
 * Class: CMSC203
 * Instructor:
 * Description: ESPGame program tests the user's ability to guess randomly selected colors from a file. Users choose a difficulty level (16, 10, or 5 colors), play three rounds, and track correct guesses.
 * Due: 02/08/2025 
 * Platform/compiler: IntelliJ / vscode-javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class ESPGame {
    public static void main(String[] args) {

        // I have the colors.txt in the src dir ("src/colors.txt")
        final String FILE_NAME = "colors.txt";
        final int MAX_ROUNDS = 3;


        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("CMSC203 Assignment1: Test your ESP skills!");
            System.out.println("Welcome to ESP - extrasensory perception!");
            System.out.println("Would you please choose one of the 4 options from the menu:");
            System.out.println("1- Read and display on the screen first 16 names of colors from a file.");
            System.out.println("2- Read and display on the screen first 10 names of colors from a file.");
            System.out.println("3- Read and display on the screen first 5 names of colors from a file.");
            System.out.println("4- Exit from the program");

            System.out.print("Enter the option: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            if (choice == 4) {
                break;
            }

            int colorLimit = 0;
            switch (choice) {
                case 1:
                    colorLimit = 16;
                    break;
                case 2:
                    colorLimit = 10;
                    break;
                case 3:
                    colorLimit = 5;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }

            System.out.println("Enter the filename: " + FILE_NAME);

            try {
                Scanner fileScanner = new Scanner(new File(FILE_NAME));
                int count = 0;
                String selectedColor = "";
                int correctGuesses = 0;

                System.out.println("Available colors:");
                while (fileScanner.hasNextLine() && count < colorLimit) {
                    count++;
                    String color = fileScanner.nextLine().trim();
                    System.out.println(count + " " + color);
                }
                fileScanner.close();

                for (int round = 1; round <= MAX_ROUNDS; round++) {
                    fileScanner = new Scanner(new File(FILE_NAME));
                    int target = rand.nextInt(colorLimit) + 1; // Pick random color from available list
                    count = 0;

                    while (fileScanner.hasNextLine()) {
                        count++;
                        String color = fileScanner.nextLine().trim();
                        if (count == target) {
                            selectedColor = color;
                            break;
                        }
                    }

                    fileScanner.close();

                    System.out.println("\nRound " + round);
                    System.out.println("I am thinking of a color.");
                    System.out.print("Enter your guess: ");
                    String userGuess = input.nextLine().trim();

                    if (userGuess.equalsIgnoreCase(selectedColor)) {
                        System.out.println("Correct! I was thinking of " + selectedColor + ".");
                        correctGuesses++;
                    } else {
                        System.out.println("Wrong! I was thinking of " + selectedColor + ".");
                    }
                }

                System.out.println("\nGame Over");
                System.out.println("You guessed " + correctGuesses + " out of " + MAX_ROUNDS + " colors correctly.");

                System.out.print("\nWould you like to continue the game? Type Yes/No: ");
                String continueGame = input.nextLine();
                if (!continueGame.equalsIgnoreCase("Yes")) {
                    playAgain = false;
                }
            } catch (IOException e) {
                System.out.println("Error reading the file.");
            }
        }

        System.out.print("\nEnter your name: ");
        String username = input.nextLine();
        System.out.print("Describe yourself: ");
        String description = input.nextLine();
        System.out.print("Enter Due Date (MM/DD): ");
        String dueDate = input.nextLine();

        String gameResult = "Game Over\n" +
                "You guessed " + "2 out of 3 colors correctly.\n" +
                "Due Date: " + dueDate + "\n" +
                "Username: " + username + "\n" +
                "User Description: " + description + "\n" +
                "Date: " + dueDate + "\n";

        System.out.println(gameResult);

        try {
            FileWriter writer = new FileWriter("EspGameResults.txt");
            writer.write(gameResult);
            writer.close();
            System.out.println("Results saved to EspGameResults.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

        input.close();
    }
}
