import java.awt.*;

public abstract class Shape {

    private Point startPoint;
    private Point endPoint;
    private Paint paint;
    private BasicStroke stroke;
    public final static int LINE = 0;
    public final static int RECTANGLE = 1;
    public final static int OVAL = 2;
    public final static String[] shapeNames = {"Line", "Rectangle", "Oval"};

    public abstract void draw(Graphics2D g2d);

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public BasicStroke getStroke() {
        return stroke;
    }

    public void setStroke(BasicStroke stroke) {
        this.stroke = stroke;
    }

    public double getTopX() {
        return Math.min(startPoint.getX(), endPoint.getX());
    }

    public double getTopY() {
        return Math.min(startPoint.getY(), endPoint.getY());
    }

    public double getBottomX() {
        return Math.max(startPoint.getX(), endPoint.getX());
    }

    public double getBottomY() {
        return Math.max(startPoint.getY(), endPoint.getY());
    }

    public double getWidth() {
        return Math.abs(startPoint.getX() - endPoint.getX());
    }

    public double getHeight() {
        return Math.abs(startPoint.getY() - endPoint.getY());
    }
}