
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainGCenter extends JPanel{
    private final String[] FILEPATH = {"logo.png"};
    private final int NUM = FILEPATH.length;//number of pictures
    private final BufferedImage[] image;
    private static JLabel[] label;
    private static JLabel jLabel;

    public MainGCenter(Player player)
    {
        setVisible(true);
        setLayout(null);

        image = new BufferedImage[NUM];
        label = new JLabel[NUM];
        for(int i=0; i<NUM; i++)
        {
            try{
            image[i] = ImageIO.read(new File(FILEPATH[i]));
            label[i] = new JLabel(new ImageIcon(image[i]));
            label[i].setBounds(0,0,100,200);
            //this.add(picLabel);
            }
            catch(IOException e){
                System.out.println(e);
            } 
        }
        jLabel = label[0];
    }
    public static void switchImage(Player player){
        jLabel = label[player.getValue("level")];
    }
}
