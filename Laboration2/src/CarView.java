import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{
    private int X;
    private int Y;

    // The controller member
    CarController carC;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Turbo on");
    JButton turboOffButton = new JButton("Turbo off");
    JButton liftBedButton = new JButton("Lift Bed");
    JButton lowerBedButton = new JButton("Lower Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    JButton addCarButton = new JButton("Add new random car");
    JButton removeCarButton = new JButton("Remove random car");

    /**
     * Takes an X and Y to create the CarView with desired dimensions.
     * Also takes a string for its name and a CarController.
     * @param framename
     * @param carC
     * @param X
     * @param Y
     */
    public CarView(String framename, CarController carC, final int X, final int Y){
        this.carC = carC;
        this.X = X;
        this.Y = Y;
        initComponents(framename);
    }

    /**
     * Getter for Y
     * @return Y
     */
    public int getY(){return Y;}

    /**
     * Getter for X
     * @return X
     */
    public int getX(){return X;}

    /**
     * Method to initialize the all the elements of the frame.
     * @param  title of the frame
     */
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,5));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.gas is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.brake is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.startEngine is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.startEngine();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.stopEngine is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.stopEngine();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.turboOn is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.turboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.turboOff is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.turboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.liftBed is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.liftBed();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.lowerBed is performed.
             */
            public void actionPerformed(ActionEvent e) {carC.lowerBed();
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override/**
             * When triggered, carC.addRandomCar is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.addRandomCar();
            }
        });

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            /**
             * When triggered, carC.removeCar is performed.
             */
            public void actionPerformed(ActionEvent e) {
                carC.removeCar();
            }
        });

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}