package OOPIntroduction.assignment_problems;

import java.util.Scanner;

abstract class Student {
    static final double BUS_FEE = 12000;
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double hostelFee() {
        return 0;
    }

    boolean usesBus() {
        return false;
    }

    double totalFee() {
        double total = tuition() + hostelFee();

        if (usesBus())
            total += BUS_FEE;

        return total;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }

    double hostelFee() {
        return 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double fee = s.totalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}