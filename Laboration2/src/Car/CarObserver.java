package Car;

/**
 * This interface is used to observe changes in CarModel
 */
public interface CarObserver {
    /**
     * Act on movement
     */
    void actOnCarMoved();

    /**
     * Acts on change in the number of cars.
     */
    void actOnCarQuantityChange();
}
