
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainGCenter extends JPanel{
//    private static final String[] FILEPATH = {"E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\1.jpg",
//    "E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\2.jpeg",
//    "E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\3.jpg",
//    "E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\4.jpg",
//    "E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\5.jpeg"};

    private static final String[] FILEPATH = {"images/1.jpg",
            "images/2.jpeg",
            "images/3.jpg",
            "images/4.jpg",
            "images/5.jpeg"};


    private final int NUM = FILEPATH.length;//number of pictures
    private static BufferedImage[] image;
    private JLabel[] label;
    private JLabel jLabel;
    private static Image[] scaled_img;

    public MainGCenter(Player player)
    {
        //Panel set up
        setVisible(true);
        setLayout(new FlowLayout());

        image = new BufferedImage[NUM];
        label = new JLabel[NUM];
        scaled_img = new Image[NUM];

        //Label image
        jLabel = new JLabel();
        for(int i=0; i<NUM; i++)
        {
            try{
            image[i] = ImageIO.read(new File(FILEPATH[i]));
            //label[i] = new JLabel(new ImageIcon(image[i]));
            Image dimg = image[i].getScaledInstance(900, 600, Image.SCALE_SMOOTH);
            scaled_img[i] = dimg;
            //label[i].setBounds(0,0,100,200);
            }
            catch(IOException e){
                System.out.println(e);
            } 
        }
        switchImage(player);
        this.add(jLabel);
    }
    //Renew image
    public void switchImage(Player player){
        jLabel.setIcon(new ImageIcon(scaled_img[player.getValue("level")-1]));
    }
}
