import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class GameModel {

    private int currentGuess;
    private int previousGuess;
    private int guessCount = 0;
    private int secretNumber;
    private String message;
    private Color color;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 1000;

    public GameModel() {
        setSecretNumber();
        message = String.format(
                "I have a number between %d and %d. Can you guess my number?\n" +
                        "Please enter your first guess.", MIN_NUMBER, MAX_NUMBER);
        color = Color.LIGHT_GRAY;
    }

    public int getCurrentGuess() {
        return currentGuess;
    }

    public int getPreviousGuess() {
        return previousGuess;
    }

    public void setGuesses(int guess) {
        previousGuess = currentGuess;
        currentGuess = guess;
        guessCount += 1;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber() {
        secretNumber = ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isGameOver() {
        return currentGuess == secretNumber;
    }

    // Utility methods

    // Validate guess in range
    private boolean guessInRange(int guess) {
        return MIN_NUMBER <= guess && guess <= MAX_NUMBER;
    }

    // Calculate how close guess is to the secret number
    private int distToSecret(int guess) {
        return Math.abs(guess - secretNumber);
    }

    // Construct hint to use in message
    public String makeHint() {
        String directionHint = currentGuess > secretNumber ? "Too high" : "Too low";
        String temperatureHint = "";
        if (guessCount > 1) { // If this isn't the 1st guess / there's a previous guess to compare to
            temperatureHint =
                    ( Math.abs(currentGuess - secretNumber) < Math.abs(previousGuess - secretNumber) ) ?
                            ", but you're getting warmer!" : // currentGuess closer than previousGuess
                            " and you're getting colder.";
        }
        return directionHint + temperatureHint;
    }

    @Override
    public String toString() {
        return "GameModel:\n" +
                "currentGuess = " + currentGuess + "\n" +
                "previousGuess = " + previousGuess + "\n" +
                "guessCount = " + guessCount + "\n" +
                "secretNumber = " + secretNumber + "\n" +
                "message = \'" + message + "\'\n" +
                "color = " + color + "\n" +
                "isGameOver = " + isGameOver() + "\n";
    }
}
