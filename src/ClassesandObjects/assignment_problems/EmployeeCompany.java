package ClassesandObjects.assignment_problems;

public class EmployeeCompany {
    private String empName;
    private double salary;
    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    public EmployeeCompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeCompany("Amit", 50000);
        new EmployeeCompany("Priya", 60000);
        new EmployeeCompany("Rohan", 55000);

        // Access static method via class name
        EmployeeCompany.printCompanyInfo();
    }
}
