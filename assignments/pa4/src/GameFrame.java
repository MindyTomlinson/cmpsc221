import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class GameFrame extends JFrame {

    private final JLabel messageLabel;
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    private final JTextField input;
    private final JButton guessButton;
    private final JButton playAgainButton;
    private int currentGuess;
    private int previousGuess;
    private int guessCount;
    private int secretNumber;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 1000;
    private final Color WARMER_COLOR = new Color(246,103, 84);
    private final Color COLDER_COLOR = new Color(38,167,255);
    private final Color CORRECT_COLOR = new Color(55,220,148);
    private final Color DEFAULT_COLOR;
    private final String INITIAL_MESSAGE = String.format(
            "I have a number between %d and %d. Can you guess my number?\n" +
                    "Please enter your first guess.", MIN_NUMBER, MAX_NUMBER);

    public GameFrame() {

        super("Guess the Number Game");
        setLayout(new BorderLayout());
        DEFAULT_COLOR = getContentPane().getBackground(); // So we can reset it when new game starts

        // Get secret number
        setSecretNumber();

        // Initialize panels
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        add(topPanel, BorderLayout.NORTH);
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        add(bottomPanel, BorderLayout.CENTER);

        // Initialize message
        messageLabel = new JLabel(INITIAL_MESSAGE);
        topPanel.add(messageLabel);

        // Initialize input
        input = new JTextField(10);
        bottomPanel.add(input);

        // Initialize guess button
        guessButton = new JButton("Guess");
        bottomPanel.add(guessButton);

        // Initialize play again button
        playAgainButton = new JButton("Play Again");
        playAgainButton.setVisible(false); // Hide until game is over
        bottomPanel.add(playAgainButton);

        input.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        processGuess(e.getActionCommand());
                    }
                }
        );
        guessButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        processGuess(input.getText());
                    }
                }
        );
        playAgainButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        processNewGame();
                    }
                }
        );
    }

    private void processGuess(String stringGuess) {
        try {
            int intGuess = Integer.parseInt(stringGuess);
            if (intGuess < MIN_NUMBER || MAX_NUMBER < intGuess) {
                throw new IllegalArgumentException();
            }
            previousGuess = currentGuess;
            currentGuess = intGuess;
            guessCount += 1;
            if (currentGuess == secretNumber) {
                processCorrectGuess();
            }
            else {
                processIncorrectGuess();
            }
        }
        catch (NumberFormatException e) {
            messageLabel.setText(String.format(
                    "Whoops, you didn't enter a number. Guess a number between %d and %d.",
                    MIN_NUMBER, MAX_NUMBER));
            input.selectAll();
        }
        catch (IllegalArgumentException e) {
            messageLabel.setText(String.format(
                    "Whoops, you entered a number out of range. Guess a number between %d and %d.",
                    MIN_NUMBER, MAX_NUMBER));
            input.selectAll();
        }
    }

    private void processIncorrectGuess() {
        String directionHint = currentGuess > secretNumber ? "Too high" : "Too low";
        String temperatureHint = "";
        String prevGuessHint = "";
        if (guessCount > 1) { // If there's a previous guess to compare to
            if ( Math.abs(currentGuess - secretNumber) <= Math.abs(previousGuess - secretNumber) ) {
                setBackgroundColor(WARMER_COLOR);
                temperatureHint = ", but you're getting warmer!";
            }
            else {
                setBackgroundColor(COLDER_COLOR);
                temperatureHint = " and you're getting colder.";
            }
            prevGuessHint = String.format(" Your last two guesses: %d, %d.",
                    previousGuess, currentGuess);
        }
        messageLabel.setText(directionHint + temperatureHint + prevGuessHint);
        input.selectAll(); // Select input text so user can start typing right away
    }

    private void processCorrectGuess() {
        messageLabel.setText("Correct! Want to play again?");
        setBackgroundColor(CORRECT_COLOR);
        input.setEditable(false); // Make input uneditable
        guessButton.setVisible(false); // Hide Guess button
        playAgainButton.setVisible(true); // Show Play Again button
        playAgainButton.requestFocus(); // Put focus on Play Again button
    }

    private void processNewGame() {
        previousGuess = 0;
        currentGuess = 0;
        guessCount = 0;
        setSecretNumber();
        messageLabel.setText(INITIAL_MESSAGE);
        setBackgroundColor(DEFAULT_COLOR);
        input.setText(""); // Clear input
        input.setEditable(true); // Make input editable again
        playAgainButton.setVisible(false); // Hide Play Again button
        guessButton.setVisible(true); // Show Guess button
    }

    private void setSecretNumber() {
        secretNumber = ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    private void setBackgroundColor(Color color) {
        topPanel.setBackground(color);
        bottomPanel.setBackground(color);
    }
}