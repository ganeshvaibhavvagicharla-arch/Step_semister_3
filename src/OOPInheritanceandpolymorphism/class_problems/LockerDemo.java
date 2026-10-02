package OOPInheritanceandpolymorphism.class_problems;

public class LockerDemo {
    public static class Locker {
        private final int lockerNumber;
        private String code;

        public Locker(int lockerNumber, String initialCode) {
            this.lockerNumber = lockerNumber;
            this.code = initialCode;
        }

        public boolean changeCode(String currentCode, String newCode) {
            if (this.code.equals(currentCode)) {
                this.code = newCode;
                return true;
            }
            return false;
        }

        public int getLockerNumber() {
            return lockerNumber;
        }
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");

        boolean res1 = locker.changeCode("1234", "5678");
        System.out.println("Change code with '1234' -> " + (res1 ? "success" : "rejected")); // success

        boolean res2 = locker.changeCode("0000", "9999");
        System.out.println("Change code with '0000' -> " + (res2 ? "success" : "rejected")); // rejected
    }
}
