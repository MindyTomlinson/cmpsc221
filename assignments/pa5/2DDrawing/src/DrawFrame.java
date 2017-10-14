import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame {

    private JLabel mousePositionLabel = new JLabel("Position: ");
    private DrawPanel drawPanel = new DrawPanel(mousePositionLabel);

    public DrawFrame() {

        super("Drawing Frame");
        setLayout(new BorderLayout());

        add(drawPanel, BorderLayout.CENTER);
        add(mousePositionLabel, BorderLayout.SOUTH);
    }

}
