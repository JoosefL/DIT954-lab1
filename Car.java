import java.awt.*;

public abstract class Car implements Movable {

    public double x;
    public double y;
    public int direction;



    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        stopEngine();
    }

    // få positionen av bilen
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }


    public String getModelName() { return modelName; }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }



    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);


    @Override
    public void move() {



    }

    @Override
    public void turnLeft() {
        this.x -= currentSpeed;

    }

    @Override
    public void turnRight() {
        this.x += currentSpeed;

    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }




    public void stopEngine(){
        currentSpeed = 0;
    }

}
