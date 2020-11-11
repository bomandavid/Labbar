import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    /**
     * Sets number of doors, color, enginespeed and turbo on or off.
     */
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        turboOn = false;
    }

    /**
     * Turns on turbo.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Turns off turbo.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Converts engine power and turbo into speed factor.
     * @return
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * Increases the speed of the Saab by the speedfactor times the amount.
     * @param amount
     */
    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    /**
     * Decreases the speed of the saab by the speedfactor times the amount.
     * @param amount
     */
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        Car volvo = new Volvo240();
        saab.startEngine();
        saab.setTurboOn();
        saab.setTurboOff();
    }
}


