package Car;

import Car.Car;

import java.awt.*;

/**
 * Subclass of car with trimfactor as added feature.
 */
public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    /**
     * Sets number of doors, color and engine power
     */
     Volvo240() {
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(300);
        setSize(1);
    }

    /**
     * Converts engine power into speed factor.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    public String getImage(){
        return "pics/Volvo240.jpg";
    }

    @Override
    public String getCarBrand() {
        return "Volvo240";
    }
}
