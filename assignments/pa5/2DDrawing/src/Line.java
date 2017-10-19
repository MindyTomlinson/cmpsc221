import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends Shape {

    public Line(Point startPoint, Point endPoint, Paint paint, BasicStroke stroke) {
        setStartPoint(startPoint);
        setEndPoint(endPoint);
        setPaint(paint);
        setStroke(stroke);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(getPaint());
        g2d.setStroke(getStroke());
        g2d.draw(new Line2D.Double(getStartPoint(), getEndPoint()));
    }
}
