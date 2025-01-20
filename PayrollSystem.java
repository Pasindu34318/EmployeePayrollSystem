import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String empId;
    private String name;
    private String designation;
    private double basicSalary;
    private double allowances;
    private double taxDeduction;
    private double netSalary;

    public Employee(String empId, String name, String designation, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
        this.allowances = 0.2 * basicSalary; 
        this.taxDeduction = 0.1 * basicSalary; 
        calculateNetSalary();
    }

    private void calculateNetSalary() {
        double grossSalary = basicSalary + allowances;
        this.netSalary = grossSalary - taxDeduction;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.printf("Basic Salary: $%.2f\n", basicSalary);
        System.out.printf("Allowances: $%.2f\n", allowances);
        System.out.printf("Tax Deduction: $%.2f\n", taxDeduction);
        System.out.printf("Net Salary: $%.2f\n", netSalary);
    }
}

public class PayrollSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEmployee Payroll System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Payroll");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayPayroll();
                    break;
                case 3:
                    System.out.println("Exiting the Payroll System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        Employee employee = new Employee(empId, name, designation, basicSalary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    private static void displayPayroll() {
        if (employees.isEmpty()) {
            System.out.println("No employees added yet.");
        } else {
            for (Employee emp : employees) {
                System.out.println("\n--------------------");
                emp.displayDetails();
            }
        }
    }
}