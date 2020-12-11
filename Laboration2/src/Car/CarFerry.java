package Car;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.PriorityQueue;
import java.util.Queue;

public class CarFerry implements Movable {
    private Queue<Car> cars;
    private CarHauler hasACarHauler;

    public CarFerry(int capacity){
        hasACarHauler = new CarHauler(capacity);
        setColor(Color.blue);
        setEnginePower(5000);
        setSize(2);
        cars = new PriorityQueue<Car>(capacity);
    }

    public double speedFactor() {
        return getEnginePower() * 0.001;
    }

    // Uncomment this, commented for experminetal purpose
    /*
    public void loadCar(Car car) {
        hasACarHauler.loadCar(car);
        cars.add(car);
    }

     */

    // Uncomment this, commented for experminetal purpose
    /*
    public void unloadCar() {
        hasACarHauler.unloadCar();
        Car car = cars.poll();
        switch (getDir()) {
            case NORTH: car.setPosition(new Point2D.Double(getPosition().x, getPosition().y - 1)); break;
            case WEST: car.setPosition(new Point2D.Double(getPosition().x - 1, getPosition().y)); break;
            case SOUTH: car.setPosition(new Point2D.Double(getPosition().x, getPosition().y + 1)); break;
            case EAST: car.setPosition(new Point2D.Double(getPosition().x + 1, getPosition().y)); break;
        }
    }

     */

    public void setRampUp() {
        hasACarHauler.setRampUp();
    }

    public void setRampDown() {
        hasACarHauler.setRampDown();
    }

    public void move() {
        hasACarHauler.move();
    }

    public void turnRight() {
        hasACarHauler.turnRight();
    }

    public void turnLeft() {
        hasACarHauler.turnLeft();
    }

    public void setCurrentSpeed(double amount) {
        hasACarHauler.setCurrentSpeed(amount);
    }

    public void setSize(int size) {
        hasACarHauler.setSize(size);
    }

    public int getSize() {
        return hasACarHauler.getSize();
    }

    public double getEnginePower() {
        return hasACarHauler.getEnginePower();
    }

    public void setEnginePower(int enginePower) {
        hasACarHauler.setEnginePower(enginePower);
    }

    public double getCurrentSpeed() {
        return hasACarHauler.getCurrentSpeed();
    }

    public Color getColor() {
        return hasACarHauler.getColor();
    }

    public void setColor(Color clr) {
        hasACarHauler.setColor(clr);
    }

    public void startEngine() {
        hasACarHauler.startEngine();
    }

    public void stopEngine() {
        hasACarHauler.stopEngine();
    }

    public void incrementSpeed(double amount) {
        hasACarHauler.incrementSpeed(amount);
    }

    public void decrementSpeed(double amount) {
        hasACarHauler.decrementSpeed(amount);
    }

    public void gas(double amount) {
        hasACarHauler.gas(amount);
    }

    public void brake(double amount) {
        hasACarHauler.brake(amount);
    }

    public Point2D.Double getPosition() {
        return hasACarHauler.getPosition();
    }

    public void setPosition(Point2D.Double point) {
        hasACarHauler.setPosition(point);
    }

    // Uncomment this, commented for experminetal purpose
    /*
    public Direction getDir() {
        return hasACarHauler.getDir();
    }

    public void setDir(Direction dir) {
        hasACarHauler.setDir(dir);
    }
     */
}
