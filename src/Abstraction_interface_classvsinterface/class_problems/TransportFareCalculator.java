package Abstraction_interface_classvsinterface.class_problems;

import java.util.ArrayList;
import java.util.List;

public class TransportFareCalculator {

    abstract static class Transport {
        protected double distance;

        public Transport(double distance) {
            this.distance = distance;
        }

        public abstract String getType();
        public abstract double calculateFare();
    }

    static class Bus extends Transport {
        public Bus(double distance) { super(distance); }

        @Override
        public String getType() { return "BUS"; }

        @Override
        public double calculateFare() { return Math.min(10.00, 2.00 + distance * 0.10); }
    }

    static class Train extends Transport {
        public Train(double distance) { super(distance); }

        @Override
        public String getType() { return "TRAIN"; }

        @Override
        public double calculateFare() { return 3.00 + distance * 0.15; }
    }

    static class Metro extends Transport {
        private double peakHourFactor;

        public Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        public String getType() { return "METRO"; }

        @Override
        public double calculateFare() { return (1.50 + distance * 0.20) * peakHourFactor; }
    }

    public static void main(String[] args) {
        List<Transport> journeys = new ArrayList<>();

        // Test Data
        journeys.add(new Bus(20.0));
        journeys.add(new Train(50.0));
        journeys.add(new Metro(10.0, 1.25));

        double grandTotal = 0.0;
        for (Transport journey : journeys) {
            double fare = journey.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f%n", journey.getType(), fare);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
