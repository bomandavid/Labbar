import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Sets number of doors, color and engine power
     */
    public Volvo240() {
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setSize(1);
    }

    /**
     * Converts engine power into speed factor.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
