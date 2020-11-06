import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        turboOn = false;
    }

    private void setTurboOn(){
        turboOn = true;
    }

    private void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }
    @Override
    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    public static void main(String[] args) {
        Car saab = new Saab95();
        Car volvo = new Volvo240();
        saab.startEngine();
        System.out.println(saab.getEnginePower()+volvo.getEnginePower());
    }
}


