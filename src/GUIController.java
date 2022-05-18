
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GUIController implements ActionListener
{
    private JTextArea weatherInfo;
    private JTextField weatherEntryField;

    public GUIController(){
        weatherInfo = new JTextArea(5, 20);
        weatherEntryField = new JTextField(10);
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
        weatherListPanel.add(weatherLabel);
        weatherListPanel.add(weatherEntryField);
        weatherListPanel.add(submit);
        weatherListPanel.add(clear);



        JPanel weatherInfoPanel = new JPanel();
        weatherInfo.setText("processing ...");
        weatherInfo.setFont(new Font("Helvetica", Font.PLAIN, 16));
        weatherInfo.setWrapStyleWord(true);
        weatherInfo.setLineWrap(true);
        weatherInfoPanel.add(weatherInfo);

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
            int movieNumInt = Integer.parseInt(zipCode);

        }

        // if user clicked "Reset" button, set the text field back to empty string
        // and load the Now Playing list again
        else if (text.equals("Clear"))
        {
            weatherEntryField.setText("");
            setUpGUI();
        }
    }
}