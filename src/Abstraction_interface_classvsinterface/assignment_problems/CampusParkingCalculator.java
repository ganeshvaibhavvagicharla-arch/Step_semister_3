package Abstraction_interface_classvsinterface.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampusParkingCalculator {

    abstract static class Vehicle {
        protected int hours;

        public Vehicle(int hours) {
            this.hours = hours;
        }

        public abstract String getVehicleType();
        public abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        public Bike(int hours) { super(hours); }

        @Override
        public String getVehicleType() { return "BIKE"; }

        @Override
        public double calculateCharge() { return hours * 10.00; }
    }

    static class Car extends Vehicle {
        public Car(int hours) { super(hours); }

        @Override
        public String getVehicleType() { return "CAR"; }

        @Override
        public double calculateCharge() { return 30.00 + (hours - 1) * 20.00; }
    }

    static class Truck extends Vehicle {
        public Truck(int hours) { super(hours); }

        @Override
        public String getVehicleType() { return "TRUCK"; }

        @Override
        public double calculateCharge() { return Math.max(100.00, hours * 50.00); }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();

            switch (type) {
                case "BIKE":  vehicles.add(new Bike(hours)); break;
                case "CAR":   vehicles.add(new Car(hours)); break;
                case "TRUCK": vehicles.add(new Truck(hours)); break;
            }
        }

        double grandTotal = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f%n", v.getVehicleType(), charge);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}