import java.awt.*;

public class Volvo240 extends Car {

    private final static double TRIM_FACTOR = 1.25;


    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * TRIM_FACTOR;
    }

    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }


}
