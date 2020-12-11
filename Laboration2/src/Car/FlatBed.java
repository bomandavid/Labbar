package Car;

/**
 * Interface to be implemented if an object has a Flatbed.
 */
public interface FlatBed {
    /**
     * Increases the angle of the bed by an amount
     * @param amount
     */
    public void increaseLoadingAngle(double amount);
    /**
     * Decreases the angle of the bed by an amount
     * @param amount
     */
    public void decreaseLoadingAngle(double amount);

    /**
     * Getter for loading angle
     **/
    public double getLoadingAngle();
}
