import java.util.*;

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
     * Adds car to garage if there is space
     * @param car Car to be added
     */
    public void add(T car){
        if(cars.size()<capacity)
        cars.add(car);
    }

    /**
     *
     * @param car
     */
    public void remove(T car){ //Hur får vi ut en subtyp
        cars.remove(car);
    }

    public static void main(String[] args) {
        Garage<Car> repair = new Garage<>(5);
        Saab95 saab = new Saab95();
        repair.add(saab);
    }
}
