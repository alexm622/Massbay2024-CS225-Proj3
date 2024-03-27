import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameStartPanel extends JPanel {
    private ArrayList<SelectionPanel> carSelections;
    private JButton[] addPlayer;
    private JButton startGame;

    public GameStartPanel(){
        //initialize class values and components
        setPreferredSize(new Dimension(1200, 1000));
        setBackground(Color.black);
        setLayout(new GridBagLayout());
        startGame = new JButton("Start Game");
        startGame.setPreferredSize(new Dimension(600, 200));
        startGame.setActionCommand("Start");
        carSelections = new ArrayList<>(4);
        addPlayer = new JButton[4];
        for(int i = 0; i < 4; i++){
            carSelections.add(i, new SelectionPanel());
            carSelections.get(i).setPreferredSize(new Dimension(300, 800));
            addPlayer[i] = new JButton("Add Player");
            addPlayer[i].setPreferredSize(new Dimension(300, 800));
            addPlayer[i].setActionCommand("Add " + i);
        }

        //initialize start panel to default state.
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.gridheight = 4;
        for(int i = 0; i < 4; i++){
            c.gridx = i;
            add(addPlayer[i], c);
        }
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        c.gridheight = 1;
        add(startGame, c);
    }

    public void addPlayer(int i){
        remove(addPlayer[i]);

    }


}
