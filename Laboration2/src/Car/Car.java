package Car;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * <p>
 *     The Car class represents an abstract version of a car. It implements the Movable interface.
 *     The class contains standard methods that represent how a car would act. The methods have aspects of a
 *     cars speed, direction, position, engine power, size, number of doors and color.
 * </p>
 */
public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private Point2D.Double position;
    // private Direction dir;
    private int size;
    private Movable dirState;

    private North north;
    private South south;
    private West west;
    private East east;


    /**
     * Car is given default position at (0,0), and defualt direction is south.
     */
    public Car(){
        north = new North(this);
        south = new South(this);
        west = new West(this);
        east = new East(this);

        dirState = south;

        //dir = Direction.SOUTH;
        //setDir(SOUTH);
        position = new Point2D.Double(0.0,0.0);
        stopEngine();
    }

    /**
     * Set size of car.
     * @param size
     */
    public void setSize(int size){
        this.size=size;
    }

    /**
     * Get size of car.
     * @return
     */
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
        if(currentSpeed > 0 && currentSpeed <= enginePower)
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
    public void startEngine(){
       if(getCurrentSpeed() == 0)
           setCurrentSpeed(0.1);
    }

    /**
     * Sets current speed to 0
     */
    public void stopEngine(){
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
    public void gas ( double amount){
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
    public void brake ( double amount){
        if (0 <= amount && 1 >= amount) {
            decrementSpeed(amount);
        }
    }

    /**
     *
     * @return Position reference.
     */
    public Point2D.Double getPosition () {
        return position;
    }

    /**
     * Changes position for car object.
     * @param point
     */
    public void setPosition(Point2D.Double point) {
        position.x = point.x;
        position.y = point.y;
    }

    /**
     * Get image representation of the car.
     * @return
     */
    public abstract String getImage();

    // new methods for state pattern

    /**
     * Changes directional state of the object.
     * @param dirState The desired direction.
     */
    public void setDirection(Movable dirState){
        this.dirState = dirState;
    }

    /**
     * Turns car 180 degrees.
     */
    public void invertDir() {
        turnLeft();
        turnLeft();
    }

    /**
     * Get south direction state.
     * @return south state
     */
    public Movable getSouthState(){
        return south;
    }

    /**
     * Get east direction state.
     * @return east state
     */
    public Movable getEastState(){
        return east;
    }

    /**
     * Get west direction state.
     * @return west state
     */
    public Movable getWestState(){
        return west;
    }

    /**
     * Get north direction state.
     * @return north state
     */
    public Movable getNorthState(){
        return north;
    }

    /**
     * Get the current direction state.
     * @return  direction state
     */
    public Movable getDirState(){
        return dirState;
    }

    /**
     * Moves the car basen on its current direction.
     */
    public void move(){
        dirState.move();
    }

    /**
     * Turns the car 90 degrees right.
     */
    public void turnRight(){
        dirState.turnRight();
    }

    /**
     * Turns the car 90 degrees left.
     */
    public void turnLeft(){
        dirState.turnLeft();
    }

    /**
     * Get the brand of car object.
     * @return
     */
    public abstract String getCarBrand();

}
