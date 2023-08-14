import java.util.Random;
import java.util.Scanner;
public class Guess_Number_Game_Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        boolean playAgain = true;

        System.out.println("**************************************");
        System.out.println("*   Welcome to the Guess the Number  *");
        System.out.println("*              Game!                 *");
        System.out.println("**************************************");

        while (playAgain) {
            System.out.println("\nChoose a difficulty level:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-200)");
            System.out.print("Enter the level number: ");
            int level = scanner.nextInt();

            switch (level) {
                case 1:
                    upperBound = 50;
                    maxAttempts = 8;
                    break;
                case 2:
                    upperBound = 100;
                    maxAttempts = 10;
                    break;
                case 3:
                    upperBound = 200;
                    maxAttempts = 12;
                    break;
                default:
                    System.out.println("Invalid level choice. Defaulting to Medium level.");
                    upperBound = 100;
                    maxAttempts = 10;
                    break;
            }

            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("\nI've chosen a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Higher! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Lower! Try again.");
                } else {
                    System.out.println("\n**************************************");
                    System.out.println("*         Congratulations!           *");
                    System.out.println("* You've guessed the number " + secretNumber + " in " + attempts + " attempts. *");
                    System.out.println("**************************************");
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("\nSorry, you've run out of attempts. The secret number was " + secretNumber + ".");
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("\n**************************************");
        System.out.println("*     Thank you for playing!         *");
        System.out.println("*              Goodbye.               *");
        System.out.println("**************************************");
        scanner.close();
    }

}
