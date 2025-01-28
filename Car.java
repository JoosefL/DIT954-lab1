import java.awt.*;

public abstract class Car implements Movable {

    private double x, y; // koordinater för bilen
    private double dx, dy; // riktningskoordinater (cosinus, sinus)


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
        this.dx = 1;
        this.dy = 0;
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
        x += dx * currentSpeed;
        y += dy * currentSpeed;
    }

    @Override
    public void turnLeft() {
        double temp = dx;
        dx = -dy;
        dy = temp;
    }

    @Override
    public void turnRight() {
        double temp = dx;
        dx = dy;
        dy = -temp;
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
