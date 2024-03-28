import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Race implements ActionListener {
    private JFrame gameFrame;
    private GameStartPanel startPanel;

    public Race(){
        gameFrame = new JFrame();
        startPanel = new GameStartPanel();
        gameFrame.setSize(1800, 1000);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setContentPane(startPanel);
        gameFrame.pack();
        gameFrame.setVisible(true);

    }

    /**
     * initializes all components for game start.
     */
    private void startGame(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] command = e.getActionCommand().split(" ");
        if(e.getActionCommand().equals("Start")){
            startGame();
        }
        if(command[0].equals("Add")){
            startPanel.addPlayer(Integer.parseInt(command[1]));
        }
    }

    //******************************************************************************************************************
    public static void main(String[] args){
        new Race();
    }
}
