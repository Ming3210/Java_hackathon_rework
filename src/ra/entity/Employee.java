package ra.entity;

import ra.validate.Validation;

import java.util.Scanner;

public class Employee implements IApp{
    private String employeeId;
    private String employeeName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private float coefficient;
    private int allowanceSalary;
    private String department;
    private byte status;
    Scanner scanner = new Scanner(System.in);

    public Employee(int allowanceSalary, String birthday, float coefficient, String department, String employeeId, String employeeName, String phoneNumber, boolean sex, byte status) {
        this.allowanceSalary = allowanceSalary;
        this.birthday = birthday;
        this.coefficient = coefficient;
        this.department = department;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.status = status;
    }

    public int getAllowanceSalary() {
        return allowanceSalary;
    }

    public void setAllowanceSalary(int allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Employee() {
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Enter employee ID:");
        String string = inputEmployeeId(scanner);
        Validation.existEmployee(scanner, string, -1);
        this.employeeId = inputEmployeeId(scanner);
        Validation.isString(scanner, "Employee Name");
        System.out.println("Enter birthday:");
        this.birthday = inputBirthday(scanner);
        System.out.println("Enter phone number:");
        this.phoneNumber = inputPhoneNumber(scanner);
        this.sex = Validation.isBoolean(scanner, "Enter sex (true: male, false: female):");
        this.coefficient = Validation.isFloat(scanner, "Enter coefficient",0);
        this.allowanceSalary = Validation.isInteger(scanner, "Enter allowance salary", 0);
        this.department = Validation.isString(scanner, "Enter department");
    }

    public String inputEmployeeId(Scanner scanner){
        return Validation.EmployeeValidate(scanner,  "NV\\d{4}");
    }
    public String inputBirthday(Scanner scanner){
        return Validation.EmployeeValidate(scanner,  "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}");
    }
    public String inputPhoneNumber(Scanner scanner){
        return Validation.EmployeeValidate(scanner,  "\\d{10}");
    }


    @Override
    public void displayData() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Birthday: " + birthday);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Sex: " + (sex? "Male" : "Female"));
        System.out.println("Coefficient: " + coefficient);
        System.out.println("Allowance Salary: " + allowanceSalary);
        System.out.println("Department: " + department);
        System.out.println("Status: " + (status == 1 ? "Đang làm việc" : (status == 2 ? "Đang nghỉ phép" : "Đã nghỉ phép")));
        System.out.println("Total Salary: " + BASE_SALARY*coefficient+ allowanceSalary);
    }
}
