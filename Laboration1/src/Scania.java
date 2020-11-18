import java.awt.*;

public class Scania extends Car {
    private double loadingAngle;

    public Scania(){
        setNrDoors(2);
        setColor(Color.black);
        setEnginePower(400);
        setSize(2);
    }

    /**
     * Returns a standard speed factor.
     * @return The speedfactor of the truck.
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.005;
    }

    /**
     *  Getter for loading angle.
     * @return The loading angle of the truck.
     */
    public double getLoadingAngle(){
        return loadingAngle;
    }

    /**
     * Increases the loading angel.
     * @param amount The amount you want to increase the loading angle with.
     */
    public void increaseLoadingAngle(double amount){
        if(getCurrentSpeed() == 0) {
            if (loadingAngle + amount > 70) {
                loadingAngle = 70;
            }
            else
                loadingAngle += amount;
        }
    }

    /**
     * Decreases the loading angle.
     * @param amount
     */
    public void decreaseLoadingAngle(double amount){
            if (loadingAngle - Math.abs(amount) < 0) {
                loadingAngle = 0;
            }
            else
                loadingAngle -= Math.abs(amount);
    }

    @Override
    public void setCurrentSpeed(double amount){
        if(getLoadingAngle() == 0)
            super.setCurrentSpeed(amount);
    }
}
