import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author      Firstname Lastname david.boman99@hotmail.com
 * @version     1                 (current version number of program)
 * @since       1          (the version of the package this class was first added to)
 */

public abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private Point2D.Double position;
    private int dir;
    private int size;
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    /**
     * Car is given default position at (0,0)
     */
    public Car(){
        position = new Point2D.Double(0.0,0.0);
        stopEngine();
    }
    public void setSize(int Size){
        this.size=size;
    }

    public int getSize() {
        return size;
    }
    /**
     * Sets number of doors
     * @param nrDoors chosen number of doors for car
     */
    protected void setNrDoors(int nrDoors){
        this.nrDoors = nrDoors;
    }

    /**
     * Getter for number of doors of car.
     * @return Number of doors of the car.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Getter for the engine of the car.
     * @return Engine power of the car.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Sets engine power
     * @param enginePower Power of the engine
     */
    protected void setEnginePower(int enginePower){
        this.enginePower = enginePower;
    }

    /**
     * Getter for the current speed of car.
     * @return The current speed of the car.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Sets current speed if it is positive
     * @param currentSpeed chosen speed
     */
    protected void setCurrentSpeed(double currentSpeed){
        if(currentSpeed >= 0 && currentSpeed <= enginePower)
            this.currentSpeed = currentSpeed;
    }

    /**
     * Getter for color of car.
     * @return Color of the car.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets color of car.
     * @param clr chosen color
     */
    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts car engine and gives default starting speed 0.1
     */
    protected void startEngine(){ setCurrentSpeed(0.1);}

    /**
     * Sets current speed to 0
     */
    protected void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    /**
     * Increases speed of car.
     * <p>
     * Accepts values between 0 and 1.
     * Won't make car speed above engine power or decrease speed.
     * </p>
     * @param amount The amount to be increased.
     */
    protected void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decreases speed of the car.
     * <p>
     *     If amount specified would decrease the speed below 0, currentSpeed
     *     will be set to 0. Decrease in speed is determined by amount and speed factor of car.
     * </p>
     * @param amount
     */
    protected void decrementSpeed(double amount) {
        setCurrentSpeed((Math.max(getCurrentSpeed() - speedFactor() * amount, 0)));
    }

    /**
     * Increases the speed of car.
     * <p>
     * Accepts values between 0 and 1.
     * The amount to be increased is passed to incrementSpeed method.
     * </p>
     * @param amount Amount to be increased.
     */
    protected void gas ( double amount){
        if (0 <= amount && 1 >= amount) {
            incrementSpeed(amount);
        }
    }

    /**
     * Decreases the speed of car.
     * <p>
     * Accepts values between 0 and 1.
     * The amount to be decreased is passed to decrementSpeed method.
     * </p>
     * @param amount The amount to be decreased.
     */
    protected void brake ( double amount){
        if (0 <= amount && 1 >= amount) {
            decrementSpeed(amount);
        }
    }

    /**
     * Changes position according to the current speed in the direction the car is facing.
     */
    public void move () {
        switch (getDir()) {
            case NORTH: position.y += currentSpeed; break;
            case WEST: position.x -= currentSpeed; break;
            case SOUTH: position.y -= currentSpeed; break;
            case EAST: position.x += currentSpeed; break;
        }
    }

    /**
     * Getter for position of car.
     * @return Position of the car.
     */
    public Point2D.Double getPosition () {
        return position;
    }

    protected void setPosition(Point2D.Double point){
        position.x = point.x;
        position.y = point.y;
    }

    /**
     * Getter for direction of car.
     * @return Direction of the car.
     */
    public int getDir () {
        return dir;
    }

    /**
     * Changes the direction to one turn to the left.
     */
    public void turnLeft () {
        switch (dir) {
            case NORTH: dir = WEST; break;
            case WEST: dir = SOUTH; break;
            case SOUTH: dir = EAST; break;
            case EAST: dir = NORTH; break;
        }
    }

    /**
     * Changes the direction to one turn to the Right.
     */
    public void turnRight () {
        switch (dir) {
            case NORTH: dir = EAST; break;
            case WEST: dir = NORTH; break;
            case SOUTH: dir = WEST; break;
            case EAST: dir = SOUTH; break;
        }
    }


}
