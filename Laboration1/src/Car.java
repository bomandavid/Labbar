import java.awt.*;
import java.awt.geom.Point2D;

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

    public Car(){
        position = new Point2D.Double(0.0,0.0); //default position?
        stopEngine();
    }

    public void setNrDoors(int nrDoors){
        this.nrDoors = nrDoors;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public void setEnginePower(int enginePower){
        this.enginePower = enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public abstract double speedFactor();
    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
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

    public void turnLeft() {
        switch (dir) {
            case NORTH: dir = WEST; break;
            case WEST: dir = SOUTH; break;
            case SOUTH: dir = EAST; break;
            case EAST: dir = NORTH; break;
        }
    }

    public void turnRight() {
        switch (dir) {
            case NORTH: dir = EAST; break;
            case WEST: dir = NORTH; break;
            case SOUTH: dir = WEST; break;
            case EAST: dir = SOUTH; break;
        }
    }
}
