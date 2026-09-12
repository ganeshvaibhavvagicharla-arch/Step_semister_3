package OOP.assignment_problems;

public class MultiplicationTableGenerator {
    public static void generateFirstValidTable(int[] candidates) {
        for (int num : candidates) {
            if (num < 1) {
                System.out.println("Skipping invalid number: " + num);
                continue;
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }
            break;
        }
    }

    public static void main(String[] args) {
        generateFirstValidTable(new int[]{-3, 0, 7, 9});
    }
}
