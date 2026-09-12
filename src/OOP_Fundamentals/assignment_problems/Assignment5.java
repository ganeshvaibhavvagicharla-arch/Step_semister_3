package OOP_Fundamentals.assignment_problems;

import java.util.Arrays;

public class Assignment5 {

    // Defined inside the class so both classes can remain public in a single file
    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        // Overloaded Rule 1: Established players (matches >= 10) qualify regardless of injury
        public static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Overloaded Rule 2: Newer players (matches >= 5 and NOT injured)
        public static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            // Sort in descending order by batting average (fantasy points)
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    public static String draftAndRank(Player[] players) {
        // Step 1: Count eligible players
        int count = 0;
        for (Player p : players) {
            if (Player.isDraftable(p.getMatchesPlayed()) || Player.isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                count++;
            }
        }

        // Step 2: Extract eligible players
        Player[] draftable = new Player[count];
        int index = 0;
        for (Player p : players) {
            if (Player.isDraftable(p.getMatchesPlayed()) || Player.isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[index++] = p;
            }
        }

        // Step 3: Rank using Arrays.sort() and compareTo implementation
        Arrays.sort(draftable);

        // Step 4: Build formatted output string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].getName());
            if (i < draftable.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        // Output: "1. Rahul 2. Virat 3. Dev"
        System.out.println(draftAndRank(players));
    }
}
