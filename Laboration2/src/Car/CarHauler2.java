package Car;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Stack;

class CarHauler2 implements Movable {
    private final int capacity = 5;
    private Stack<Car> cars;
    private Scania hasAScania;

    public CarHauler2() {
        hasAScania = new Scania();
        cars = new Stack<>();
        setNrDoors(2);
        setColor(Color.blue);
        setEnginePower(400);
        setSize(2);
    }

    public double speedFactor() {
        return hasAScania.speedFactor();
    }

    public void setRampUp(){
        hasAScania.decreaseLoadingAngle(70);
    }

    public void setRampDown(){
        hasAScania.increaseLoadingAngle(70);
    }

    public void setCurrentSpeed(double amount) {
        hasAScania.setCurrentSpeed(amount);
    }

    // Uncomment this, commented for experminetal purpose
    /*
    public void loadCar(Car car){
        if (cars.size() < capacity && hasAScania.getLoadingAngle() == 70 && car.getSize() < 2 && getPosition().distance(car.getPosition()) < 4) {
            car.setPosition(getPosition());
            cars.push(car);
        }
        car.setDir(hasAScania.getDir());
    }

    public void unloadCar(){
        if (hasAScania.getLoadingAngle() == 70) {
            Car car = cars.pop();
            switch (getDir()) {
                case NORTH: car.setPosition(new Point2D.Double(getPosition().x, getPosition().y + 1)); break;
                case WEST: car.setPosition(new Point2D.Double(getPosition().x + 1, getPosition().y)); break;
                case SOUTH: car.setPosition(new Point2D.Double(getPosition().x, getPosition().y - 1)); break;
                case EAST: car.setPosition(new Point2D.Double(getPosition().x - 1, getPosition().y)); break;
            }
        }
    }
     */

    public void move(){
        hasAScania.move();
        for (Car car : cars) {
            car.setPosition(getPosition());
        }
    }
    public void turnLeft() {
        hasAScania.turnLeft();
        for (Car car : cars) {
            car.turnLeft();
        }
    }

    public void turnRight() {
        hasAScania.turnRight();
        for (Car car : cars) {
            car.turnRight();
        }
    }

    public Point2D.Double getPosition(){
        return hasAScania.getPosition();
    }

    public double getLoadingAngle(){
        return hasAScania.getLoadingAngle();
    }

    public void setSize(int Size) {
        hasAScania.setSize(Size);
    }

    public int getSize() {
        return hasAScania.getSize();
    }

    public void setNrDoors(int nrDoors) {
        hasAScania.setNrDoors(nrDoors);
    }

    public int getNrDoors() {
        return hasAScania.getNrDoors();
    }

    public double getEnginePower() {
        return hasAScania.getEnginePower();
    }

    public void setEnginePower(int enginePower) {
        hasAScania.setEnginePower(enginePower);
    }

    public double getCurrentSpeed() {
        return hasAScania.getCurrentSpeed();
    }

    public Color getColor() {
        return hasAScania.getColor();
    }

    public void setColor(Color clr) {
        hasAScania.setColor(clr);
    }

    public void startEngine() {
        hasAScania.startEngine();
    }

    public void stopEngine() {
        hasAScania.stopEngine();
    }

    public void incrementSpeed(double amount) {
        hasAScania.incrementSpeed(amount);
    }

    public void decrementSpeed(double amount) {
        hasAScania.decrementSpeed(amount);
    }

    public void gas(double amount) {
        hasAScania.gas(amount);
    }

    public void brake(double amount) {
        hasAScania.brake(amount);
    }

    public void setPosition(Point2D.Double point) {
        hasAScania.setPosition(point);
    }

    // Uncomment this, commented for experminetal purpose
    /*
    public Direction getDir() {
        return hasAScania.getDir();
    }

    public void setDir(Direction dir) {
        hasAScania.setDir(dir);
    }
    */


}
