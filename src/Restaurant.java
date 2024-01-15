import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Restaurant implements ActionListener {
    private JFrame mainFrame;
    private JTextArea resDisplay;
    private JPanel panel;
    private JPanel infoPanel;
    private JLabel pictureLabel;
    private JPanel sortButtons;
    private JButton sizeButton;
    private JButton timeForButton;
    private JButton timePlacedButton;
    String resList = "";

    private ArrayList<Reservation> r = new ArrayList<>();

    public Restaurant(){
        for(int x=0;x<5;x++){
            addRes();
        }
        GUI();
    }

    public void addRes(){
        r.add(new Reservation());
    }

    //bubble sort
    public void sizeSort(){
        boolean madeSwap = false;
        for(int x=1;x<r.size();x++) {
            madeSwap = false;
            for (int y=1;y<r.size()-(x-1);y++) {
                if (r.get(y-1).getSize() > r.get(y).getSize()) {
                    Reservation temp = r.get(y);
                    r.set(y, r.get(y-1));
                    r.set((y-1), temp);
                    madeSwap = true;
                }
            }
            if(!madeSwap){
                break;
            }
        }
    }

    //insertion sort
    public void timePlacedSort(){
        for(int i=1;i<r.size();i++) {
            int j = i;
            while (j>0 && r.get(j-1).getTimePlaced() < r.get(j).getTimePlaced()) {
                Reservation temp = r.get(j-1);
                r.set(j-1, r.get(j));
                r.set(j, temp);
                j--;
            }
        }
    }

    //selection sort
    public void timeForSort(){
        for(int x=0;x<r.size();x++) {
            int min = x;
            for (int y=x+1;y<r.size();y++) {
                if(r.get(y).getTimeFor() < r.get(min).getTimeFor()){
                    min = y;
                }
            }
            if(min != x){
                Reservation temp = r.get(x);
                r.set(x, r.get(min));
                r.set(min, temp);
            }
        }
    }

    public void GUI(){
        mainFrame = new JFrame("Deuxave Resevation System");

        panel = new JPanel();
        infoPanel = new JPanel();
        sortButtons = new JPanel();

        sizeButton = new JButton("Party Size");
        timeForButton = new JButton("Time For");
        timePlacedButton = new JButton("Time Placed");

        sizeButton.addActionListener(this);
        timeForButton.addActionListener(this);
        timePlacedButton.addActionListener(this);

        pictureLabel = new JLabel();
        try{
            BufferedImage myPicture = ImageIO.read(new File("Deuxave Logo.png"));
            pictureLabel.setIcon(new ImageIcon(myPicture));
        } catch (Exception e){
            e.printStackTrace();
        }

        for(int i=0;i<5;i++){
            resList = resList+r.get(i).getName()+":\t     "+r.get(i).getSize()+"\t\t                 "+(int)r.get(i).getTimeFor()+":"+(int)((r.get(i).getTimeFor()%1)*60)+"\t\t          "+(int)r.get(i).getTimePlaced()+":"+(int)((r.get(i).getTimePlaced()%1)*60)+"\n------------------------------------------------------------------------------------------------------------------------------------------------------\n";
        }
        resDisplay = new JTextArea(resList);

        panel.setLayout(new BorderLayout());
        infoPanel.setLayout(new BorderLayout());
        panel.add(pictureLabel, BorderLayout.NORTH);
        panel.add(infoPanel, BorderLayout.CENTER);
        sortButtons.setLayout(new GridLayout(1,3));
        sortButtons.add(sizeButton);
        sortButtons.add(timeForButton);
        sortButtons.add(timePlacedButton);
        infoPanel.add(sortButtons, BorderLayout.NORTH);
        infoPanel.add(resDisplay, BorderLayout.CENTER);

        mainFrame.add(panel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object buttonClicked = e.getSource();
        if(buttonClicked == sizeButton){
            sizeSort();
            resList = " ";
            for(int i=0;i<5;i++){
                resList = resList + r.get(i).getName()+":\t     "+r.get(i).getSize()+"\t\t               "+(int)r.get(i).getTimeFor()+":"+(int)((r.get(i).getTimeFor()%1)*60)+"\t\t          "+(int)r.get(i).getTimePlaced()+":"+(int)((r.get(i).getTimePlaced()%1)*60)+"\n------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            }
            resDisplay.setText(resList);
        }
        if(buttonClicked == timeForButton){
            timeForSort();
            resList = " ";
            for(int i=0;i<5;i++){
                resList = resList + r.get(i).getName()+":\t     "+r.get(i).getSize()+"\t\t               "+(int)r.get(i).getTimeFor()+":"+(int)((r.get(i).getTimeFor()%1)*60)+"\t\t          "+(int)r.get(i).getTimePlaced()+":"+(int)((r.get(i).getTimePlaced()%1)*60)+"\n------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            }
            resDisplay.setText(resList);
        }
        if(buttonClicked == timePlacedButton){
            timePlacedSort();
            resList = " ";
            for(int i=0;i<5;i++){
                resList = resList + r.get(i).getName()+":\t     "+r.get(i).getSize()+"\t\t               "+(int)r.get(i).getTimeFor()+":"+(int)((r.get(i).getTimeFor()%1)*60)+"\t\t          "+(int)r.get(i).getTimePlaced()+":"+(int)((r.get(i).getTimePlaced()%1)*60)+"\n------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            }
            resDisplay.setText(resList);
        }
    }

    public static void main(String[] args) {
        Restaurant Deuxave = new Restaurant();
    }
}