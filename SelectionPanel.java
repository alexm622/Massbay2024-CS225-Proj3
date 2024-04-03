import javax.swing.*;
import java.awt.Color;
import java.util.Random;

public class SelectionPanel extends JPanel {
    // Declare the variables as global
    private JLabel errorLabel;
    private JLabel label;
    private JTextField textField;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JComboBox<String> colorList;
    private JLabel label4;
    private JTextField textField3;
    private JButton submitButton;

    private int carNumber;
    private String carName;
    private Color carColor;
    private int carSpeed;

    public SelectionPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //add an error label and make it hidden
        errorLabel = new JLabel("         ");
        //set the font to red
        errorLabel.setForeground(Color.RED);
        add(errorLabel);

        // ask the player for the racer number
        label = new JLabel("Enter the car number:");
        add(label);
        textField = new JTextField();
        //give random number to the text field
        textField.setText(String.format("%d", new Random().nextInt(1000)));
        textField.setSize(BoxLayout.X_AXIS, HEIGHT);
        add(textField);

        // ask the player for the racer name
        label2 = new JLabel("Enter the car name:");
        add(label2);
        textField2 = new JTextField();
        textField2.setText("Car");
        textField2.setSize(BoxLayout.X_AXIS, HEIGHT);
        add(textField2);

        // ask the player to pick a color from a drop down menu
        label3 = new JLabel("Pick a color:");
        add(label3);
        String[] colors = { "Red", "Blue", "Green", "Yellow", "Orange", "Purple" };
        colorList = new JComboBox<>(colors);
        add(colorList);

        // ask the player to enter the speed of the car
        label4 = new JLabel("Enter the speed of the car:");
        add(label4);
        textField3 = new JTextField();
        textField3.setText(String.format("%d", new Random().nextInt(100)));
        textField3.setSize(BoxLayout.X_AXIS, HEIGHT);
        add(textField3);

        //add a save button
        submitButton = new JButton("Save");
        add(submitButton);
    }

    public boolean validateInput() {
        // check if the input is valid
        boolean isValid = true;

        // check to see if car number is a number
        try {
            carNumber = Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText("please enter a number for the car number");
            errorLabel.setVisible(true);
            isValid = false;
        }

        // check to see if car name is a string
        carName = textField2.getText();

        // check to see if car color is a valid color
        String color = (String) colorList.getSelectedItem();

        switch (color) {
            case "Red":
                carColor = Color.RED;
                break;
            case "Blue":
                carColor = Color.BLUE;
                break;
            case "Green":
                carColor = Color.GREEN;
                break;
            case "Yellow":
                carColor = Color.YELLOW;
                break;
            case "Orange":
                carColor = Color.ORANGE;
                break;
            case "Purple":
                carColor = Color.MAGENTA;
                break;
            default:
                carColor = Color.BLACK;
                isValid = false;
                break;
        }

        // check to see if car speed is a number
        try {
            carSpeed = Integer.parseInt(textField3.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText("please enter a number for the car speed");
            errorLabel.setVisible(true);
            isValid = false;
        }

        return isValid;
    }
        

    public JButton getSubmitButton() {
        return this.submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JLabel getErrorLabel() {
        return this.errorLabel;
    }

    public void setErrorLabel(JLabel errorLabel) {
        this.errorLabel = errorLabel;
    }

    public JLabel getLabel() {
        return this.label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextField getTextField() {
        return this.textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JLabel getLabel2() {
        return this.label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public JTextField getTextField2() {
        return this.textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JLabel getLabel3() {
        return this.label3;
    }

    public void setLabel3(JLabel label3) {
        this.label3 = label3;
    }

    public JComboBox<String> getColorList() {
        return this.colorList;
    }

    public void setColorList(JComboBox<String> colorList) {
        this.colorList = colorList;
    }

    public JLabel getLabel4() {
        return this.label4;
    }

    public void setLabel4(JLabel label4) {
        this.label4 = label4;
    }

    public JTextField getTextField3() {
        return this.textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public int getCarNumber() {
        return this.carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarName() {
        return this.carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Color getCarColor() {
        return this.carColor;
    }

    public void setCarColor(Color carColor) {
        this.carColor = carColor;
    }

    public int getCarSpeed() {
        return this.carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }
}
