import org.junit.jupiter.api.Test;

public class testing {
    @Test
    public void testCreateCar() {
        Car volvo = new Volvo240();
    }

    @Test
    public void testCarMove(){
        Car saab = new Saab95();
        saab.startEngine();
        saab.turnLeft();
        saab.move();
        saab.getDir();
        saab.turnRight();
    }
}
