package OOPInheritanceandpolymorphism.class_problems;

public class PiggyBankDemo {
    public static class PiggyBank {
        private final String id;
        private double savings;

        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0.0;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                this.savings += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= this.savings) {
                this.savings -= amount;
            }
        }

        public double getSavings() {
            return this.savings;
        }

        public String getId() {
            return this.id;
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("After deposit(100) -> savings = " + (int) pb.getSavings()); // 100

        pb.withdraw(30);
        System.out.println("After withdraw(30) -> savings = " + (int) pb.getSavings()); // 70

        pb.withdraw(500); // Exceeds balance, rejected
        System.out.println("After withdraw(500) -> savings stays = " + (int) pb.getSavings()); // 70
    }
}