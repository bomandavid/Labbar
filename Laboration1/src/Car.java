import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author      Firstname Lastname david.boman99@hotmail.com
 * @version     1                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */

public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public Point2D.Double position;
    private int dir;
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    /**
     * Car is given default position at 0,0
     */
    public Car(){
        position = new Point2D.Double(0.0,0.0); //default position?
        stopEngine();
    }

    /**
     * Sets Number of doors.
     * @param nrDoors
     */
    public void setNrDoors(int nrDoors){
        this.nrDoors = nrDoors;
    }

    /**
     *
     * @return
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returns engine power
     * @return
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Sets engine power
     * @param enginePower
     */
    public void setEnginePower(int enginePower){
        this.enginePower = enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Sets current speed if it is positive
     * @param currentSpeed
     */
    public void setCurrentSpeed(double currentSpeed){
        if(currentSpeed >= 0 && currentSpeed <= enginePower)
            this.currentSpeed = currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    /**
     * Sets color of car.
     * @param clr
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts car engine and gives defaul starting speed 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets current speed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    /**
     * Increases current speed
     * @param amount
     */
    public abstract void incrementSpeed(double amount);

    /**
     * Decreases current speed
     * @param amount
     */
    public abstract void decrementSpeed(double amount);

    /**
     * Increments speed by values between 0 and 1
     * @param amount
     */
    public void gas(double amount){
        if(0 <= amount && 1 >= amount)
            amount = Math.min(amount, enginePower - currentSpeed);
            incrementSpeed(amount);
    }

    /**
     * Decreases the speed of car. Accepts value between 0 and 1.
     * Can't make car speed negative or increase speed.
     * @param amount
     */
    public void brake(double amount){
        if(0 <= amount && 1 >= amount)
            amount = Math.min(amount, currentSpeed);
            decrementSpeed(amount);
    }

    /**
     * Changes position according to the current speed in the direction the car is facing.
     */
    public void move() {
        switch (getDir()) {
            case NORTH: position.y -= currentSpeed; break;
            case WEST: position.x -= currentSpeed; break;
            case SOUTH: position.y += currentSpeed; break;
            case EAST: position.x += currentSpeed; break;
        }
    }

    public Point2D.Double getPosition(){
        return position;
    }

    public int getDir(){
        return dir;
    }

    /**
     * Changes the direction to one turn to the left.
     */
    public void turnLeft() {
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
    public void turnRight() {
        switch (dir) {
            case NORTH: dir = EAST; break;
            case WEST: dir = NORTH; break;
            case SOUTH: dir = WEST; break;
            case EAST: dir = SOUTH; break;
        }
    }
}
