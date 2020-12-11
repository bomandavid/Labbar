import Car.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * CarSpeedPanel displays the current speed of the cars in CarModel
 */

public class CarSpeedPanel extends JPanel implements CarObserver {
    CarModel model;
    Map<Car, JLabel> carLabelMap; //connects each car to a unique label

    /**
     * CarSpeedPanel has a preferred size of xSize and ySize
     * @param model Model to listen to
     * @param xSize the x-dimension of the panel
     * @param ySize the y-dimension of the panel
     */
    public CarSpeedPanel(CarModel model, int xSize, int ySize){
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(xSize, ySize));
        this.setBackground(Color.GRAY);
        carLabelMap = new HashMap<>();
        updateSpeedLabels();
    }

    /**
     * Updates the speed labels in the map according to the model
     */
    private void updateSpeedLabels(){
        carLabelMap.clear();
        JLabel speedLabel;
        for(Car c : model.getListOfCars()){
            speedLabel = new JLabel(c.getCarBrand() + " has speed: " + (double)Math.round(c.getCurrentSpeed()*100)/100 + "m/s. ");
            carLabelMap.put(c,speedLabel);
            this.add(speedLabel);
        }
        this.setVisible(true);
    }

    /**
     * Repaints when a car has been moved
     */
    public void actOnCarMoved() {
        repaint();
    }

    /**
     * Updates labels and repaints when the number of cars changes
     */
    public void actOnCarQuantityChange() {
        for(JLabel label : carLabelMap.values()){
            this.remove(label);
        }
        this.setVisible(false);
        updateSpeedLabels();
        repaint();
    }

    /**
     * Updates the text of the displayed labels
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car c : model.getListOfCars()) {
            carLabelMap.get(c).setText(c.getCarBrand() + " has speed: " + (double)Math.round(c.getCurrentSpeed()*100)/100+ "m/s. ");
        }
    }
}
