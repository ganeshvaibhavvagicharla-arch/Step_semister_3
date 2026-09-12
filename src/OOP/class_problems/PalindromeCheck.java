package OOP.class_problems;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int origNumber = number;
        int reversedNumber = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            reversedNumber = reversedNumber * 10 + digit;
            temp = temp / 10;
        }

        if (reversedNumber == origNumber) {
            System.out.println(origNumber + " is a Palindrome.");
        } else {
            System.out.println(origNumber + " is not a Palindrome.");
        }
        sc.close();
    }
}
