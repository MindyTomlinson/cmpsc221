import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape {

    public Oval(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    public Oval() {
        super();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX1(), getY1(), getWidth(), getHeight());
    }
}
