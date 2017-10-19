import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends BoundedShape {

    public Rectangle(Point startPoint, Point endPoint, Paint paint, BasicStroke stroke, boolean filled) {
        super(startPoint, endPoint, paint, stroke, filled);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(getPaint());
        g2d.setStroke(getStroke());
        if (isFilled()) {
            g2d.fill(new Rectangle2D.Double(getTopX(), getTopY(), getWidth(), getHeight()));
        }
        else {
            g2d.draw(new Rectangle2D.Double(getTopX(), getTopY(), getWidth(), getHeight()));
        }
    }
}
