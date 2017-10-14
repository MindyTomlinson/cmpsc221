import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int width;
    private int height;
    private Color color;

    // Shape will also need a Stroke object eventually (width, dashed, etc)
    public Shape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        setHeight();
        setWidth();
    }

    public Shape() { // default constructor
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.color = Color.BLACK;
        setHeight();
        setWidth();
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
        setHeight();
        setWidth();
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
        setHeight();
        setWidth();
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
        setHeight();
        setWidth();
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
        setHeight();
        setWidth();
    }

    public int getWidth() {
        return width;
    }

    public void setHeight() {
        this.height = (y2 - y1);
    }

    public int getHeight() {
        return height;
    }

    public void setWidth() {
        this.width = (x2 - x1);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);
}
