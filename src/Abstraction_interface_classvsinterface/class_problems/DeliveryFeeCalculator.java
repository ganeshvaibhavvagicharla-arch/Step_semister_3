package Abstraction_interface_classvsinterface.class_problems;

import java.util.ArrayList;
import java.util.List;

public class DeliveryFeeCalculator {

    abstract static class DeliveryRequest {
        protected double weight;
        protected double distance;

        public DeliveryRequest(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public abstract String getType();
        public abstract double calculateFee();
    }

    static class StandardDelivery extends DeliveryRequest {
        public StandardDelivery(double weight, double distance) { super(weight, distance); }

        @Override
        public String getType() { return "STANDARD"; }

        @Override
        public double calculateFee() { return 5.00 + (weight * 0.50) + (distance * 0.10); }
    }

    static class ExpressDelivery extends DeliveryRequest {
        public ExpressDelivery(double weight, double distance) { super(weight, distance); }

        @Override
        public String getType() { return "EXPRESS"; }

        @Override
        public double calculateFee() { return 15.00 + (weight * 1.00) + (distance * 0.20); }
    }

    static class InternationalDelivery extends DeliveryRequest {
        private double customsFee;

        public InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        public String getType() { return "INTERNATIONAL"; }

        @Override
        public double calculateFee() { return 25.00 + (weight * 2.00) + (distance * 0.50) + customsFee; }
    }

    public static void main(String[] args) {
        List<DeliveryRequest> requests = new ArrayList<>();

        // Test Data
        requests.add(new StandardDelivery(10.0, 50.0));
        requests.add(new ExpressDelivery(5.0, 30.0));
        requests.add(new InternationalDelivery(2.0, 500.0, 20.0));

        double grandTotal = 0.0;
        for (DeliveryRequest req : requests) {
            double fee = req.calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f%n", req.getType(), fee);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
    }
}