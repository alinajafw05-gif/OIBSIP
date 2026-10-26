import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int roundsWon = 0;
        int totalRounds = 0;
        
        System.out.println("========================================");
        System.out.println("   WELCOME TO THE NUMBER GUESSING GAME  ");
        System.out.println("========================================");
        
        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("\n--- Round " + totalRounds + " ---");
            System.out.println("I have picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                
                // Input validation to prevent crashes if user enters text instead of numbers
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    scanner.next(); 
                    continue;
                }
                
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == targetNumber) {
                    System.out.println("Correct! You've guessed the number in " + attempts + " tries.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + targetNumber);
            }
            
            // Score tracking across rounds
            System.out.println("\nScoreboard -> Rounds Played: " + totalRounds + " | Rounds Won: " + roundsWon);
            
            // Play Again option
            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = scanner.next();
            playAgain = choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y");
        }
        
        System.out.println("\nThank you for playing! Final Score: " + roundsWon + "/" + totalRounds + " rounds won.");
        scanner.close();
    }
}