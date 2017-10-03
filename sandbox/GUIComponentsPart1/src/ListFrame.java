import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.FlowLayout;

public class ListFrame extends JFrame {

    private final JList<String> colorList;
    private static final String[] colorNames = {"Black", "Blue", "Cyan",
            "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
            "Orange", "Pink", "Red", "White", "Yellow"};
    private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN,
            Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

    // List frame constructor

    public ListFrame() {

        // Setup frame
        super("Pick Background Color");
        setLayout(new FlowLayout());

        // Create JList
        colorList = new JList<String>(colorNames);

        // Set number of visible rows in list to 5
        colorList.setVisibleRowCount(5);

        // Disable multiple selections
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add a JScrollPane containing the JList to frame
        add(new JScrollPane(colorList));

        // Add an event listener implementing ListSelectionListener
        // using an anonymous inner class
        colorList.addListSelectionListener(new ListSelectionListener() {

            // Event listener should change the background of the window to the selected color
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getContentPane().setBackground(colors[colorList.getSelectedIndex()]);
            }
        });
    }
}
