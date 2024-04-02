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
                for (int i = 0; i < progressBars.size(); i++) {
                    JProgressBar progressBar = progressBars.get(i);
                    int value = progressBar.getValue();
                    if (value < progressBar.getMaximum()) {
                        value += Race.cars.get(i).getCarSpeed();
                        progressBar.setValue(value);
                    } else {
                        ((Timer) e.getSource()).stop();
                        int maxIndex = 0;
                        int maxValue = 0;
                        for (int j = 0; j < Race.cars.size(); j++) {
                            Car car = Race.cars.get(j);
                            if (car.getCarNumber() != -1 && progressBar.getValue() > maxValue) {
                                maxIndex = j;
                                maxValue = progressBar.getValue();
                            }
                        }
                        Car winner = Race.cars.get(maxIndex);
                        javax.swing.JOptionPane.showMessageDialog(RacePanel.this, String.format("The winner is %s!", winner.getCarName()));
                        System.exit(0);
                    }
                }
            }
        });
        timer.start();
    

        //Car winner = Race.cars.get(maxIndex);

        // Display a message dialog with the winner's name
        //javax.swing.JOptionPane.showMessageDialog(this, String.format("The winner is %s!", winner.getCarName()));
    
    }
}
