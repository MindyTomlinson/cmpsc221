import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import java.util.zip.CheckedOutputStream;

public class GameModel {

    private int currentGuess;
    private int previousGuess;
    private int guessCount;
    private int secretNumber;
    private String message;
    private Color color;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 1000;

    public GameModel() {
        setSecretNumber();
        guessCount = 0;
        message = String.format(
                "I have a number between %d and %d. Can you guess my number?\n" +
                        "Please enter your first guess.", MIN_NUMBER, MAX_NUMBER);
        color = Color.LIGHT_GRAY;
    }

    public void assessGuess(String stringGuess) {
        try {
            // Parse string input into an integer
            int guess = Integer.parseInt(stringGuess);

            // Confirm guess is in range
            if (guess < MIN_NUMBER || MAX_NUMBER < guess) {
                throw new IllegalArgumentException();
            }

            // Move current guess to previous guess, etc.
            setGuess(guess);

            // Check if the game is over
            if (isGameOver()) {
                setMessage("Correct! Want to play again?");
                setColor(Color.GREEN);
            }

            // If game isn't over yet...
            else {
                setColor(assessTemperature()); // Change color to reflect warmer/colder
                setMessage(makeHint()); // Create a hint to display to the user
            }
        }

        catch (NumberFormatException e) {
            setMessage("Whoops, you didn't enter a number! Guess again.");
        }

        catch (IllegalArgumentException e) {
            setMessage(String.format(
                    "Whoops, you entered a number out of range. Guess a number between %d and %d.",
                    MIN_NUMBER, MAX_NUMBER));
        }
    }

    private void setGuess(int guess) {
        previousGuess = currentGuess;
        currentGuess = guess;
        guessCount += 1;
    }

    private void setSecretNumber() {
        secretNumber = ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        this.color = color;
    }

    public boolean isGameOver() {
        return currentGuess == secretNumber;
    }

    private Color assessTemperature() {
        if ( Math.abs(currentGuess - secretNumber) < Math.abs(previousGuess - secretNumber) ) {
            return Color.RED;
        }
        else {
            return Color.CYAN;
        }
    }

    // Construct hint to use in message
    private String makeHint() {
        String directionHint = currentGuess > secretNumber ? "Too high" : "Too low";
        String temperatureHint = "";
        String prevGuessHint = "";
        if (guessCount > 1) { // If this isn't the 1st guess / there's a previous guess to compare to
            if (assessTemperature() == Color.RED) {
                temperatureHint = ", but you're getting warmer!";
            }
            if (assessTemperature() == Color.CYAN) {
                temperatureHint = " and you're getting colder.";
            }
            prevGuessHint = String.format(" Your last two guesses: %d, %d.",
                    previousGuess, currentGuess);
        }
        return directionHint + temperatureHint + prevGuessHint;
    }

    @Override
    public String toString() {
        return "GameModel:\n" +
                "currentGuess = " + currentGuess + "\n" +
                "previousGuess = " + previousGuess + "\n" +
                "guessCount = " + guessCount + "\n" +
                "secretNumber = " + secretNumber + "\n" +
                "message = \'" + message + "\'\n" +
                "color = " + color + "\n";
    }
}
