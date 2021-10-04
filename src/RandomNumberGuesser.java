import java.util.*;

public class RandomNumberGuesser {
    public static void main(String[] args) {
        Integer randNum, highGuess, lowGuess;
        RNG r = new RNG();

        randNum = r.rand();
        highGuess = 100;
        lowGuess = 0;
        System.out.println("*****************************************");
        System.out.println("*         Random Number Guesser         *");
        System.out.println("*****************************************");

        begin_play(r, randNum, highGuess, lowGuess);

    }

    public static void begin_play(RNG r, Integer randNum, Integer highGuess, Integer lowGuess)
    {
        if(r.getCount()<=1)
            System.out.println("Enter you first guess " + randNum);
        Integer nextGuess = guess_value();
        System.out.println("Number of guesses is " + r.getCount());
        if (nextGuess == randNum) {
            option_value(r);
        }
        if(r.inputValidation(nextGuess, lowGuess, highGuess))
        {
            if (nextGuess < randNum ) {
                System.out.println("Your guess is too low");
                lowGuess = nextGuess;
            }
            if (nextGuess > randNum ) {
                System.out.println("Your guess is too high");
                highGuess = nextGuess;
            }
            System.out.println("Enter your next guess between " + lowGuess + " and "+ highGuess);
        }
        begin_play(r, randNum, highGuess, lowGuess);

    }

    public static Integer guess_value() {
        Scanner input = new Scanner(System.in);
        String answer = null;

        while (true) {
            answer = input.nextLine();
            if (answer.chars().allMatch(Character::isDigit) == false)
                System.out.println("Please provide a valid input (INTEGER)");
            else
                break;
        }

        return Integer.parseInt(answer);

    }

    public static void option_value(RNG r) {
        Scanner input = new Scanner(System.in);
        String answer = "";

        while (!answer.equals("no") || !answer.equals("yes")) {
            System.out.println("Congratulations, you guessed correctly");
            System.out.println("Try again? (yes or no)");
            answer = input.nextLine();


            if (answer.equals("no")) {
                System.out.println("Thanks for playing...");
                System.out.println("*****************************************");
                System.out.println("* Author: Ricardo Abuabara Angarita     *");
                System.out.println("*****************************************");
                System.exit(0);
            }
            if (answer.equals("yes"))
                break;
        }
        r.resetCount();
        begin_play(new RNG(), r.rand(), 100, 0);

    }
}