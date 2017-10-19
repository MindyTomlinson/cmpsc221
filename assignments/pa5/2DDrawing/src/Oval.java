import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Oval extends BoundedShape {

    public Oval(Point startPoint, Point endPoint, Paint paint, BasicStroke stroke, boolean filled) {
        super(startPoint, endPoint, paint, stroke, filled);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(getPaint());
        g2d.setStroke(getStroke());
        if (isFilled()) {
            g2d.fill(new Ellipse2D.Double(getTopX(), getTopY(), getWidth(), getHeight()));
        }
        else {
            g2d.draw(new Ellipse2D.Double(getTopX(), getTopY(), getWidth(), getHeight()));
        }
    }
}
