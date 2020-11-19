import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Stack;

public class CarHauler2{

    private final int maxNumberCars = 5;
    private Stack<Car> stack;
    private Scania hasAScania;

    public CarHauler2() {
        hasAScania = new Scania();
        stack = new Stack<>();
    }

    public double speedFactor() { return hasAScania.speedFactor(); }

    public void rampUp(){hasAScania.decreaseLoadingAngle(70); }

    public void rampDown(){ hasAScania.increaseLoadingAngle(70); }

    public void setCurrentSpeed(double amount) { hasAScania.setCurrentSpeed(amount); }

    public void move(){
        hasAScania.move();
        for (Car car : stack) {
            car.setPosition(getPosition());
        }
    }

    public Point2D.Double getPosition(){ return hasAScania.getPosition(); }

    public double getLoadingAngle(){
        return hasAScania.getLoadingAngle();
    }

    public static void main(String[] arg){
        CarHauler2 hauler = new CarHauler2();
        hauler.rampDown();
    }

    public void increaseLoadingAngle(double amount) {
        hasAScania.increaseLoadingAngle(amount);
    }

    public void decreaseLoadingAngle(double amount) {
        hasAScania.decreaseLoadingAngle(amount);
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

    public int getDir() {
        return hasAScania.getDir();
    }

    public void setDir(int dir) {
        hasAScania.setDir(dir);
    }

    public void turnLeft() {
        hasAScania.turnLeft();
    }

    public void turnRight() {
        hasAScania.turnRight();
    }
}
