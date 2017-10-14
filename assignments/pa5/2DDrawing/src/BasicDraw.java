import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;

public class BasicDraw extends JFrame {

    private ShapePanel shapePanel;
    private JButton addShapeButton;
    private SecureRandom random = new SecureRandom();

    public BasicDraw() {

        super("Basic drawing");
        setLayout(new BorderLayout());

        ShapePanel shapePanel = new ShapePanel();
        add(shapePanel, BorderLayout.CENTER);

        JButton addShapeButton = new JButton("Add Shape");
        add(addShapeButton, BorderLayout.NORTH);
        addShapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = random.nextInt(100);
                int y1 = random.nextInt(100);
                int width = random.nextInt(100);
                int height = random.nextInt(100);
                Color color = new Color(random.nextInt(256),random.nextInt(256),
                        random.nextInt(256));
                Rectangle newRect = new Rectangle(x1,y1,x1 + width,y1 + height,color);
                shapePanel.addShape(newRect);
            }
        });
    }
}
