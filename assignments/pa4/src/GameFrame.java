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

public class GameFrame extends JFrame {

    private GameModel gameModel;
    private final JLabel messageLabel;
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    private final JTextField input;
    private final JButton guessButton;
    private final JButton playAgainButton;
    private final Color DEFAULT_COLOR;

    public GameFrame() {

        super("Guess the Number Game");
        setLayout(new BorderLayout());
        DEFAULT_COLOR = getContentPane().getBackground(); // So we can reset it on play again

        // start a new game
        gameModel = new GameModel();

        // Initialize panel for message
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        add(topPanel, BorderLayout.NORTH);

        // Initialize message
        messageLabel = new JLabel(gameModel.getMessage());
        topPanel.add(messageLabel);

        // Initialize panel for input and buttons
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        add(bottomPanel, BorderLayout.CENTER);

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

    private void processGuess(String guess) {
        gameModel.assessGuess(guess); // Validate and evaluate guess
        messageLabel.setText(gameModel.getMessage()); // Update message
        setBackgroundColor(gameModel.getColor()); // Update background color
        if (gameModel.isGameOver()) {
            processGameOver();
        }
        else {
            input.selectAll(); // Select input text so user can start typing right away
        }
    }

    private void processGameOver() {
        guessButton.setVisible(false); // Hide Guess button
        playAgainButton.setVisible(true); // Show Play Again button
        playAgainButton.requestFocus(); // Put focus on Play Again button
        input.setEditable(false); // Make input uneditable
    }

    private void processNewGame() {
        gameModel = new GameModel(); // Brand new game model
        setBackgroundColor(DEFAULT_COLOR);
        messageLabel.setText(gameModel.getMessage()); // Reset message
        playAgainButton.setVisible(false); // Hide "Play Again" button
        guessButton.setVisible(true); // Show "Guess" button
        input.setText(""); // Clear input
        input.setEditable(true); // Make input editable again
    }

    private void setBackgroundColor(Color color) {
        topPanel.setBackground(color);
        bottomPanel.setBackground(color);
    }
}
