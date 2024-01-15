import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUI implements ActionListener {
    private JFrame mainFrame;
    private JTextArea resDisplay;
    private JPanel panel;
    private JPanel infoPanel;
    private JLabel pictureLabel;
    String resList = "";

    public GUI(){
        mainFrame = new JFrame("Deuxave Resevation System");

        panel = new JPanel();
        infoPanel = new JPanel();

        pictureLabel = new JLabel();
        try{
            BufferedImage myPicture = ImageIO.read(new File("Deuxave Logo.png"));
            pictureLabel.setIcon(new ImageIcon(myPicture));
        } catch (Exception e){
            e.printStackTrace();
        }

        for(int i=1;i<5;i++){
            //resList.setText(resList.getText()+"reservation"+i+"\n\n");
            resList = resList+"Reservation "+i+"\n\n";
        }
        resDisplay = new JTextArea(resList);
        System.out.println(resList);

        panel.setLayout(new BorderLayout());
        infoPanel.setLayout(new GridLayout());
        panel.add(pictureLabel, BorderLayout.NORTH);
        panel.add(infoPanel, BorderLayout.CENTER);
        infoPanel.add(resDisplay, BorderLayout.WEST);
        mainFrame.add(panel);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

    }
}
