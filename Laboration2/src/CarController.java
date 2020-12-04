import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;

    // A list of cars, modify if needed
    private ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());
        cc.cars.add(new Saab95());
        cc.cars.add(new Saab95());

        //cc.cars.get(1).setPosition(new Point2D.Double(100,0));
       // cc.cars.get(2).setPosition(new Point2D.Double(0,0));
        //cc.cars.get(3).setPosition((new Point2D.Double(400,0)));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.setCarPositions();

        cc.frame.drawPanel.addCars(cc.cars);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if(canMove(car)) {
                    //moveCarAndPicture(car);
                    car.move();
                    frame.drawPanel.repaint();
                }
                else{
                    car.stopEngine();
                    car.invertDir();
                    //car.turnLeft();
                    System.out.println("Turning");
                    car.startEngine();
                }
            }
        }
    }

    public boolean canMove(Car car){
        double x = car.getPosition().getX();
        double y = car.getPosition().getY();
        Point2D.Double testPoint = new Point2D.Double();
        switch(car.getDir()){
            case Car.NORTH : testPoint = new Point2D.Double(x, y - car.getCurrentSpeed()); break;
            case Car.SOUTH : testPoint = new Point2D.Double(x, y + car.getCurrentSpeed()); break;
            case Car.EAST : testPoint = new Point2D.Double(x + car.getCurrentSpeed(), y); break;
            case Car.WEST : testPoint = new Point2D.Double(x - car.getCurrentSpeed(), y ); break;
        }
        if(isOutOfBounds(testPoint))
            return false;
        return true;
    }

    public boolean isOutOfBounds(Point2D.Double testPoint){
        double x = testPoint.getX();
        double y = testPoint.getY();
        if(y < 0 || x < 0 || x > frame.getX()-100 || y > frame.getY() - 300) {
            return true;
        }
        return false;
    }

    /*
    public void moveCar(Car car){
        car.move();
       // int x = (int) Math.round(car.getPosition().getX());
       // int y = (int) Math.round(car.getPosition().getY());
       // frame.drawPanel.moveit(x, y, car);
        frame.drawPanel.repaint();
    }
    */

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turboOn(){
        for(Car car : cars){
            if(car instanceof Turbo)
                ((Saab95) car).setTurboOn();
        }
    }

    void turboOff(){
        for(Car car : cars){
            if(car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    void lowerBed(){
        for(Car car : cars){
            if(car instanceof Scania)
                ((Scania) car).decreaseLoadingAngle(70);
        }
    }

    void liftBed(){
        for(Car car : cars){
            if(car instanceof Scania)
                ((Scania) car).increaseLoadingAngle(70);
        }
    }

    void startEngine(){
        for(Car car : cars){
            car.startEngine();
        }
    }

    void stopEngine(){
        for(Car car : cars){
            car.stopEngine();
        }
    }

    void setCarPositions(){
        int x = 0;
        int y = 0;
        for(Car c : cars){
            c.setPosition(new Point2D.Double(x, y));
            x += 200;
            if(x > frame.getX() - 100) {
                x = 0;
                y += 200;
            }
        }
    }
}
