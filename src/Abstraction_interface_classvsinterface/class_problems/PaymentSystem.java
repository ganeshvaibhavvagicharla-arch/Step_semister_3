package Abstraction_interface_classvsinterface.class_problems;

import java.util.ArrayList;
import java.util.List;

public class PaymentSystem {

    abstract static class Payment {
        protected double amount;

        public Payment(double amount) {
            this.amount = amount;
        }

        public abstract String getType();
        public abstract double calculateAdjustedAmount();
    }

    static class CardPayment extends Payment {
        public CardPayment(double amount) { super(amount); }

        @Override
        public String getType() { return "CARD"; }

        @Override
        public double calculateAdjustedAmount() { return amount * 1.02; }
    }

    static class WalletPayment extends Payment {
        public WalletPayment(double amount) { super(amount); }

        @Override
        public String getType() { return "WALLET"; }

        @Override
        public double calculateAdjustedAmount() { return amount * 1.01; }
    }

    static class BankTransferPayment extends Payment {
        public BankTransferPayment(double amount) { super(amount); }

        @Override
        public String getType() { return "BANKTRANSFER"; }

        @Override
        public double calculateAdjustedAmount() { return amount; }
    }

    public static void main(String[] args) {
        List<Payment> transactions = new ArrayList<>();

        // Test Data
        transactions.add(new CardPayment(100.00));
        transactions.add(new WalletPayment(200.00));
        transactions.add(new BankTransferPayment(500.00));

        double total = 0.0;
        for (Payment p : transactions) {
            double adjusted = p.calculateAdjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
