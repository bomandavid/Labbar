package Car;

import java.awt.geom.Point2D;
/**
 * A state that represent the west direction and has the according Movable methods.
 */
class West implements Movable {

    Car car;
    /**
     *  Takes a car to be acted on.
     * @param car
     */
    public West(Car car){
        this.car = car;
    }
    /**
     * Moves the car to the west.
     */
    @Override
    public void move() {
        car.setPosition(new Point2D.Double(car.getPosition().getX() - car.getCurrentSpeed(), car.getPosition().getY()));
    }
    /**
     * Turn towards the South
     */
    @Override
    public void turnLeft() {
        car.setDirection(car.getSouthState());
    }
    /**
     * Turn towards the North
     */
    @Override
    public void turnRight() {
        car.setDirection(car.getNorthState());
    }
}
