
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainGCenter extends JPanel{
    private static final String[] FILEPATH = {"E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\1.jpg",
    "E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\2.jpeg", 
    "E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\3.jpg",
    "E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\4.jpg", 
    "E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\5.jpeg"};
    private final int NUM = FILEPATH.length;//number of pictures
    private static BufferedImage[] image;
    private JLabel[] label;
    private JLabel jLabel;

    public MainGCenter(Player player)
    {
        //Panel set up
        setVisible(true);
        setLayout(new FlowLayout());

        image = new BufferedImage[NUM];
        label = new JLabel[NUM];

        //Label image
        jLabel = new JLabel();
        for(int i=0; i<NUM; i++)
        {
            try{
            image[i] = ImageIO.read(new File(FILEPATH[i]));
            label[i] = new JLabel(new ImageIcon(image[i]));
            label[i].setBounds(0,0,100,200);
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
        System.out.println("Level"+ (player.getValue("level")-1));
        jLabel.setIcon(new ImageIcon(image[player.getValue("level")-1]));
    }
}
