import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameStartPanel extends JPanel {
    private ArrayList<SelectionPanel> carSelections;
    private JButton[] addPlayer;
    private JButton startGame;

    public GameStartPanel() {
        // initialize class values and components
        setPreferredSize(new Dimension(1200, 1000));
        setBackground(Color.black);
        setLayout(new GridBagLayout());
        startGame = new JButton("Start Game");
        startGame.setPreferredSize(new Dimension(600, 200));
        startGame.setActionCommand("Start");
        startGame.addActionListener(e -> {
            System.out.println("Start Game");
            startGame();
        });
        carSelections = new ArrayList<>(4);
        addPlayer = new JButton[4];
        for (int i = 0; i < 4; i++) {
            carSelections.add(i, new SelectionPanel());
            carSelections.get(i).setPreferredSize(new Dimension(300, 800));
            addPlayer[i] = new JButton("Add Player");
            addPlayer[i].setPreferredSize(new Dimension(300, 800));
            addPlayer[i].setActionCommand("Add " + i);
            addPlayer[i].addActionListener(e -> addPlayer(Integer.parseInt(e.getActionCommand().substring(4))));
        }

        // initialize start panel to default state.
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.gridheight = 4;
        for (int i = 0; i < 4; i++) {
            c.gridx = i;
            add(addPlayer[i], c);
        }
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 1;
        add(startGame, c);
    }

    public void addPlayer(int i) {
        // print a little thing to the console to show that the button was pressed
        System.out.println("Add Player " + i);

        // create a new car selection panel and use that to replace the add player
        // button
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = i;
        c.gridy = 0;
        c.gridheight = 4;
        remove(addPlayer[i]);
        add(carSelections.get(i), c);

        carSelections.get(i).getSubmitButton().addActionListener(e -> {
            System.out.println("Save Player " + i);
        
            // check to see if the input is valid
            if (carSelections.get(i).validateInput()) {
                // create a new car object
                Car newCar = new Car(carSelections.get(i).getCarNumber(), carSelections.get(i).getCarName(),
                        carSelections.get(i).getCarColor(), carSelections.get(i).getCarSpeed());
                
                // If the car at index i already exists, update it; otherwise, add it to the list
                if (Race.cars.size() > i) {
                    Race.cars.set(i, newCar); // Update existing car
                } else {
                    Race.cars.add(newCar); // Add new car
                }
                
                System.out.println("Car " + i + " saved");
            } else {
                System.out.println("Car " + i + " not saved");
            }
        });
        

        revalidate();

    }

    private void startGame() {

        //first try hitting all the save buttons
        for (int i = 0; i < 4; i++) {
            carSelections.get(i).getSubmitButton().doClick();
        }

        // check to make sure that there are at least 2 players
        int numPlayers = 0;
        for (int i = 0; i < 4; i++){
            if (Race.cars.get(i).getCarNumber() != -1) {
                numPlayers++;
            }
        }

        if (numPlayers < 2) {
            JOptionPane.showMessageDialog(this, "You must have at least 2 players to start the game.");
            return;
        }

        //do an optionpane to ask for the race length
        int raceLength = 0;
        do{
            String input = JOptionPane.showInputDialog(this, "Enter race length (0 to quit):");
            if(input == null){
                return;
            }
            try{
                raceLength = Integer.parseInt(input);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Please enter a valid number");
            }
        }while(raceLength == 0);

        Race.raceLength = raceLength;  
        

        // kill this window and start the game
        JFrame gameFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        gameFrame.setContentPane(new RacePanel());
        gameFrame.pack();

    }

}
