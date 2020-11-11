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
    }

    /**
     * Converts engine power into speed factor.
     * @return
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Increments speed
     * @param amount
     */
    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decreases speed
     * @param amount
     */
    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed((Math.max(getCurrentSpeed() - speedFactor() * amount, 0)));
    }

    public static void main(String[] args){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.turnRight();
        volvo.move();
        for(int i = 0; i<100; i++) {
            volvo.gas(1);
            System.out.println(volvo.getCurrentSpeed());
        }
    }
}
