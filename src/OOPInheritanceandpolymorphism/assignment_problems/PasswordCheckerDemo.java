package OOPInheritanceandpolymorphism.assignment_problems;

public class PasswordCheckerDemo {
    public static class PasswordChecker {
        private final String password;

        public PasswordChecker(String password) {
            this.password = password;
        }

        public String getStrength() {
            if (password == null || password.length() < 6) {
                return "Weak";
            } else if (password.length() <= 9) {
                return "Medium";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Strength of 'abcd': " + pc1.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Strength of 'abcdefgh': " + pc2.getStrength()); // Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Strength of 'abcdefghij': " + pc3.getStrength()); // Strong
    }
}
