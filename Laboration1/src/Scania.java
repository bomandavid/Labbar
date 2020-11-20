import java.awt.*;

/**
 * <p>
 *     The Scania class inherits from the Car class. As opposed to a generic Car, a Scania
 *     has a flat bed for loading and unloading cargo. The bed can be risen and lowered and the Scania
 *     is prevented from moving if the flat bed is not in its original position.
 * </p>
 */
public class Scania extends Car {
    private double loadingAngle;

    /**
     * Sets number of doors, color, engine power, size and loading angle. Defualt loading angle is zero
     */
    public Scania() {
        setNrDoors(2);
        setColor(Color.black);
        setEnginePower(400);
        setSize(2);
        loadingAngle = 0;
    }

    /**
     * Returns a standard speed factor.
     *
     * @return The speedfactor of the truck.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.005;
    }

    /**
     * Getter for loading angle.
     *
     * @return The loading angle of the truck.
     */
    public double getLoadingAngle() {
        return loadingAngle;
    }

    /**
     * Increases the loading angle
     *
     * @param amount The amount you want to increase the loading angle with.
     */
    public void increaseLoadingAngle(double amount) {
        if (getCurrentSpeed() == 0) {
            if (loadingAngle + amount > 70) {
                loadingAngle = 70;
            } else
                loadingAngle += amount;
        }
    }

    /**
     * Decreases the loading angle.
     *
     * @param amount
     */
    public void decreaseLoadingAngle(double amount) {
        if (loadingAngle - Math.abs(amount) < 0) {
            loadingAngle = 0;
        } else
            loadingAngle -= Math.abs(amount);
    }

    /**
     * Sets current speed if the angle of the flatbed is zero
     * @param amount chosen speed
     */
    @Override
    public void setCurrentSpeed(double amount) {
        if (getLoadingAngle() == 0)
            super.setCurrentSpeed(amount);
    }
}