package ra.bussiness;

import ra.entity.Employee;
import ra.presentation.EmployeeAppication;
import ra.validate.Validation;

import java.util.Scanner;

public class EmployeeBussiness {
    static Scanner scanner = new Scanner(System.in);

    public static void addEmployee() {
        if (EmployeeAppication.index >= EmployeeAppication.arrEmployees.length) {
            System.out.println("Employee list is full! Cannot add more employees.");
            return;
        }
        Employee em = new Employee();
        em.inputData(scanner);
        EmployeeAppication.arrEmployees[EmployeeAppication.index] = em;
        EmployeeAppication.index++;
        System.out.println("Employee added successfully.");
    }

    public static void displayEmployees() {
        if (EmployeeAppication.index == 0) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("Employee List:");
        for (int i = 0; i < EmployeeAppication.index; i++) {
            EmployeeAppication.arrEmployees[i].displayData();
        }
    }

    public static void updateEmployeeInformation() {
        System.out.print("Enter employee ID to update: ");
        String id = scanner.nextLine();

        for (int i = 0; i < EmployeeAppication.index; i++) {
            if (EmployeeAppication.arrEmployees[i].getEmployeeId().equals(id)) {
                Employee employee = EmployeeAppication.arrEmployees[i];

                System.out.println("******* Update Employee Information ********");
                System.out.println("1. Update employee ID");
                System.out.println("2. Update employee name");
                System.out.println("3. Update employee birthday");
                System.out.println("4. Update employee phone number");
                System.out.println("5. Update employee salary coefficient");
                System.out.println("6. Update employee sex");
                System.out.println("7. Update employee department");
                System.out.println("8. Return");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter new employee ID: ");
                        String newId = scanner.nextLine();
                        employee.setEmployeeId(Validation.existEmployee(scanner, newId, i));
                        break;
                    case 2:
                        System.out.print("Enter new employee name: ");
                        employee.setEmployeeName(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter new employee birthday (dd/MM/yyyy): ");
                        employee.setBirthday(scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Enter new phone number: ");
                        employee.setPhoneNumber(scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Enter new salary coefficient: ");
                        float newCoefficient = scanner.nextFloat();
                        scanner.nextLine();
                        employee.setCoefficient(newCoefficient);
                        break;
                    case 6:
                        System.out.print("Enter new sex (true for Male, false for Female): ");
                        boolean newSex = scanner.nextBoolean();
                        scanner.nextLine();
                        employee.setSex(newSex);
                        break;
                    case 7:
                        System.out.print("Enter new department: ");
                        employee.setDepartment(scanner.nextLine());
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee ID not found.");
    }


    public static void removeEmployee() {
        System.out.print("Enter employee ID to remove: ");
        String id = scanner.nextLine();
        for (int i = 0; i < EmployeeAppication.index; i++) {
            if (EmployeeAppication.arrEmployees[i].getEmployeeId().equals(id)) {
                for (int j = i; j < EmployeeAppication.index - 1; j++) {
                    EmployeeAppication.arrEmployees[j] = EmployeeAppication.arrEmployees[j + 1];
                }
                EmployeeAppication.index--;
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee ID not found.");
    }

    public static void searchEmployee() {
        do {
            System.out.println("1. Search employee by ID");
            System.out.println("2. Search employee by Department");
            System.out.println("3. Search employee by Salary Range");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    String id = scanner.nextLine();
                    boolean foundById = false;
                    for (int i = 0; i < EmployeeAppication.index; i++) {
                        if (EmployeeAppication.arrEmployees[i].getEmployeeId().equals(id)) {
                            EmployeeAppication.arrEmployees[i].displayData();
                            foundById = true;
                            break;
                        }
                    }
                    if (!foundById) {
                        System.out.println("Employee ID not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter department name: ");
                    String department = scanner.nextLine();
                    boolean foundByDepartment = false;
                    for (int i = 0; i < EmployeeAppication.index; i++) {
                        if (EmployeeAppication.arrEmployees[i].getDepartment().equalsIgnoreCase(department)) {
                            EmployeeAppication.arrEmployees[i].displayData();
                            foundByDepartment = true;
                        }
                    }
                    if (!foundByDepartment) {
                        System.out.println("No employees found in this department.");
                    }
                    break;

                case 3:
                    System.out.print("Enter minimum salary: ");
                    float minSalary = scanner.nextFloat();
                    System.out.print("Enter maximum salary: ");
                    float maxSalary = scanner.nextFloat();
                    scanner.nextLine();

                    boolean foundBySalary = false;
                    for (int i = 0; i < EmployeeAppication.index; i++) {
                        float totalSalary = EmployeeAppication.arrEmployees[i].getCoefficient() * Employee.BASE_SALARY +
                                EmployeeAppication.arrEmployees[i].getAllowanceSalary();
                        if (totalSalary >= minSalary && totalSalary <= maxSalary) {
                            EmployeeAppication.arrEmployees[i].displayData();
                            foundBySalary = true;
                        }
                    }
                    if (!foundBySalary) {
                        System.out.println("No employees found in this salary range.");
                    }
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (true);
    }

    public static void sortBy() {
        if (EmployeeAppication.index == 0) {
            System.out.println("No employees found.");
            return;
        }

        do {
            System.out.println("******* Sort Employee List ********");
            System.out.println("1. Sort by Name (A-Z)");
            System.out.println("2. Sort by Total Salary (Ascending)");
            System.out.println("3. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for (int i = 0; i < EmployeeAppication.index - 1; i++) {
                        for (int j = i + 1; j < EmployeeAppication.index; j++) {
                            if (EmployeeAppication.arrEmployees[i].getEmployeeName().compareToIgnoreCase(
                                    EmployeeAppication.arrEmployees[j].getEmployeeName()) > 0) {
                                Employee temp = EmployeeAppication.arrEmployees[i];
                                EmployeeAppication.arrEmployees[i] = EmployeeAppication.arrEmployees[j];
                                EmployeeAppication.arrEmployees[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sorted by Name (A-Z).");
                    break;

                case 2:
                    for (int i = 0; i < EmployeeAppication.index - 1; i++) {
                        for (int j = i + 1; j < EmployeeAppication.index; j++) {
                            float salary1 = EmployeeAppication.arrEmployees[i].getCoefficient() * Employee.BASE_SALARY
                                    + EmployeeAppication.arrEmployees[i].getAllowanceSalary();
                            float salary2 = EmployeeAppication.arrEmployees[j].getCoefficient() * Employee.BASE_SALARY
                                    + EmployeeAppication.arrEmployees[j].getAllowanceSalary();
                            if (salary1 > salary2) {
                                Employee temp = EmployeeAppication.arrEmployees[i];
                                EmployeeAppication.arrEmployees[i] = EmployeeAppication.arrEmployees[j];
                                EmployeeAppication.arrEmployees[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sorted by Total Salary (Ascending).");
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (true);
    }

}
