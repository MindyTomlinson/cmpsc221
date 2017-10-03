import javax.swing.JOptionPane;

public class Addition {
    public static void main(String[] args) {

        // obtain first and second number from user
        String numberInput1 = JOptionPane.showInputDialog("Enter first number");
        String numberInput2 = JOptionPane.showInputDialog("Enter second number");

        // parse ints
        int number1 = Integer.parseInt(numberInput1);
        int number2 = Integer.parseInt(numberInput2);

        // calculate result
        int answer = number1 + number2;
        String result = String.format("The sum is: %d", answer);

        // display result
        JOptionPane.showMessageDialog(null, result, "Answer", JOptionPane.PLAIN_MESSAGE);
    }
}
