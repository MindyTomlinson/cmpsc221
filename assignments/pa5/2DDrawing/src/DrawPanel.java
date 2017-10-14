import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private ArrayList<Shape> shapes;
    private Shape currentShape;
    private Color currentColor1 = Color.BLACK;
    private Color currentColor2 = Color.BLACK;
    private boolean currentFilled;
    private int currentType;
    private final int LINE = 0;
    private final int OVAL = 1;
    private final int RECTANGLE = 2;
    private JLabel statusLabel;

    // Constructor that takes a JLabel
    public DrawPanel(JLabel statusLabel) {
        shapes = new ArrayList<>();
        currentType = LINE;
        this.statusLabel = statusLabel;
        statusLabel.setText(String.format("(%d, %d)", 0, 0));
        setBackground(Color.WHITE);
        // register mouse event handlers
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentShape != null) {
            shapes.add(currentShape);
        }
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    // Undo the last shape drawn
    public void undo() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1); // remove last shape
            repaint(); // repaint all remaining shapes
        }
    }

    // Clear all shapes
    public void clearDrawing() {
        shapes.clear(); //
        repaint();
    }

    // Setters for currentFirstColor, currentSecondColor, currentType, and currentFilled
    public void setCurrentColor1(Color currentColor1) {
        this.currentColor1 = currentColor1;
    }

    public void setCurrentColor2(Color currentColor2) {
        this.currentColor2 = currentColor2;
    }

    public void setCurrentType(int currentType) {
        this.currentType = currentType;
    }

    public void setCurrentFilled(boolean currentFilled) {
        this.currentFilled = currentFilled;
    }
}
