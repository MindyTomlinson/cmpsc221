import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapePanel extends JPanel {

    private ArrayList<Shape> shapes;

    public ShapePanel() {
        setBackground(Color.WHITE);

        shapes = new ArrayList<>();

        shapes.add(new Rectangle(100,100,300,400,Color.BLUE));
        shapes.add(new Oval(200,200,250,250, Color.GREEN));
        shapes.add(new Line(350,350,350,375, Color.RED));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }
}
