package ClassesandObjects.class_problems;

public class StudentCollege {
    private String name;
    private double attendance;
    private static String collegeName = "SRM Institute of Science and Technology";
    private static int studentCount = 0;

    public StudentCollege(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new StudentCollege("Aditya", 85.5);
        new StudentCollege("Sneha", 92.0);

        // Access static method via class name
        StudentCollege.printCollegeInfo();
    }
}
