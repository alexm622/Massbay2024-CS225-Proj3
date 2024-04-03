import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RacePanel extends JPanel {
    private ArrayList<CarGUI> carGUIs = new ArrayList<>();
    private ArrayList<Point> checkpoints; // List of checkpoints
    private ArrayList<ArrayList<Point>> paths = new ArrayList<>(); // List of paths for each car
    private int currentCheckpointIndex = 0; // Index of the current checkpoint

    public RacePanel() {
        setPreferredSize(new Dimension(1000, 500)); // Set your desired width and height
        setLayout(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for dynamic component positioning

        // Initialize checkpoints
        checkpoints = new ArrayList<>();
        checkpoints.add(new Point(50, 50)); // Add the starting point as the first checkpoint
        checkpoints.add(new Point(250, 250)); // Add a checkpoint
        checkpoints.add(new Point(500, 50)); // Add a checkpoint
        checkpoints.add(new Point(750, 250)); // Add a checkpoint
        checkpoints.add(new Point(950, 50)); // Add a checkpoint
        checkpoints.add(new Point(950, 400)); // Add the finish line as the last checkpoint

        // Generate paths for each car
        generatePaths();

        // Populate CarGUIs based on Race.cars and paths
        for (int i = 0; i < Race.cars.size(); i++) {
            Car car = Race.cars.get(i);
            if (car.getCarNumber() != -1) {
                // Calculate initial position of car based on its index
                Point initialPosition = paths.get(i).get(0); // Start from the first checkpoint

                CarGUI carGUI = new CarGUI(initialPosition, car.getCarColor(), 50, car); // Adjust size as needed

                carGUIs.add(carGUI);
                add(carGUI);
            }
        }

        // Start the race simulation timer
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move each car forward and check for race completion
                for (CarGUI carGUI : carGUIs) {
                    if (!(carGUI).moveCar()) {
                        // Car reached the finish line
                        Car winner = carGUI.getCar();
                        JOptionPane.showMessageDialog(RacePanel.this, String.format("The winner is %s!", winner.getCarName()));
                        System.exit(0);
                    }
                }
            }
        });
        timer.start();
    }

    // Method to generate unique paths for each car
    private void generatePaths() {
        for (int i = 0; i < Race.cars.size(); i++) {
            ArrayList<Point> path = new ArrayList<>();
            for (Point checkpoint : checkpoints) {
                path.add(new Point(checkpoint.x, checkpoint.y + i * 100)); // Adjust as needed for spacing between paths
            }
            paths.add(path);
        }
    }
}
