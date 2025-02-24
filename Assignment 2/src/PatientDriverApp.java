/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Description: Patient management system that allows users to input and manage patient details.
 * Due: 02/24/2025 
 * Platform/compiler: IntelliJ / vscode-javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */

import java.util.Scanner;

public class PatientDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient Information:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Street Address: ");
        String streetAddress = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("ZIP Code: ");
        String zipCode = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Emergency Contact Name: ");
        String emergencyContactName = scanner.nextLine();
        System.out.print("Emergency Contact Phone: ");
        String emergencyContactPhone = scanner.nextLine();

        Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zipCode, phoneNumber, emergencyContactName, emergencyContactPhone);

        Procedure procedure1 = new Procedure("Physical Exam", "07/20/2019", "Dr. Irvine", 3250.00);
        Procedure procedure2 = new Procedure("X-ray", "07/20/2019", "Dr. Jamison", 5500.43);
        Procedure procedure3 = new Procedure("Blood Test", "07/20/2019", "Dr. Smith", 1400.75);

        displayPatient(patient);
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);

        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.printf("\n\tTotal Charges:\t$%,.2f\n", totalCharges);

        System.out.println("\nStudent Name:\tPaolo Nessim");
        System.out.println("M#:\t21196570");
        System.out.println("Due Date:\t02/24/25");

        // scanner.close();
    }

    public static void displayPatient(Patient patient) {
        System.out.println("\n" + patient.toString());
    }

    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString());
    }

    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }
}
