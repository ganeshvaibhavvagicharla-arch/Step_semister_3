package string.class_problems;

import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        String[] options = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;
        int n = playerMoves.length;
        String[][] summaryTable = new String[n][4];

        for (int i = 0; i < n; i++) {
            String playerMove = playerMoves[i];
            String computerMove = options[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            summaryTable[i][0] = "Round " + (i + 1);
            summaryTable[i][1] = playerMove;
            summaryTable[i][2] = computerMove;
            summaryTable[i][3] = result;
        }

        System.out.printf("%-10s | %-12s | %-14s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("----------------------------------------------------------");
        for (String[] row : summaryTable) {
            System.out.printf("%-10s | %-12s | %-14s | %-15s%n", row[0], row[1], row[2], row[3]);
        }

        double winPercentage = ((double) wins / n) * 100;
        System.out.printf("%nFinal Summary (after %d rounds):%n", n);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %%=%.1f%%%n", wins, losses, draws, winPercentage);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}
