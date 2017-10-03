import javax.swing.*;

public class CancelTest {

    public static void main(String[] args) {

        String output = JOptionPane.showInputDialog("Enter something yo");

        System.out.println(output);

        if (output == null) {
            JOptionPane.showMessageDialog(null, "Why'd you cancel?", "",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
