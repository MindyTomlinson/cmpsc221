import javax.swing.*;

public class DrawSmileyTest {

    public static void main(String[] args) {

        DrawSmiley drawSmileyPanel = new DrawSmiley();
        JFrame jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(drawSmileyPanel);
        jFrame.setSize(300, 300);
        jFrame.setVisible(true);
    }
}
