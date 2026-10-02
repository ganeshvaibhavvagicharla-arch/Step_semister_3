package Abstraction_interface_classvsinterface.class_problems;

import java.util.ArrayList;
import java.util.List;

public class QuestionGrader {

    abstract static class Question {
        protected String text;
        protected String correctAnswer;
        protected String studentAnswer;
        protected double points;

        public Question(String text, String correctAnswer, String studentAnswer, double points) {
            this.text = text;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public abstract String getType();
        public abstract double evaluateScore();
    }

    static class MCQQuestion extends Question {
        public MCQQuestion(String text, String correctAnswer, String studentAnswer, double points) {
            super(text, correctAnswer, studentAnswer, points);
        }

        @Override
        public String getType() { return "MCQ"; }

        @Override
        public double evaluateScore() {
            return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
        }
    }

    static class TFQuestion extends Question {
        public TFQuestion(String text, String correctAnswer, String studentAnswer, double points) {
            super(text, correctAnswer, studentAnswer, points);
        }

        @Override
        public String getType() { return "TF"; }

        @Override
        public double evaluateScore() {
            return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
        }
    }

    static class EssayQuestion extends Question {
        public EssayQuestion(String text, String correctAnswer, String studentAnswer, double points) {
            super(text, correctAnswer, studentAnswer, points);
        }

        @Override
        public String getType() { return "ESSAY"; }

        @Override
        public double evaluateScore() {
            String[] keywords = correctAnswer.split(",");
            int matchCount = 0;
            String lowerStudentAns = studentAnswer.toLowerCase();

            for (String kw : keywords) {
                if (lowerStudentAns.contains(kw.trim().toLowerCase())) {
                    matchCount++;
                }
            }

            if (matchCount >= 2) return points * 0.75;
            if (matchCount == 1) return points * 0.50;
            return 0.0;
        }
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();

        // Test Data
        questions.add(new MCQQuestion("What is 2+2?", "B", "B", 5.0));
        questions.add(new TFQuestion("Java is OOP?", "True", "True", 2.0));
        questions.add(new EssayQuestion("Define OOP", "class, object, inheritance", "An object oriented system uses class and object", 10.0));

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}
