import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldFrame extends JFrame {

    private final JTextField textField;

    public TextFieldFrame() {
        // Setup the frame
        super("Testing Text Field Event Handlers");
        setLayout(new FlowLayout());

        // Create text field component and add it to frame
        textField = new JTextField("Default text", 20);
        add(textField);

        // Instantiate event handler and register it with the component
        textField.addActionListener(new TextFieldHandler());
    }

    private class TextFieldHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, "You hit Enter!");
        }
    }
}
