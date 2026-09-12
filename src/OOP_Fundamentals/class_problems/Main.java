package OOP_Fundamentals.class_problems;

import java.util.Arrays;

public class Main {

    // Helper class declared as static nested so everything works cleanly in one file
    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;
        private double compositeScore;

        // Constructor name MUST match class name "Candidate" with NO return type
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            // Composite score calculation: CGPA weightage + Coding score
            this.compositeScore = (cgpa * 10) + codingScore;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        public double getCompositeScore() {
            return compositeScore;
        }

        // Overloaded Rule 1: High CGPA alone qualifies (>= 7.5)
        public static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        // Overloaded Rule 2: Borderline CGPA (>= 6.5) + strong coding score (>= 60)
        public static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        @Override
        public int compareTo(Candidate other) {
            // Sort descending by composite score
            return Double.compare(other.compositeScore, this.compositeScore);
        }
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        // Step 1: Count eligible candidates
        int count = 0;
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.getCgpa()) || Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {
                count++;
            }
        }

        // Step 2: Populate shortlisted array
        Candidate[] shortlisted = new Candidate[count];
        int index = 0;
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.getCgpa()) || Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted[index++] = c;
            }
        }

        // Step 3: Sort using Candidate's compareTo implementation
        Arrays.sort(shortlisted);

        // Step 4: Build formatted output string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                    .append(shortlisted[i].getName())
                    .append(" (").append(shortlisted[i].getCompositeScore()).append(")");
            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        // Output: "1. Aisha (122.0) | 2. Rohit (133.0) | 3. Karan (95.0)"
        System.out.println(shortlistAndRank(candidates));
    }
}
