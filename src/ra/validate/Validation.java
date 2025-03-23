package ra.validate;

import ra.presentation.EmployeeAppication;

import java.util.Scanner;

public class Validation {
    public static String isString(Scanner scanner, String message) {
        System.out.println(message);
        String inputString;
        do {
            inputString = scanner.nextLine().trim();
            if (!inputString.isEmpty()) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
        } while (true);
    }


    public static int isInteger(Scanner scanner, String message, int min) {
        int input;
        while (true) {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min) {
                    scanner.nextLine();
                    return input;
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
    }


    public static float isFloat(Scanner scanner, String message, int min) {
        float input;
        while (true) {
            System.out.println(message);
            if (scanner.hasNextFloat()) {
                input = scanner.nextFloat();
                if (input >= min) {
                    scanner.nextLine();
                    return input;
                }
            } else {
                System.out.println("Invalid input. Please enter a float.");
                scanner.next();
            }
        }
    }

    public static boolean isBoolean(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("male")) {
                return true;
            } else if (input.equals("female")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'male' or 'female'.");
            }
        }
    }


    public static String EmployeeValidate(Scanner scanner, String regex) {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.matches(regex)) {
                return input;
            }
            System.out.println("Invalid input. Please enter a valid format.");
        }
    }
    public static String existEmployee(Scanner scanner, String employeeId, int indexUpdate) {
        do {
            boolean isExist = false;

            for (int i = 0; i < EmployeeAppication.index; i++) {
                if (EmployeeAppication.arrEmployees[i].getEmployeeId().equalsIgnoreCase(employeeId) && i != indexUpdate) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                return employeeId;
            }
            System.err.println("Employee ID đã tồn tại! Vui lòng nhập lại.");
            employeeId = scanner.nextLine();

        } while (true);
    }

}
