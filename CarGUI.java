import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class CarGUI extends JPanel {
    private Point position;
    private Color color;
    private int size;
    private Car car; // Reference to the associated Car object

    public CarGUI(Point position, Color color, int size, Car car) {
        this.position = position;
        this.color = color;
        this.size = size;
        this.car = car;
    }

    // Method to update car position
    public void updatePosition(Point newPosition) {
        this.position = newPosition;
        repaint();
    }

    // Method to move the car forward
    public boolean moveCar() {
        int newX = position.x + car.getCarSpeed();
        if (newX >= getParent().getWidth()) {
            return false; // Car reached the finish line
        } else {
            updatePosition(new Point(newX, position.y));
            return true; // Car still in the race
        }
    }

    // Method to retrieve the associated Car object
    public Car getCar() {
        return car;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(position.x, position.y, size, size);
    }

    // Method to get the current position of the car
    public Point getPosition() {
        return position;
    }
}
