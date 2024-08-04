import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    static class Ques {
        String ques;
        String[] options;
        int C_Ans; // Index of the correct answer

        Ques(String ques, String[] options, int C_Ans) {
            this.ques = ques;
            this.options = options;
            this.C_Ans = C_Ans;
        }
    }

    static Ques[] quess = {
        new Ques("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 0),
        new Ques("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1),
        new Ques("What is the largest ocean?", new String[]{"Atlantic", "Indian", "Pacific", "Arctic"}, 2)
    };
    static int score = 0;
    static boolean answerSubmitted = false;
    static int selectedAnswer = -1;
    static final int TIME_LIMIT = 10; // 10 seconds per ques

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (Ques q : quess) {
            displayQues(q);

            // Timer for the ques
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answerSubmitted) {
                        System.out.println("\nTime's up!");
                        selectedAnswer = -1; // No answer selected
                    }
                    answerSubmitted = true;
                }
            }, TIME_LIMIT * 1000);

            // Wait for user's answer
            while (!answerSubmitted) {
                try {
                    String input = scanner.nextLine();
                    selectedAnswer = Integer.parseInt(input) - 1; // Convert to zero-based index
                    if (selectedAnswer >= 0 && selectedAnswer < q.options.length) {
                        answerSubmitted = true;
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }

            // Stop the timer
            timer.cancel();

            // Check the answer
            if (selectedAnswer == q.C_Ans) {
                score++;
            }

            answerSubmitted = false; // Reset for the next ques
        }

        // Display result
        displayResult();
        scanner.close();
    }

    private static void displayQues(Ques q) {
        System.out.println(q.ques);
        for (int i = 0; i < q.options.length; i++) {
            System.out.println((i + 1) + ". " + q.options[i]);
        }
        System.out.println("Please enter your answer (1-" + q.options.length + "):");
    }

    private static void displayResult() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your score: " + score + " out of " + quess.length);
        for (Ques q : quess) {
            System.out.println(q.ques);
            System.out.println("Correct answer: " + q.options[q.C_Ans]);
        }
    }
}
