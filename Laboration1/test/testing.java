import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class testing {

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
    public void test(){
        Car saab = new Saab95();
        saab.startEngine();
        saab.turnLeft();
        saab.move();
        saab.getDir();
        saab.turnRight();
    }

    @Test
    public void testNrDoors(){
        Car volvo = new Volvo240();
        assertEquals(4, volvo.getNrDoors());
    }
    @Test
    public void testDir(){
        Car volvo = new Volvo240();
        volvo.turnRight();
        assertEquals(1, volvo.getDir());
    }

    @Test
    public void testGas() {

    }
}
