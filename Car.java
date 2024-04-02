import java.awt.Color;

public class Car {
    private int carNumber;
    private String carName;
    private Color carColor;
    private int carSpeed;

    public Car(int carNumber, String carName, Color carColor, int carSpeed) {
        this.carNumber = carNumber;
        this.carName = carName;
        this.carColor = carColor;
        this.carSpeed = carSpeed;
    }


    public int getCarNumber() {
        return this.carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarName() {
        return this.carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Color getCarColor() {
        return this.carColor;
    }

    public void setCarColor(Color carColor) {
        this.carColor = carColor;
    }

    public int getCarSpeed() {
        return this.carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }
    
}
