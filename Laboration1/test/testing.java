import org.junit.jupiter.api.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class testing {
    @Test
    public void testVolvoGas() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(0.5);
    }

    @Test
    public void testSaabSpeedFactor() {
        Saab95 saab = new Saab95();
        saab.setEnginePower(125);
        saab.setTurboOff();
        saab.setTurboOn();
        assertEquals(125 * 0.01 * 1.3, saab.speedFactor());
    }

    @Test
    public void testSetCurrentSpeed() {
        Volvo240 volvo = new Volvo240();
        volvo.setCurrentSpeed(10);
        assertEquals(10, volvo.getCurrentSpeed());
    }

    @Test
    public void testSaabIncrementSpeed() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        double amount = 25;
        saab.incrementSpeed(amount);
        assertEquals(125 * 0.01 * amount + 0.1, saab.getCurrentSpeed());
    }

    @Test
    public void testSaabDecrementSpeed() {
        Saab95 saab = new Saab95();
        saab.setCurrentSpeed(10);
        double amount = 5;
        saab.decrementSpeed(amount);
        assertEquals(10 - 0.01 * 125 * amount, saab.getCurrentSpeed());
    }

    @Test
    public void testVolvoSpeedFactor() {
        Volvo240 volvo = new Volvo240();
        volvo.setEnginePower(200);
        assertEquals(200 * 0.01 * 1.25, volvo.speedFactor());
    }

    @Test
    public void testVolvoIncrementSpeed() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        double amount = 25;
        volvo.incrementSpeed(amount);
        assertEquals(100 * 0.01 * 1.25 * amount + 0.1, volvo.getCurrentSpeed());
    }

    @Test
    public void testVolvoDecrementSpeed() {
        Volvo240 volvo = new Volvo240();
        volvo.setCurrentSpeed(10);
        double amount = 5;
        volvo.decrementSpeed(amount);
        assertEquals(10 - 1.25 * amount, volvo.getCurrentSpeed());
    }

    @Test
    public void testBrake() {
        Volvo240 volvo = new Volvo240();
        volvo.brake(0.5);
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    public void testTurnRight() {
        Car volvo = new Volvo240();
        volvo.turnRight();
        assertEquals(1, volvo.getDir());
    }

    @Test
    public void testTurnLeft() {
        Car volvo = new Volvo240();
        volvo.turnLeft();
        assertEquals(3, volvo.getDir());
    }

    @Test
    public void testNrDoors() {
        Car volvo = new Volvo240();
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void testMove(){
        Car volvo = new Volvo240();
        volvo.setCurrentSpeed(1);
        volvo.move();
        assertEquals(new Point(0,1),volvo.getPosition());
    }

    @Test
    public void testColor(){
        Car volvo = new Volvo240();
        volvo.setColor(Color.blue);
        assertEquals(Color.blue,volvo.getColor());
    }

    @Test
    public void testLoadingAngle(){
        Scania scan = new Scania();
        scan.increaseLoadingAngle(10);
        scan.decreaseLoadingAngle(-15);
        assertEquals(0,scan.getLoadingAngle());
    }

    @Test
    public void testChangeAngleWhileMoving(){
        Scania scan = new Scania();
        scan.startEngine();
        scan.increaseLoadingAngle(10);
        assertEquals(0,scan.getLoadingAngle());
    }

    @Test
    void testLoadCar() {
        Saab95 saab = new Saab95();
        CarHauler hauler =  new CarHauler(5);
        hauler.loadCar(saab);
        hauler.unloadCar();
    }

    @Test
    void testMoveCarHauler(){
        Saab95 saab = new Saab95();
        CarHauler hauler =  new CarHauler(5);
        hauler.setRampDown();
        hauler.loadCar(saab);
        hauler.setRampUp();
        hauler.startEngine();
        hauler.setCurrentSpeed(100);
        hauler.move();
        assertEquals(100, saab.getPosition().y);

    }

    @Test
    public void testSetSpeedCarHauler(){
        CarHauler hauler = new CarHauler(5);

    }

    @Test
    void testUnloadedCarPosition(){
        Saab95 saab = new Saab95();
        saab.turnLeft();
        CarHauler hauler =  new CarHauler(5);
        hauler.setRampDown();
        hauler.loadCar(saab);
        hauler.setRampUp();
        hauler.startEngine();
        hauler.setCurrentSpeed(100);
        hauler.turnRight();
        hauler.move();
        hauler.setCurrentSpeed(0);
        hauler.setRampDown();
        hauler.unloadCar();
        assertEquals(99, saab.getPosition().x);
    }

    @Test
    void testCarGarage(){
        Garage<Car> garage = new Garage<>(1);
        garage.add(new Saab95());
        garage.add(new Volvo240());
        assertEquals(1, garage.garageStatus().size());
    }

    @Test
    void testVolvoGarageRemove(){
        Volvo240 volvo = new Volvo240();
        Garage<Volvo240> garage = new Garage<>(2);
        garage.add(volvo);
        garage.remove(volvo);
        assertEquals(0,garage.garageStatus().size());
    }

    @Test
    void testCarHauler2(){
        Saab95 saab = new Saab95();
        saab.turnLeft();
        CarHauler2 hauler =  new CarHauler2();
        hauler.setRampDown();
        hauler.loadCar(saab);
        hauler.setRampUp();
        hauler.startEngine();
        hauler.setCurrentSpeed(100);
        hauler.turnRight();
        hauler.move();
        hauler.setCurrentSpeed(0);
        hauler.setRampDown();
        hauler.unloadCar();
        assertEquals(99, saab.getPosition().x);
    }
}