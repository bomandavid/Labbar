import org.junit.Before;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class testing {
    @Before
    public void beforeT(){
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
    }

    @Test
    public void testVolvoGas() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(0.5);
    }

    @Test
    public void testSaabTurbo() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.gas(0.5);
    }

    @Test
    public void testSaabSpeedFactor(){
        Saab95 saab = new Saab95();
        saab.setEnginePower(125);
        saab.setTurboOn();
        assertEquals(125*0.01*1.3,saab.speedFactor());
    }

    @Test
    public void testSaabIncrementSpeed(){
        Saab95 saab = new Saab95();
        saab.startEngine();
        double amount = 25;
        saab.incrementSpeed(amount);
        assertEquals(125*0.01*amount+0.1,saab.getCurrentSpeed());
    }

    @Test
    public void testSaabDecrementSpeed(){
        Saab95 saab = new Saab95();
        saab.setCurrentSpeed(10);
        double amount = 5;
        saab.decrementSpeed(amount);
        assertEquals(10-0.01*125*amount,saab.getCurrentSpeed());
    }

    @Test
    public void testVolvoSpeedFactor(){
        Volvo240 volvo = new Volvo240();
        volvo.setEnginePower(200);
        assertEquals(200*0.01*1.25,volvo.speedFactor());
    }

    @Test
    public void testVolvoIncrementSpeed(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        double amount = 25;
        volvo.incrementSpeed(amount);
        assertEquals(100*0.01*1.25*amount+0.1,volvo.getCurrentSpeed());
    }

    @Test
    public void testVolvoDecrementSpeed(){
        Volvo240 volvo = new Volvo240();
        volvo.setCurrentSpeed(10);
        double amount = 5;
        volvo.decrementSpeed(amount);
        assertEquals(10-1.25*amount,volvo.getCurrentSpeed());
    }

    @Test
    public void testSetCurrentSpeed(){

    }

    @Test
    public void testBrake(){

    }

    @Test
    public void testMove(){}

    @Test
    public void testTurnRight(){
        Car volvo = new Volvo240();
        volvo.turnRight();
        assertEquals(1, volvo.getDir());
    }

    @Test
    public void testTurnLeft(){
    }

    /*
    @Test
    public void test(){
        Car saab = new Saab95();
        saab.startEngine();
        saab.turnLeft();
        saab.move();
        saab.getDir();
        saab.turnRight();
    }
    */

    @Test
    public void testNrDoors(){
        Car volvo = new Volvo240();
        assertEquals(4, volvo.getNrDoors());
    }


}
