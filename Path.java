
import java.util.ArrayList;

public class Path {
    private ArrayList<Checkpoint> checkpoints;

    public Path(ArrayList<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public ArrayList<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(ArrayList<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }
}
