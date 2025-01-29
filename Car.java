import java.awt.*;

public abstract class Car implements Movable {
    // Static final (Konstanter för hela klassen)
    private static final String GAS_BREAK_AMOUNT_ERROR = "MethodInput must be between 0 or 1";
    private static final String SPEED_DECREASE_ERROR = "Speed decreases after calling gas()";
    private static final String SPEED_INCREASE_ERROR = "Speed increases after calling break()";

    // Final instansvariabler (Konstanter för varje objekt)
    private final int NR_DOORS; // Number of doors on the car
    private final double ENGINE_POWER; // Engine power of the car
    private final String MODEL_NAME; // The car model name

    // Vanliga instansvariabler
    private double x, y; // koordinater för bilen
    private double dx, dy; // riktningskoordinater (cosinus, sinus)
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car


    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.NR_DOORS = nrDoors;
        this.ENGINE_POWER = enginePower;
        this.color = color;
        this.MODEL_NAME = modelName;

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

    public double getDx() {
        return this.dx;
    }

    public double getDy() {
        return this.dy;
    }


    public String getModelName() { return MODEL_NAME; }

    public int getNrDoors(){
        return NR_DOORS;
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

    public double getEnginePower(){
        return ENGINE_POWER;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    private void setCurrentSpeed(double currentSpeed) {
        if(currentSpeed < 0) {
            this.currentSpeed = 0;
        }
        else if(currentSpeed > getEnginePower()) {
            this.currentSpeed = getEnginePower();
        }
        else {
            this.currentSpeed = currentSpeed;
        }
    }

    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }


    public abstract double speedFactor();




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


    public void gas(double amount){
        if(amount < 0 || amount > 1) {
            throw new IllegalArgumentException(GAS_BREAK_AMOUNT_ERROR);
        }
        double speedBeforeGas = getCurrentSpeed();
        incrementSpeed(amount);

        if(speedBeforeGas > getCurrentSpeed()) {
            throw new IllegalArgumentException(SPEED_DECREASE_ERROR);
        }
    }


    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException(GAS_BREAK_AMOUNT_ERROR);
        }
        double speedBeforeBreak = getCurrentSpeed();
        decrementSpeed(amount);

        if(speedBeforeBreak > getCurrentSpeed()) {
            throw new IllegalArgumentException(SPEED_INCREASE_ERROR);
        }
    }



    public void stopEngine(){
        currentSpeed = 0;
    }

}
