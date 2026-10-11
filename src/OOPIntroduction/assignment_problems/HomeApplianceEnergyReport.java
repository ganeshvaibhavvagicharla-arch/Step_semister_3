package OOPIntroduction.assignment_problems;

import java.util.Scanner;

abstract class Appliance {
    abstract double power();

    double units(double hours) {
        return power() * hours / 1000;
    }

    double cost(double hours) {
        return units(hours) * 8;
    }
}

interface Saver {
    double savedUnits(double hours);
}

class Fridge extends Appliance {
    double power() {
        return 150;
    }
}

class AC extends Appliance implements Saver {
    double power() {
        return 1500;
    }

    public double savedUnits(double hours) {
        return units(hours) * 0.75;
    }
}

class TV extends Appliance {
    double power() {
        return 100;
    }
}

class Washer extends Appliance implements Saver {
    double power() {
        return 500;
    }

    public double savedUnits(double hours) {
        return units(hours) * 0.75;
    }
}

public class  HomeApplianceEnergyReport{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saverMode = sc.hasNext("SAVER");

            if (saverMode)
                sc.next();

            Appliance a;

            if (type.equals("FRIDGE"))
                a = new Fridge();
            else if (type.equals("AC"))
                a = new AC();
            else if (type.equals("TV"))
                a = new TV();
            else
                a = new Washer();

            if (saverMode && !(a instanceof Saver)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units;

            if (saverMode)
                units = ((Saver) a).savedUnits(hours);
            else
                units = a.units(hours);

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
