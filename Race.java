import java.util.ArrayList;

import javax.swing.*;

public class Race {
    private JFrame gameFrame;
    private GameStartPanel startPanel;
    private RacePanel racePanel; // Declare RacePanel instance

    public static ArrayList<Car> cars = new ArrayList<>();
    public static int raceLength = 10000;

    public Race() {
        gameFrame = new JFrame();
        startPanel = new GameStartPanel();
        gameFrame.setSize(2000, 1500);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setContentPane(startPanel);
        gameFrame.pack();
        gameFrame.setVisible(true);
    }

    // Method to initialize RacePanel and set it as content pane
    public void startRace() {
        racePanel = new RacePanel(); // Initialize RacePanel
        gameFrame.setContentPane(racePanel); // Set RacePanel as content pane
        gameFrame.pack(); // Pack the frame to adjust its size
    }

    public static void main(String[] args) {
        //create 4 cars with car number being -1, car name being "default", car color being Color.BLACK, and car speed being 0
        for (int i = 0; i < 4; i++) {
            cars.add(new Car(-1, "default", java.awt.Color.BLACK, 0));
        }
        Race race = new Race(); // Create Race instance
        // Now, the RacePanel will be shown when we call startRace() method.
    }
}
