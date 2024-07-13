import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    private static final int MAX_ATTEMPTS = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {
        boolean playAgain;
        int t_Round = 0;
        int totalScore = 0;
        do {
            t_Round++;
            totalScore += playRound();
            playAgain = askToPlayAgain();
        } while (playAgain);
        System.out.println("Game Over. You played " + t_Round + " rounds with a total score of " + totalScore + ".");
    }

    private static void provideFeedback(int guess, int genNum) {
        if (guess < genNum) {
            System.out.println("Too low. Try again.");
        } else if (guess > genNum) {
            System.out.println("Too high. Try again.");
        } else {
            System.out.println("Congratulations! You guessed the number correctly.");
        }
    }

    private static boolean askToPlayAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        scanner.nextLine(); // Consume the newline
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }

    private static int playRound() {
        int genNum = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;
        
        System.out.println("Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");
        
        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            provideFeedback(userGuess, genNum);
            if (userGuess == genNum) {
                guessedCorrectly = true;
            }
        }
        
        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + genNum);
        }
        
        return MAX_ATTEMPTS - attempts;
    }
}
