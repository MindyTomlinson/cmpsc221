import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DrawFrame extends JFrame {

    private final DrawPanel drawPanel;
    private final MousePositionPanel mousePositionPanel;
    private final JButton undoButton;
    private final JButton clearButton;
    private final JComboBox<String> shapeTypeComboBox;
    private final JCheckBox filledCheckbox;
    private final JCheckBox useGradientCheckbox;
    private final JButton colorPicker1;
    private final JButton colorPicker2;
    private final JTextField lineWidthTextField;
    private final JTextField dashLengthTextField;
    private final JCheckBox dashedCheckbox;
    private Color color1 = Color.BLACK;
    private Color color2 = Color.BLACK;
    private boolean useGradient;
    private float lineWidth;
    private boolean dashed;
    private float dashLength = 1.0f;
    private Random random = new Random(); // For generating the gradient

    public DrawFrame() {
        super("Java 2D Drawings");
        setLayout(new BorderLayout());

        // initialize control panel, top/bottom panels, set their layouts, add them to frame
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(topPanel, BorderLayout.NORTH);
        controlPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(controlPanel, BorderLayout.NORTH); // add the whole control panel

        // initialize mouse position panel, draw panel, add them to frame
        mousePositionPanel = new MousePositionPanel();
        drawPanel = new DrawPanel(mousePositionPanel);
        add(mousePositionPanel, BorderLayout.SOUTH);
        add(drawPanel, BorderLayout.CENTER);

        // Setup Undo button
        undoButton = new JButton("Undo");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.undo();
            }
        });

        // Setup Clear button
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.clearDrawing();
            }
        });

        // Setup ShapeType dropdown
        shapeTypeComboBox = new JComboBox<>(Shape.shapeNames);
        shapeTypeComboBox.setMaximumRowCount(3);
        shapeTypeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) { // when an item is selected...
                    drawPanel.setNextShapeType(shapeTypeComboBox.getSelectedIndex());
                }
            }
        });

        // Setup Filled checkbox
        filledCheckbox = new JCheckBox("Filled");
        filledCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                drawPanel.setNextFilled(filledCheckbox.isSelected()); // is the checkbox selected?
            }
        });

        // Setup Use Gradient dropdown
        useGradientCheckbox = new JCheckBox("Use Gradient");
        useGradientCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                useGradient = useGradientCheckbox.isSelected();
                setPaint();
            }
        });

        // Setup 1st Color color-picker
        colorPicker1 = new JButton("1st Color");
        colorPicker1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color1 = JColorChooser.showDialog(
                        DrawFrame.this, "Choose 1st color", color1);
                if (color1 == null) {
                    color1 = Color.BLACK;
                }
                setPaint();
            }
        });

        // Setup 2nd Color color-picker
        colorPicker2 = new JButton("2nd Color");
        colorPicker2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color2 = JColorChooser.showDialog(
                        DrawFrame.this, "Choose 2nd color", color2);
                if (color2 == null) {
                    color2 = Color.BLACK;
                }
                setPaint();
            }
        });

        // Setup Line Width textfield
        lineWidthTextField = new JTextField(2);
        lineWidthTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleWidthValue();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                handleWidthValue();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                handleWidthValue();
            }
            public void handleWidthValue() {
                try {
                    int widthValue = Integer.parseInt(lineWidthTextField.getText());
                    if (widthValue < 0.0f) {
                        throw new NumberFormatException("Line width must be > 0");
                    }
                    else {
                        lineWidth = widthValue;
                    }
                }
                catch (NumberFormatException e) {
                    lineWidth = 0.0f; // Default to zero if bad line width is entered
                }
                finally {
                    setStroke();
                }
            }
        });


        // Setup Dash Length textfield
        dashLengthTextField = new JTextField(2);
        dashLengthTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleDashValue();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                handleDashValue();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                handleDashValue();
            }
            public void handleDashValue() {
                try {
                    int dashValue = Integer.parseInt(dashLengthTextField.getText());
                    if (dashValue < 0.0f) {
                        throw new NumberFormatException("Dash length must be > 0");
                    }
                    dashLength = dashValue;
                }
                catch (NumberFormatException e) {
                    dashLength = 0.0f; // Default to zero if bad dash length is entered
                }
                finally {
                    setStroke();
                }
            }
        });

        // Setup Dashed checkbox
        dashedCheckbox = new JCheckBox("Dashed");
        dashedCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dashed = dashedCheckbox.isSelected();
                setStroke();
            }
        });

        // Add controls to top and bottom panels
        topPanel.add(undoButton);
        topPanel.add(clearButton);
        topPanel.add(new JLabel("Shape:"));
        topPanel.add(shapeTypeComboBox);
        topPanel.add(filledCheckbox);
        bottomPanel.add(useGradientCheckbox);
        bottomPanel.add(colorPicker1);
        bottomPanel.add(colorPicker2);
        bottomPanel.add(new JLabel("Line Width:"));
        bottomPanel.add(lineWidthTextField);
        bottomPanel.add(new JLabel("Dash Length:"));
        bottomPanel.add(dashLengthTextField);
        bottomPanel.add(dashedCheckbox);

    }

    private void setPaint() {
        color1 = (color1 == null) ? Color.BLACK : color1; // Just in case color1 or color2 got nulled
        color2 = (color2 == null) ? Color.BLACK : color2;
        Paint paint;
        if (useGradient) {
            paint = new GradientPaint(0, 0, color1, 50, 50, color2, true);
        } else {
            paint = color1;
        }
        drawPanel.setNextPaint(paint);
    }

    private void setStroke() {
        lineWidth = (lineWidth < 0.0f) ? 0.0f : lineWidth;
        dashLength = (dashLength < 1.0f) ? 1.0f : dashLength;
        float[] dashes = {dashLength};
        BasicStroke stroke;
        if (dashed) { 
            stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                    10, dashes, 0);
        } else { // make a solid stroke
            stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        }
        drawPanel.setNextStroke(stroke);
    }
}

