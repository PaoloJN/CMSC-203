/*
 * Class: CMSC203
 * Instructor:
 * Description: MovieDriverTask2
 * Due: 02/24/2025 
 * Platform/compiler: IntelliJ / vscode-javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */

import java.util.Scanner;

public class MovieDriverTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput;

        do {
            Movie movie = new Movie();

            System.out.print("Enter the movie title: ");
            String title = scanner.nextLine();
            movie.setTitle(title);

            System.out.print("Enter the movie rating: ");
            String rating = scanner.nextLine();
            movie.setRating(rating);

            System.out.print("Enter the number of tickets sold: ");
            int soldTickets = scanner.nextInt();
            movie.setSoldTickets(soldTickets);
            scanner.nextLine();

            System.out.println(movie);

            System.out.print("Do you want to enter another movie? (yes/no): ");
            continueInput = scanner.nextLine();

        } while (continueInput.equalsIgnoreCase("yes"));

        System.out.println("Program terminated.");
        scanner.close();
    }
}
