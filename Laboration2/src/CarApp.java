import Car.*;

public class CarApp {

    public static void main(String[] args) {
        int frameX = 1200; int frameY = 800;
        CarModel model = new CarModel();

        CarController controller = new CarController(model, frameX, frameY);
        CarView view = new CarView("CarSim", controller, frameX, frameY);

        DrawPanel drawPanel = new DrawPanel(view.getX(),view.getY()-300, model);
        CarSpeedPanel speedPanel = new CarSpeedPanel(model, frameX, 200);

        model.addObserver(drawPanel);
        model.addObserver(speedPanel);

        view.add(drawPanel);
        view.add(speedPanel);

    }
}
