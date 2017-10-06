import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class GameModel {

    private int currentGuess;
    private int previousGuess;
    private int guessCount;
    private int secretNumber;
    private String message;
    private Color color;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 1000;
    private final Color WARMER_COLOR = new Color(246,103, 84);
    private final Color COLDER_COLOR = new Color(38,167,255);
    private final Color CORRECT_COLOR = new Color(55,220,148);

    public GameModel() {
        setSecretNumber();
        guessCount = 0;
        message = String.format(
                "I have a number between %d and %d. Can you guess my number?\n" +
                        "Please enter your first guess.", MIN_NUMBER, MAX_NUMBER);
    }

    public void assessGuess(String stringGuess) {
        try {
            int guess = Integer.parseInt(stringGuess);
            if (guess < MIN_NUMBER || MAX_NUMBER < guess) {
                throw new IllegalArgumentException();
            }
            setGuess(guess);
            if (isGameOver()) {
                setMessage("Correct! Want to play again?");
                setColor(CORRECT_COLOR);
            }
            else {
                if (guessCount > 1) {
                    setColor(assessTemperature());
                }
                setMessage(makeHint());
            }
        }

        catch (NumberFormatException e) {
            setMessage(String.format(
                    "Whoops, you didn't enter a number. Guess a number between %d and %d.",
                    MIN_NUMBER, MAX_NUMBER));
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
        if ( Math.abs(currentGuess - secretNumber) <= Math.abs(previousGuess - secretNumber) ) {
            return WARMER_COLOR;
        }
        else {
            return COLDER_COLOR;
        }
    }

    // Construct hint to use in message
    private String makeHint() {
        String directionHint = currentGuess > secretNumber ? "Too high" : "Too low";
        String temperatureHint = "";
        String prevGuessHint = "";
        if (guessCount > 1) { // If there's a previous guess to compare to
            if (assessTemperature() == WARMER_COLOR) {
                temperatureHint = ", but you're getting warmer!";
            }
            if (assessTemperature() == COLDER_COLOR) {
                temperatureHint = " and you're getting colder.";
            }
            prevGuessHint = String.format(" Your last two guesses: %d, %d.",
                    previousGuess, currentGuess);
        }
        return directionHint + temperatureHint + prevGuessHint;
    }

    @Override
    public String toString() {  // For testing
        return "GameModel:\n" +
                "currentGuess = " + currentGuess + "\n" +
                "previousGuess = " + previousGuess + "\n" +
                "guessCount = " + guessCount + "\n" +
                "secretNumber = " + secretNumber + "\n" +
                "message = \'" + message + "\'\n" +
                "color = " + color + "\n";
    }
}
