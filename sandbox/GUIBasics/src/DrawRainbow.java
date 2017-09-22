import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawRainbow extends JPanel {

    // define indigo and violet
    private final static Color VIOLET = new Color(128, 0, 128);
    private final static Color INDIGO = new Color(75, 0, 130);
    private final static int RADIUS = 20;

    // colors to use in the rainbow, starting from innermost
    // two whites are to make the inner "empty" arc
    private Color[] colors =
            {Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
             Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};

    // constructor
    public DrawRainbow() {
        setBackground(Color.WHITE); // set background to white
    }

    // draws a rainbow using concentric arcs
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int radius = RADIUS;
        int centerX = getWidth() / 2; // center the arcs horizontally
        int centerY = getHeight() - 10; // position the arcs vertically near the bottom

        // draws filled arcs, starting with outermost (RED)
        for (int i = colors.length - 1; i >= 0; i--) {
            // set the color
            g.setColor(colors[i]);

            // fill the arc from 0 to 180 degrees
            g.fillArc(centerX - i * radius,centerY - i * radius,
                    i * radius * 2, i * radius * 2,
                    0, 180);
        }
    }
}
