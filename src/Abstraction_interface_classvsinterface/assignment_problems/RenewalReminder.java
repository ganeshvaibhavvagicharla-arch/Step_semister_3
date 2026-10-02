package Abstraction_interface_classvsinterface.assignment_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RenewalReminder {

    abstract static class Plan {
        protected String name;
        protected LocalDate startDate;

        public Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public String getName() { return name; }
        public abstract LocalDate getRenewalDate();
    }

    static class BasicPlan extends Plan {
        public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }

        @Override
        public LocalDate getRenewalDate() { return startDate.plusDays(30); }
    }

    static class StandardPlan extends Plan {
        public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }

        @Override
        public LocalDate getRenewalDate() { return startDate.plusDays(90); }
    }

    static class PremiumPlan extends Plan {
        public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }

        @Override
        public LocalDate getRenewalDate() { return startDate.plusDays(365); }
    }

    public static void main(String[] args) {
        List<Plan> subscribers = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Test Data
        subscribers.add(new BasicPlan("User1", LocalDate.parse("2023-01-01", formatter)));
        subscribers.add(new StandardPlan("User2", LocalDate.parse("2023-01-01", formatter)));
        subscribers.add(new PremiumPlan("User3", LocalDate.parse("2023-01-01", formatter)));

        for (Plan sub : subscribers) {
            System.out.printf("%s: %s%n", sub.getName(), sub.getRenewalDate().format(formatter));
        }
    }
}