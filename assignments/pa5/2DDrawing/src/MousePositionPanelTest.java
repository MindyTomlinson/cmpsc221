import javax.swing.*;
import java.awt.*;

public class MousePositionPanelTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Testing mouse position label");
        jFrame.setLayout(new BorderLayout());
        MousePositionPanel mousePositionPanel = new MousePositionPanel();
        jFrame.add(mousePositionPanel, BorderLayout.SOUTH);
        mousePositionPanel.updatePosition(new Point(89,100));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(200, 200);
        jFrame.setVisible(true);
    }
}
