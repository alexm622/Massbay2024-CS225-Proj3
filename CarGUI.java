import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class CarGUI extends JPanel {
    private Point position;
    private Color color;
    private int size;

    public CarGUI(Point position, Color color, int size) {
        this.position = position;
        this.color = color;
        this.size = size;
    }

    // Method to update car position
    public void updatePosition(Point newPosition) {
        this.position = newPosition;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(position.x, position.y, size, size);
    }
}