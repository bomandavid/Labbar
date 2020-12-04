import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel2 extends JPanel{

    private ArrayList<Car> elements = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel2(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
    }

    public void addCars(ArrayList<Car> c){
        this.elements = c;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Car c : elements){
            try {
                BufferedImage image = ImageIO.read(DrawPanel2.class.getResourceAsStream(c.getImage()));
                g.drawImage(image, (int) c.getPosition().getX(), (int) c.getPosition().getY(), null);
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}

