import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

    public Rectangle(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    public Rectangle() {
        super();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX1(), getY1(), getWidth(), getHeight());
    }
}
