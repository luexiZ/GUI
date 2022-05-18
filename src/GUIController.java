
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GUIController implements ActionListener, ItemListener
{
    private final JLabel weatherInfo;
    private final JTextField weatherEntryField;
    private ImageIcon image;


    public GUIController(){
        weatherInfo = new JLabel();
        weatherEntryField = new JTextField(6);
        image = new ImageIcon();

        setUpGUI();
    }

    public void setUpGUI(){
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel logoWelcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("   Current Weather   ");
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.blue);
        logoWelcomePanel.add(welcomeLabel);

        JPanel weatherListPanel = new JPanel();
        JLabel weatherLabel = new JLabel("Enter Zip Code: ");
        JButton submit = new JButton("Submit");
        JButton clear = new JButton("Clear");
        JCheckBox checkBox = new JCheckBox("Show Celsius");

        ImageIcon image = new ImageIcon("src/PlaceHolder.jpg");
        Image imageData = image.getImage(); // transform it
        Image scaledImage = imageData.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image = new ImageIcon(scaledImage);  // transform it back
        JLabel pictureLabel = new JLabel(image);


        weatherListPanel.add(weatherLabel);
        weatherListPanel.add(weatherEntryField);
        weatherListPanel.add(submit);
        weatherListPanel.add(clear);
        weatherListPanel.add(checkBox);



        JPanel weatherInfoPanel = new JPanel();
        weatherInfo.setText("Hello");
        weatherInfo.setFont(new Font("Helvetica", Font.PLAIN, 16));
//        weatherInfo.setWrapStyleWord(true);
//        weatherInfo.setLineWrap(true);
        weatherInfoPanel.add(weatherInfo);
        weatherInfoPanel.add(pictureLabel);


        checkBox.addItemListener(this);
        submit.addActionListener(this);
        clear.addActionListener(this);

        frame.add(logoWelcomePanel, BorderLayout.NORTH);
        frame.add(weatherListPanel, BorderLayout.CENTER);
        frame.add(weatherInfoPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) (e.getSource());  // cast source to JButton
        String text = button.getText();

        if (text.equals("Submit"))
        {
            // obtain the numerical value that the user typed into the text field
            // (getTest() returns a string) and convert it to an int
            String zipCode = weatherEntryField.getText();
            int zipCodeNum = Integer.parseInt(zipCode);

        }

        // if user clicked "Reset" button, set the text field back to empty string
        // and load the Now Playing list again
        else if (text.equals("Clear"))
        {
            weatherEntryField.setText("");

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int checkBoxOnOrOff = e.getStateChange();
        if(checkBoxOnOrOff == 1) // when it's clicked; inserted code to change temp unit to C.
        {
            System.out.println("Why did you check me ?");
        }
        else  // inserted code for F; default temp unit
        {
            System.out.println("Come now, CLICK ME!");
        }
    }
}