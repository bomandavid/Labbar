package Car;

import java.awt.geom.Point2D;
/**
 * A state that represent the South direction and has the according Movable methods.
 */
class South implements Movable {

    Car car;
    /**
     *  Takes a car to be acted on.
     * @param car
     */
    public South(Car car){
        this.car = car;
    }
    /**
     * Moves the car to the south.
     */
    @Override
    public void move() {
        car.setPosition(new Point2D.Double(car.getPosition().getX(), car.getPosition().getY() + car.getCurrentSpeed()));
    }
    /**
     * Turn towards the East
     */
    @Override
    public void turnLeft() {
        car.setDirection(car.getEastState());
    }
    /**
     * Turn towards the West
     */
    @Override
    public void turnRight() {
        car.setDirection(car.getWestState());
    }
}
