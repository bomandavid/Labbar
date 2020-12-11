package Car;

import java.awt.geom.Point2D;
/**
 * A state that represent the North direction and has the according Movable methods.
 */
public class North implements Movable {

    Car car;
    /**
     *  Takes a car to be acted on.
     * @param car
     */
    public North(Car car){
        this.car = car;
    }
    /**
     * Moves the car to the north.
     */
    @Override
    public void move() {
        car.setPosition(new Point2D.Double(car.getPosition().getX(), car.getPosition().getY() - car.getCurrentSpeed()));
    }
    /**
     * Turn towards the West
     */
    @Override
    public void turnLeft() {
        car.setDirection(car.getWestState());
    }
    /**
     * Turn towards the East
     */
    @Override
    public void turnRight() {
        car.setDirection(car.getEastState());
    }
}
