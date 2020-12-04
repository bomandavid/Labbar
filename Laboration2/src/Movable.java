public interface Movable {

    enum direction{NORTH, SOUTH, WEST, EAST}

    void move();
    void turnLeft();
    void turnRight();
}
