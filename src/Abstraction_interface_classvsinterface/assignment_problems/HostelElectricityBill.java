package Abstraction_interface_classvsinterface.assignment_problems;

import java.util.ArrayList;
import java.util.List;

public class HostelElectricityBill {

    abstract static class Room {
        protected int units;

        public Room(int units) {
            this.units = units;
        }

        public abstract String getRoomType();
        public abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        public SingleRoom(int units) { super(units); }

        @Override
        public String getRoomType() { return "SINGLE"; }

        @Override
        public double calculateBill() { return units * 8.00; }
    }

    static class SharedRoom extends Room {
        private int occupants;

        public SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        @Override
        public String getRoomType() { return "SHARED"; }

        @Override
        public double calculateBill() { return (units * 6.00) / occupants; }
    }

    static class ACRoom extends Room {
        public ACRoom(int units) { super(units); }

        @Override
        public String getRoomType() { return "AC"; }

        @Override
        public double calculateBill() { return (units * 10.00) + 200.00; }
    }

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();

        // Test Data
        rooms.add(new SingleRoom(50));
        rooms.add(new SharedRoom(100, 2));
        rooms.add(new ACRoom(80));

        double grandTotal = 0.0;
        for (Room room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
