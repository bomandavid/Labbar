import Car.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

/**
 *<p>
 *     The DrawPanel class is a JPanel that represents the visual display of the cars moving in the CarModel.
 *     It implements CarObserver and updates when changes happen in the model.
 *</p>
 */

public class DrawPanel extends JPanel implements CarObserver {

    CarModel model;

    /**
     *
     * <p>
     *     Takes an x and y value to set the desired dimensions of panel.
     *      It also takes the model it should represent.
     * </p>
     * @param x the width of the panel
     * @param y the height of the panel
     * @param model the model it should represent
     */
    public DrawPanel(int x, int y, CarModel model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
        this.model = model;
    }

    /**
     * Repaints the panel when the car(s) has moved.
     */
    public void actOnCarMoved() {
        repaint();
    }

    /**
     * Repaints when cars are added or removed.
     */
    public void actOnCarQuantityChange(){
        repaint();
    }

    /**
     * Paints the objects present in the model at their current position.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        ArrayList<Car> listOfCars = model.getListOfCars();
        super.paintComponent(g);
        for (Car c : listOfCars) {
            try {
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(c.getImage()));
                g.drawImage(image, (int) c.getPosition().getX(), (int) c.getPosition().getY(), null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}



