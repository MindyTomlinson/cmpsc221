import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private ArrayList<Shape> shapes;
    private Shape nextShape;
    private int nextShapeType;
    private Paint nextPaint;
    private BasicStroke nextStroke;
    private boolean nextFilled;
    private MousePositionPanel mousePositionPanel; // reference to mouse pos panel for updating location

    public DrawPanel(MousePositionPanel mousePositionPanel) {
        setBackground(Color.WHITE);
        shapes = new ArrayList<>();
        nextShape =
                new Line(new Point(), new Point(), Color.BLACK, new BasicStroke()); // Default next shape
        this.mousePositionPanel = mousePositionPanel;

        addMouseMotionListener(new MouseMotionAdapter() { // Display mouse position in mousePositionPanel
            @Override
            public void mouseDragged(MouseEvent e) {
                mousePositionPanel.updatePosition(e.getPoint());
                nextShape.setEndPoint(e.getPoint());
                repaint();
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                mousePositionPanel.updatePosition(e.getPoint());
            }
        });

        addMouseListener(new MouseAdapter() { // Clear text when mouse leaves the frame
            @Override
            public void mousePressed(MouseEvent e) {
                mousePositionPanel.updatePosition(e.getPoint());
                nextShape = makeNextShape(e.getPoint());
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (nextShape != null) {
                    shapes.add(nextShape);
                    nextShape = null;
                }
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mousePositionPanel.clearText();
            }
        });
    }

    private Shape makeNextShape(Point point) {
        switch (nextShapeType) {
            case Shape.LINE:
                return new Line(point, point, getNextPaint(), getNextStroke());
            case Shape.RECTANGLE:
                return new Rectangle(point, point, getNextPaint(), getNextStroke(), isNextFilled());
            case Shape.OVAL:
                return new Oval(point, point, getNextPaint(), getNextStroke(), isNextFilled());
            default:
                return new Line(point, point, getNextPaint(), getNextStroke());
        }
    }

    public int getNextShapeType() {
        return nextShapeType;
    }

    public void setNextShapeType(int nextShapeType) {
        this.nextShapeType = nextShapeType;
    }

    public Paint getNextPaint() {
        if (nextPaint == null) {
            return Color.BLACK;
        } else {
            return nextPaint;
        }
    }

    public void setNextPaint(Paint nextPaint) {
        this.nextPaint = nextPaint;
    }

    public BasicStroke getNextStroke() {
        if (nextStroke == null) {
            return new BasicStroke();
        } else {
            return nextStroke;
        }
    }

    public void setNextStroke(BasicStroke nextStroke) {
        this.nextStroke = nextStroke;
    }

    public boolean isNextFilled() {
        return nextFilled;
    }

    public void setNextFilled(boolean nextFilled) {
        this.nextFilled = nextFilled;
    }

    public void undo() {
        if (!shapes.isEmpty()) { // if shapes array isn't empty
            shapes.remove(shapes.size() - 1); // remove last shape
            repaint(); // repaint all remaining shapes
        }
    }

    public void clearDrawing() {
        shapes.clear(); //
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
        if (nextShape != null) {
            nextShape.draw(g2d);
        }
    }
}
