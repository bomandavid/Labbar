package Car;

/**
 * A Factory class that can create each car
 */
public class CarFactory {
    /**
     * Creates a Saab95
     * @return new Saab95
     */
    public Saab95 createSaab95(){
        return new Saab95();
    }
    /**
     * Creates a Volvo240
     * @return new Volvo240
     */
    public Volvo240 createVolvo240(){
        return new Volvo240();
    }
    /**
     * Creates a Scania
     * @return new Scania
     */
    public Scania createScania(){
        return new Scania();
    }
    /**
     * Creates a CarHauler
     * @return new CarHauler
     */
    public CarHauler createCarHauler(int capacity){
        return new CarHauler(capacity);
    }
    /**
     * Creates a Random Car
     * @return new Object that is a subclass to Car
     */
    public Car createRandomCar(){
        Car[] testList = {createScania(), createSaab95(), createVolvo240()};
        return testList[(int) (testList.length*Math.random())];
    }
}