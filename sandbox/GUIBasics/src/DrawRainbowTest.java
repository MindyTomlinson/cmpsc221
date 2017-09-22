import javax.swing.JFrame;

public class DrawRainbowTest {

    public static void main(String[] args) {

        DrawRainbow drawRainbowPanel = new DrawRainbow();
        JFrame jFrameApplication = new JFrame();

        jFrameApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameApplication.add(drawRainbowPanel);
        jFrameApplication.setSize(400, 250);
        jFrameApplication.setVisible(true);
    }

}
