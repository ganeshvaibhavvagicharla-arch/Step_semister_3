package Abstraction_interface_classvsinterface.class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryDueDateCalculator {

    abstract static class LibraryItem {
        protected String title;

        public LibraryItem(String title) {
            this.title = title;
        }

        public String getTitle() { return title; }
        public abstract LocalDate calculateDueDate(LocalDate currentDate);
    }

    static class Book extends LibraryItem {
        public Book(String title) { super(title); }

        @Override
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(14); }
    }

    static class DVD extends LibraryItem {
        public DVD(String title) { super(title); }

        @Override
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(7); }
    }

    static class Magazine extends LibraryItem {
        public Magazine(String title) { super(title); }

        @Override
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(3); }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Test Data
        items.add(new Book("Java Programming"));
        items.add(new DVD("Inception"));
        items.add(new Magazine("Tech Today"));

        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate(currentDate);
            System.out.printf("%s: %s%n", item.getTitle(), dueDate.format(formatter));
        }
    }
}
