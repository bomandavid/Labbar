import Car.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

/**
* This class represents the Controller part in the MVC pattern.
* It's responsibilities are to listen to get input from actionsListener in the View and responds in a appropriate manner by
* sending update signals to the model.
 */

public class CarController {
    private final int frameX;
    private final int frameY;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarModel model;

    /**
     * Takes a model as a parameter as well as dimensions of frame.
     * Sets the cars in the model on initial positions so they're not stacked on eachother.
     * @param model the model to be used
     * @param x the x dimention of frame.
     * @param y the y dimenstion of frame.
     */
    public CarController(CarModel model, int x, int y){
        this.model = model;
        this.frameX = x;
        this.frameY = y;
        setInitialPositions();
        timer.start();
    }

    /**
     * Each step the TimerListener moves all the cars in the list notifes the observers.
     * If the cars can't move, they invert direction and moves back.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : model.getListOfCars()) {
                if(canMove(car)) {
                    car.move();
                    model.notifyObserversOnCarMove();
                }
                else{
                    car.stopEngine();
                    car.invertDir();
                    car.startEngine();
                }
            }
        }
    }

    /**
     * Checks if a point is out of frame.
     * @param testcar a car to check if it is out of frme.
     * @return true if out of frame.
     */
    public boolean isOOB(Car testcar){
        double x = testcar.getPosition().getX();
        double y = testcar.getPosition().getY();
        if(y < 0 || x < 0 || x > frameX-100 || y > frameY - 340) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the move is valid. Returns false if a move results out of frame.
     * @param car
     * @return true is move is valid.
     */
    public boolean canMove(Car car){
        car.move();
        if(isOOB(car)) {
            car.invertDir();
            car.move();
            car.invertDir();
            return false;
        }

        car.invertDir();
        car.move();
        car.invertDir();
        return true;
    }

    /*
    public boolean isOutOfBounds(Point2D.Double testPoint){
        double x = testPoint.getX();
        double y = testPoint.getY();
        if(y < 0 || x < 0 || x > frameX-100 || y > frameY - 340) {
            return true;
        }
        return false;
    }
     */

    /**
     * Calls the gas method in the car model.
     * @param amount gas amount.
     */
    void gas(int amount) {
        model.gas(amount);
    }

    /**
     * Calls the brake method in the model.
     * @param amount brake amount.
     */
    void brake(int amount) {
        model.brake(amount);
    }

    /**
     * Calls turboOn method in the model.
     */
    void turboOn(){
        model.turboOn();
    }

    /**
     * Calls turboOff method in the model.
     */
    void turboOff(){
        model.turboOff();
    }

    /**
     * Calls the lowerBed method in the model.
     */
    void lowerBed(){
        model.lowerBed();
    }

    /**
     * Calls the liftBed method in the model.
     */
    void liftBed(){
        model.liftBed();
    }

    /**
     * Calls the startEngine method in the model.
     */
    void startEngine(){
        model.startEngine();
    }

    /**
     * Calls the stopEngine method in the model.
     */
    void stopEngine(){
        model.stopEngine();
    }

    /**
     * Calls the addRandomCar method in the model.
     */
    void addRandomCar(){
        model.addRandomCar();
    }

    /**
     * Calls the removeCar method in the model.
     */
    void removeCar(){ model.removeCar();

    }

    /**
     * Sets initial positions of the cars in the initial state of the model 100 pixels apart in line.
     * Starts a new row if cars would end up out of frame.
     */
    void setInitialPositions(){
        int x = 0;
        int y = 0;
        int xDist = 200;
        for(Car c : model.getListOfCars()){
            c.setPosition(new Point2D.Double(x, y));
            x += xDist;
            if(x > this.frameX - xDist) {
                x = 0;
                y += 200;
            }
        }
    }
}
