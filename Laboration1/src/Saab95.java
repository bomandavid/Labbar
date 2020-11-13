import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    /**
     * Sets number of doors, color, engine speed and turbo on or off.
     */
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        turboOn = false;
    }

    /**
     * Switches on turbo.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Switches off turbo.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Computes speed factor from engine power and turbo state
     * @return Speed factor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}


