import java.util.ArrayList;
import java.util.List;

/**
 * Garage with the ability to add and remove cars
 * @param <T> generic type of car
 */
public class Garage <T extends Car> {
    private int capacity;
    private List<T> cars;

    /**
     * Sets the maximium capacity of garage and creates an arraylist
     * @param cap maximum capacity of garage
     */
    public Garage (int cap){
        capacity = cap;
        cars = new ArrayList<>();
    }

    /**
     * Adds car to garage if there is available space
     * @param car Car to be added
     */
    public void add(T car){
        if(cars.size()<capacity)
        cars.add(car);
    }

    /**
     * Removes the the specified car from the ArrayList of garage constituents.
     * @param car Car to be removed.
     */
    public void remove(T car){
        cars.remove(car);
    }

    /**
     * Retuns the ArrayList of garage constituents.
     * @return cars
     */
    public List<T> garageStatus(){
        return cars;
    }
}
