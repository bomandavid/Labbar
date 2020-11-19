import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Stack;


public class CarHauler extends Car {
    private boolean rampUp;
    private final int maxNumberCars = 5;
    private Stack<Car> cars;

    /**
     * Sets number of doors, color, Engine power, size and if ramp is up or down. Also initiates a stack.
     */
    public CarHauler() {
        setNrDoors(2);
        setColor(Color.blue);
        setEnginePower(400);
        setSize(2);
        rampUp = true;
        cars = new Stack<>();
    }

    /**
     * Returns a standard speed factor.
     * @return the speed factor of the Hauler.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.05;
    }

    /**
     * Adds car to the stack if there is space on the car hauler, the ramp is up and the car is close to the car hauler
     * @param car Car to be loaded
     */
    public void loadCar(Car car) {
        if (cars.size() < maxNumberCars && !rampUp && car.getSize() < 2 && getPosition().distance(car.getPosition()) < 4) {
            car.setPosition(getPosition());
            cars.push(car);
        }
        car.setDir(getDir());
    }

    /**
     * Unloads the most recently loaded car 1 unit of length behind the hauler.
     */
    public void unloadCar() {
        if (!rampUp) {
            Car car = cars.pop();
            switch (getDir()) {
                case NORTH: car.setPosition(new Point2D.Double(getPosition().x, getPosition().y + 1)); break;
                case WEST: car.setPosition(new Point2D.Double(getPosition().x + 1, getPosition().y)); break;
                case SOUTH: car.setPosition(new Point2D.Double(getPosition().x, getPosition().y - 1)); break;
                case EAST: car.setPosition(new Point2D.Double(getPosition().x - 1, getPosition().y)); break;
             }
        }
    }

    /**
     * Sets ramp to state "up"
     */
    public void setRampUp(){
        rampUp=true;
    }

    /**
     * Ramp is lowered only if hauler is stationary.
     */
    public void setRampDown(){
        if(getCurrentSpeed()==0)
            rampUp = false;
    }

    /**
     * Car objects on hauler get same position as hauler.
     */
    @Override
    public void move() {
        super.move();
        for (Car car : cars) {
            car.setPosition(getPosition());
        }
    }

    /**
     * Car object turns right when hauler turns right.
     */
    @Override
    public void turnRight(){
        super.turnRight();
        for (Car car : cars) {
            car.turnRight();
        }
    }

    /**
     * Car object turns left when hauler turns left.
     */
    @Override
    public void turnLeft(){
        super.turnLeft();
        for (Car car : cars) {
            car.turnLeft();
        }
    }

    /**
     * Ensures hauler can only set a speed if the ramp is up.
     * @param amount
     */
    @Override
    public void setCurrentSpeed(double amount) {
        if (rampUp)
            super.setCurrentSpeed(amount);
    }
}
