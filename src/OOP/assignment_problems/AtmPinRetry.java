package OOP.assignment_problems;

public class AtmPinRetry {
    public static void atmPinRetry(String correctPin, String[] attempts) {
        int i = 0;
        boolean success = false;
        while (i < attempts.length && !success) {
            if (attempts[i].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            i++;
        }
        if (!success) {
            System.out.println("Card blocked too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        atmPinRetry("4821", new String[]{"1111", "4821"});
        atmPinRetry("4821", new String[]{"1111", "2222", "3333"});
    }
}
