package Abstraction_interface_classvsinterface.assignment_problems;

import java.util.ArrayList;
import java.util.List;

public class FestivalBonusCalculator {

    abstract static class Employee {
        protected String name;
        protected double monthlySalary;

        public Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public String getName() { return name; }
        public abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }

        @Override
        public double calculateBonus() { return monthlySalary * 0.10; }
    }

    static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double monthlySalary) { super(name, monthlySalary); }

        @Override
        public double calculateBonus() { return monthlySalary * 0.05; }
    }

    static class Intern extends Employee {
        public Intern(String name, double monthlySalary) { super(name, monthlySalary); }

        @Override
        public double calculateBonus() { return 2000.00; }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Test Data
        employees.add(new FullTimeEmployee("Alice", 50000));
        employees.add(new PartTimeEmployee("Bob", 20000));
        employees.add(new Intern("Charlie", 15000));

        double grandTotal = 0.0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", grandTotal);
    }
}
