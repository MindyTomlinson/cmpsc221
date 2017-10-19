import javax.swing.*;
import java.awt.*;

public class MousePositionPanel extends JPanel {

    private JLabel mousePositionLabel;

    public MousePositionPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        mousePositionLabel = new JLabel();
        add(mousePositionLabel);
    }

    public void updatePosition(Point point) {
        mousePositionLabel.setText(String.format("(%.0f, %.0f)", point.getX(), point.getY()));
    }

    public void clearText() {
        mousePositionLabel.setText("");
    }
}
