package OOPIntroduction.class_problems;

import java.util.Scanner;

abstract class Travel {
    static final double BOOKING_FEE = 50;

    abstract double fare(double distance);

    double total(double distance) {
        return fare(distance) + BOOKING_FEE;
    }
}

class Bus extends Travel {
    double fare(double distance) {
        return distance * 2;
    }
}

class Train extends Travel {
    double fare(double distance) {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    double fare(double distance) {
        return 2500 + distance * 4;
    }
}

public class TravelBookingwithaCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Travel t;

            if (mode.equals("BUS"))
                t = new Bus();
            else if (mode.equals("TRAIN"))
                t = new Train();
            else
                t = new Flight();

            System.out.printf(
                    "%s: %.2f%n", mode, t.total(distance)
            );
        }

        sc.close();
    }
}