
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrackGUI extends JPanel {
    private ArrayList<Path> paths;

    public TrackGUI(ArrayList<Path> paths) {
        this.paths = paths;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Path path : paths) {
            ArrayList<Checkpoint> checkpoints = path.getCheckpoints();
            Point prevPoint = null;
            for (Checkpoint checkpoint : checkpoints) {
                Point point = checkpoint.getPoint();
                if (prevPoint != null) {
                    g.drawLine(prevPoint.x, prevPoint.y, point.x, point.y);
                }
                prevPoint = point;
            }
        }
    }
}