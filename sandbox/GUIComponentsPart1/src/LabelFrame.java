import java.awt.*;
import javax.swing.*;

public class LabelFrame extends JFrame {

    private final JLabel label1; // label with just text
    private final JLabel label2; // label with text and icon
    private final JLabel label3; // label with text and icon added

    public LabelFrame() { // constructor adds JLabel to JFrame
        super("Testing JLabel");
        setLayout(new FlowLayout()); // set frame layout

        // JLabel constructor with string arg
        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1");
        add(label1); // add label1 to JFrame

        // JLabel constructor with String, Icon, and alignment arguments
        Icon psu = new ImageIcon(getClass().getResource("psu.png"));
        label2 = new JLabel("Label with text and icon", psu, SwingConstants.LEFT);
        label2.setToolTipText("This is label2");
        add(label2);

        // JLabel constructor with no arguments -- add text/icon later
        label3 = new JLabel();
        label3.setText("Label with text and icon added");
        label3.setIcon(psu);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        add(label3);
    }
}
