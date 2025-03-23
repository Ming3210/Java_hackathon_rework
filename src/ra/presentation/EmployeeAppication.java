package ra.presentation;

import ra.entity.Employee;

import java.util.Scanner;

import static ra.bussiness.EmployeeBussiness.*;

public class EmployeeAppication {
    public static final Employee[] arrEmployees = new Employee[100];

    public static int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("=============MENU=============");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Fix Employee Information");
            System.out.println("4. Remove Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Sort By?");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    updateEmployeeInformation();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    sortBy();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (true);
    }

}
