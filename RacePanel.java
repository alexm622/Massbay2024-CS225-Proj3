import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class RacePanel extends JPanel {

    private ArrayList<JProgressBar> progressBars = new ArrayList<>();
    public RacePanel() {

        setPreferredSize(new java.awt.Dimension(2000, 1500)); // Set your desired width and height

        setLayout(new GridLayout(4, 1));



        for (int i = 1; i <= 4; i++) {
            Car c = Race.cars.get(i - 1);
            if(c.getCarNumber() == -1) {
                continue;
            }
            JProgressBar progressBar = new JProgressBar();
            progressBar.setString(String.format("Car #%d: %s", c.getCarNumber(), c.getCarName()));
            progressBar.setStringPainted(true);
            progressBar.setForeground(c.getCarColor());
            progressBar.setValue(1);
            progressBar.setMaximum(Race.raceLength);
            progressBars.add(progressBar);
            add(progressBar);
        }

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxProgress = 0;
                int winnerIndex = -1;
        
                for (int i = 0; i < progressBars.size(); i++) {
                    JProgressBar progressBar = progressBars.get(i);
                    int value = progressBar.getValue();
                    if (value >= progressBar.getMaximum()) {
                        // Car finished the race
                        if (value > maxProgress) {
                            // Update maxProgress and winnerIndex
                            maxProgress = value;
                            winnerIndex = i;
                        }
                    } else {
                        // Car is still racing, update progress
                        value += Race.cars.get(i).getCarSpeed();
                        progressBar.setValue(value);
                    }
                }
        
                if (winnerIndex != -1) {
                    // Stop the timer
                    ((Timer) e.getSource()).stop();
                    // Get the winner car
                    Car winner = Race.cars.get(winnerIndex);
                    // Display the winner
                    javax.swing.JOptionPane.showMessageDialog(RacePanel.this, String.format("The winner is %s!", winner.getCarName()));
                    // Exit the application
                    System.exit(0);
                }
            }
        });
        
        timer.start();
    

        //Car winner = Race.cars.get(maxIndex);

        // Display a message dialog with the winner's name
        //javax.swing.JOptionPane.showMessageDialog(this, String.format("The winner is %s!", winner.getCarName()));
    
    }
}
