package Car;

/**
 * Interface that represents features of an object that can move.
 */
public interface Movable {

    //enum Direction{NORTH, SOUTH, WEST, EAST}

    void move();
    void turnLeft();
    void turnRight();
}
