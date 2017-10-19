import java.awt.*;

public abstract class BoundedShape extends Shape {

    private boolean filled;

    public BoundedShape(Point startPoint, Point endPoint,
                        Paint paint, BasicStroke stroke, boolean filled) {
        setStartPoint(startPoint);
        setEndPoint(endPoint);
        setPaint(paint);
        setStroke(stroke);
        setFilled(filled);
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
