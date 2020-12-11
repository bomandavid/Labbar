package Car;

import java.awt.geom.Point2D;

/**
 * A state that represent the east direction and has the according Movable methods.
 */
public class East implements Movable {

    Car car;

    /**
     *  Takes a car to be acted on.
     * @param car
     */
    public East(Car car){
        this.car = car;
    }

    /**
     * Moves the car to the east.
     */
    @Override
    public void move() {
        car.setPosition(new Point2D.Double(car.getPosition().getX() + car.getCurrentSpeed(), car.getPosition().getY() ));
    }

    /**
     * Turn towards the North
     */
    @Override
    public void turnLeft() {
        car.setDirection(car.getNorthState());
    }
    /**
     * Turn towards the South
     */
    @Override
    public void turnRight() {
        car.setDirection(car.getSouthState());
    }
}
