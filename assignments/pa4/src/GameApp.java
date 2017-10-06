import javax.swing.JFrame;

public class GameApp {
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(650,100);
        gameFrame.setLocationRelativeTo(null); // Center frame in middle of screen
        gameFrame.setVisible(true);
    }
}
