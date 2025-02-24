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


public class Procedure {
    private String procedureName;
    private String procedureDate;
    private String practitioner;
    private double charges;

    public Procedure() {
        this.procedureName = "";
        this.procedureDate = "";
        this.practitioner = "N/A";
        this.charges = 0.0;
    }

    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitioner = "N/A";
        this.charges = 0.0;
    }

    public Procedure(String procedureName, String procedureDate, String practitioner, double charges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitioner = practitioner;
        this.charges = charges;
    }

    public String getProcedureName() { return procedureName; }
    public String getProcedureDate() { return procedureDate; }
    public String getPractitioner() { return practitioner; }
    public double getCharges() { return charges; }

    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public void setProcedureDate(String procedureDate) { this.procedureDate = procedureDate; }
    public void setPractitioner(String practitioner) { this.practitioner = practitioner; }
    public void setCharges(double charges) { this.charges = charges; }

    @Override
    public String toString() {
        return "\n\tProcedure:\t" + procedureName +
                "\n\t\tProcedure Date:\t" + procedureDate +
                "\n\t\tPractitioner:\t" + practitioner +
                "\n\t\tCharge:\t$" + String.format("%.2f", charges);
    }
}
