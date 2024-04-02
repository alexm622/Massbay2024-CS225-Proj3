public class Location {
    
    private String locationName;
    private double x; // x-coordinate
    private double y; // y-coordinate

    public Location(String name, double x, double y) {
        this.locationName = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
