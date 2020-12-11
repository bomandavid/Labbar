package Car;
import java.util.ArrayList;


public class CarModel {

    private ArrayList<Car> listOfCars; //cars in the model
    private ArrayList<CarObserver> observers = new ArrayList<>(); //listeners of the model
    private CarFactory factory = new CarFactory();

    /**
     * CarModel creates a Saab, a Scania and a Volvo
     */
    public CarModel(){
        this.listOfCars = new ArrayList<>();
        listOfCars.add(factory.createSaab95());
        listOfCars.add(factory.createScania());
        listOfCars.add(factory.createVolvo240());
    }

    /**
     * Adds car to the model
     * @param car
     */
    public void addCar(Car car){
        listOfCars.add(car);
    }

    /**
     * @pre listOfCars.size() < 10
     * Adds a random car to the model
     */
    public void addRandomCar(){
        if(listOfCars.size()<10) {
            listOfCars.add(factory.createRandomCar());
            notifyObserverOnQuantityChange();
        }
    }

    /**
     * @pre listOfCars.size() > 0
     * Removes a car choosen randomly
     */
    public void removeCar(){
        if(listOfCars.size() > 0) {
            listOfCars.remove(listOfCars.remove(listOfCars.size() - 1));
            notifyObserverOnQuantityChange();
        }
    }

    /**
     * @return arraylist of cars
     */
    public ArrayList<Car> getListOfCars(){
        return this.listOfCars;
    }

    /**
     * Calls gas for all cars
     * @param amount
     */
    public void gas(int amount) {
        double amt = ((double) amount) / 100;
        for (Car car : listOfCars) {
            car.gas(amt);
        }
    }

    /**
     * Calls brake for all cars
     * @param amount
     */
    public void brake(int amount) {
        double amt = ((double) amount) / 100;
        for (Car car : listOfCars) {
            car.brake(amt);
        }
    }

    /**
     * Turns on turbo for all cars which implements Turbo
     */
    public void turboOn(){
        for(Car car : listOfCars){
            if(car instanceof Turbo)
                ((Turbo) car).setTurboOn();
        }
    }

    /**
     * Turns off turbo for all cars which implements Turbo
     */
    public void turboOff(){
        for(Car car : listOfCars){
            if(car instanceof Turbo)
                ((Turbo) car).setTurboOff();
        }
    }

    /**
     * Lowers flatbed for all cars which implement FlatBed
     */
    public void lowerBed(){
        for(Car car : listOfCars){
            if(car instanceof FlatBed)
                ((FlatBed) car).decreaseLoadingAngle(70);
        }
    }

    /**
     * Lifts flatbed for all cars which implement FlatBed
     */
    public void liftBed(){
        for(Car car : listOfCars){
            if(car instanceof FlatBed)
                ((FlatBed) car).increaseLoadingAngle(70);
        }
    }

    /**
     * Starts the engine of all cars
     */
    public void startEngine(){
        for(Car car : listOfCars){
            car.startEngine();
        }
    }

    /**
     * Stops the engine of all cars
     */
    public void stopEngine(){
        for(Car car : listOfCars){
            car.stopEngine();
        }

    }

    /**
     * Notifies observers when the cars move.
     */
    public void notifyObserversOnCarMove(){
        for (CarObserver obs : observers) {
            obs.actOnCarMoved();
        }
    }

    /**
     * Notifies observers when the amount of cars in the model has changes.
     */
    public void notifyObserverOnQuantityChange(){
        for (CarObserver l : observers) {
            l.actOnCarQuantityChange();
        }
    }

    /**
     * Adds osberver to the arrayList of observers.
     * @param obs observer
     */
    public void addObserver(CarObserver obs){
        observers.add(obs);}

}
