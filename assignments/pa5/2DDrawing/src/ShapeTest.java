import javax.swing.*;
import java.awt.*;

public class ShapeTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Testing shapes");
        jFrame.setLayout(new BorderLayout());



        MousePositionPanel mpp = new MousePositionPanel();
        jFrame.add(mpp, BorderLayout.SOUTH);

        DrawPanel sp = new DrawPanel(mpp);
        jFrame.add(sp, BorderLayout.CENTER);

        DrawFrame cp = new DrawFrame();
        jFrame.add(cp, BorderLayout.NORTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null); // display frame in middle of screen
    }
}
