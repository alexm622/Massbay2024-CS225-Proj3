import javax.swing.*;

public class Race {
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

    public static void main(String[] args){
        new Race();
    }
}
