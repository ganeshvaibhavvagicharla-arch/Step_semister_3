package Abstraction_interface_classvsinterface.assignment_problems;


import java.util.ArrayList;
import java.util.List;

public class CanteenBillingCounter {

    abstract static class Customer {
        protected double amount;

        public Customer(double amount) {
            this.amount = amount;
        }

        public abstract String getCustomerType();
        public abstract double calculateFinalAmount();
    }

    static class Student extends Customer {
        public Student(double amount) { super(amount); }

        @Override
        public String getCustomerType() { return "STUDENT"; }

        @Override
        public double calculateFinalAmount() { return amount * 0.90; }
    }

    static class Staff extends Customer {
        public Staff(double amount) { super(amount); }

        @Override
        public String getCustomerType() { return "STAFF"; }

        @Override
        public double calculateFinalAmount() { return amount * 0.95; }
    }

    static class Guest extends Customer {
        public Guest(double amount) { super(amount); }

        @Override
        public String getCustomerType() { return "GUEST"; }

        @Override
        public double calculateFinalAmount() { return amount + 10.00; }
    }

    public static void main(String[] args) {
        List<Customer> bills = new ArrayList<>();

        // Test Data
        bills.add(new Student(100.00));
        bills.add(new Staff(200.00));
        bills.add(new Guest(50.00));

        double grandTotal = 0.0;
        for (Customer bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f%n", bill.getCustomerType(), finalAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
    }
}