import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Stack;

public class CarHauler extends Car { //rätt att extenda car?  delegera till scania? Kan lasta Scania och andra CarHauler???

    private boolean rampUp;
    private final int maxNumberCars = 5;
    private Stack<Car> stack;

    public CarHauler() {
        setNrDoors(2);
        setColor(Color.blue);
        setEnginePower(400);
        setSize(2);
        rampUp = true;
        stack = new Stack<>();
    }

    @Override
    public double speedFactor() {//Kan vi använda koden från scania på något sätt
        return getEnginePower() * 0.05;
    }

    public void loadCar(Car car) {
        if (stack.size() < maxNumberCars && !rampUp && car.getSize() < 2 && getPosition().distance(car.getPosition()) < 4) {
            car.setPosition(getPosition());
            stack.push(car);
        }
    }

    public void unloadCar() {
        if (!rampUp) {
            Car car = stack.pop();
        }
    }

    public void rampUp(){
        rampUp=true;
    }

    public void rampDown(){
        rampUp = false;
    }

    @Override
    public void move() {
        double x = getPosition().x;
        double y = getPosition().y;
        switch (getDir()) {
            case NORTH:
                y += getCurrentSpeed();
                break;
            case WEST:
                x -= getCurrentSpeed();
                break;
            case SOUTH:
                y -= getCurrentSpeed();
                break;
            case EAST:
                x += getCurrentSpeed();
                break;
        }
        Point2D.Double point = new Point2D.Double(x, y);
        setPosition(point);

        for (Car car : stack) {
            car.setPosition(point);
        }
    }

    @Override
    public void setCurrentSpeed(double amount) {
        if (rampUp)
            super.setCurrentSpeed(amount);
    }

    public static void main(String[] args){
        CarHauler hauler =  new CarHauler();
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        hauler.rampDown();
        hauler.loadCar(saab);
        hauler.loadCar(volvo);
        hauler.rampUp();
        hauler.startEngine();
        hauler.setCurrentSpeed(100);
        hauler.move();
    }
}
