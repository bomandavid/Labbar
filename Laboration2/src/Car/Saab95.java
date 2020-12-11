package Car;

import java.awt.*;

/**
 * <p>
 *     The Car.Saab95 extends the Car.Car class. In addition to a generic Car.Car, the Car.Saab95 can have a turbo.
 * </p>
 */
class Saab95 extends Car implements Turbo{

    private boolean turboOn;

    /**
     * Sets number of doors, color, engine speed and turbo on or off.
     */
    Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(300);
        turboOn = false;
        setSize(1);
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
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.5;
        return getEnginePower() * 0.01 * turbo;
    }

    public String getImage(){
        return "pics/Saab95.jpg";
    }

    public String getCarBrand(){
        return "Saab95";
    }
}


