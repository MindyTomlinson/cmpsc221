import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    private GameModel gameModel;
    private final JLabel messageLabel;
    private final JTextField input;
    private final JButton guessButton;
    private final JButton playAgainButton;
    private final Color DEFAULT_COLOR;


    public GameFrame() {

        super("Guess the Number Game");
        setLayout(new FlowLayout());
        DEFAULT_COLOR = getContentPane().getBackground();

        gameModel = new GameModel(); // start a new game

        messageLabel = new JLabel(gameModel.getMessage());
        add(messageLabel);

        input = new JTextField(20);
        add(input);

        guessButton = new JButton("Guess");
        add(guessButton);

        playAgainButton = new JButton("Play Again");
        playAgainButton.setVisible(false); // Hide until game is over
        add(playAgainButton);

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

                        gameModel = new GameModel(); // Brand new game model

                        getContentPane().setBackground(DEFAULT_COLOR);  // Reset background color

                        messageLabel.setText(
                                gameModel.getMessage()); // Reset message

                        playAgainButton.setVisible(false); // Hide "Play Again" button

                        guessButton.setVisible(true); // Show "Guess" button

                        input.setEditable(true); // Make input editable again

                    }
                }
        );
    }

    private void processGuess(String guess) {

        gameModel.assessGuess(guess); // Validate and evaluate guess

        messageLabel.setText(
                gameModel.getMessage()); // Update message

        getContentPane().setBackground(
                gameModel.getColor());   // Update background color

        if (gameModel.isGameOver()) {
            guessButton.setVisible(false); // Hide "Guess" button
            playAgainButton.setVisible(true); // Show "Play Again" button
            input.setEditable(false); // Make input uneditable
        }
        else {
            input.selectAll(); // Select input text so user can start typing right away
        }
    }
}
