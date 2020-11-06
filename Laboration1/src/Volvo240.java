import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }
    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed((Math.max(getCurrentSpeed() - speedFactor() * amount, 0));

    }
    public static void main(String[] args){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.turnRight();
        volvo.move();
        System.out.println(volvo.getNrDoors());
    }
}
