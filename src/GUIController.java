
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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class GUIController implements ActionListener, ItemListener
{
    private final JLabel weatherInfo;
    private final JTextField weatherEntryField;
    private JLabel pictureLabel;
    private JPanel weatherInfoPanel;


    public GUIController(){
        weatherInfo = new JLabel();
        weatherEntryField = new JTextField(6);
        pictureLabel = new JLabel();
        weatherInfoPanel = new JPanel();

        setUpGUI();
    }

    public void setUpGUI(){
        JFrame frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Topic
        JPanel logoWelcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("   Current Weather   ");
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.blue);
        logoWelcomePanel.add(welcomeLabel);
        // Instruction Panel
        JPanel weatherListPanel = new JPanel();
        JLabel weatherLabel = new JLabel("Enter Zip Code: ");
        JButton submit = new JButton("Submit");
        JButton clear = new JButton("Clear");
        JCheckBox checkBox = new JCheckBox("Show Celsius");
        // incorporate attributes
        weatherListPanel.add(weatherLabel);
        weatherListPanel.add(weatherEntryField);
        weatherListPanel.add(submit);
        weatherListPanel.add(clear);
        weatherListPanel.add(checkBox);



        // Have result be printed in Label format; in weatherInfoPanel
        weatherInfo.setText("Hello");
        weatherInfo.setFont(new Font("Helvetica", Font.PLAIN, 16));
        // Invisible PlaceHolder image in the panel
        ImageIcon image = new ImageIcon("src/PlaceHolder.jpg");
        Image imageData = image.getImage(); // transform it
        Image scaledImage = imageData.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image = new ImageIcon(scaledImage);  // transform it back
        pictureLabel = new JLabel(image);
//        weatherInfo.setWrapStyleWord(true);
//        weatherInfo.setLineWrap(true);

        // incorporate attributes
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
        JButton button = (JButton) (e.getSource());
        String text = button.getText();

        if (text.equals("Submit"))
        {
            String zipCode = weatherEntryField.getText();
            int zipCodeNum = Integer.parseInt(zipCode);
            // inserted code requiring zipCode response
        }
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
            weatherInfo.setText("Yes");
            BufferedImage bufImg = null;
            Image tmp = null;
            try {
                bufImg = ImageIO.read(new File("src/tmdblogo.jpg"));
                tmp = bufImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            assert false;
            pictureLabel.setIcon(new ImageIcon(tmp));
        }
        else  // inserted code for F; default temp unit
        {
            weatherInfo.setText("No");
            BufferedImage bufImg = null;
            Image tmp = null;
            try {
                bufImg = ImageIO.read(new File("src/PlaceHolder.jpg"));
                tmp = bufImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            assert false;
            pictureLabel.setIcon(new ImageIcon(tmp));
        }

    }
}