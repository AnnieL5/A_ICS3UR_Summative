import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class InstructionGUI extends JFrame{
    private BufferedImage main;
    private BufferedImage game;
    
    public InstructionGUI()
    {
        setVisible(true);
        setBounds(0,0,200,500);
        setLayout(new GridLayout(0,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //main page instructions
        try{
        main = ImageIO.read(new File("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\mainIns.png"));
        JLabel picLabel = new JLabel(new ImageIcon(main));
        picLabel.setBounds(0,0,100,200);
        this.add(picLabel);
        }
        catch(IOException e){
            System.out.println("3"+e);
        } 

        //Game instruction
        try{
            game = ImageIO.read(new File("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\gameIns.png"));
            JLabel picLabel = new JLabel(new ImageIcon(game));
            picLabel.setBounds(0,0,100,200);
            this.add(picLabel);
            }
        catch(IOException e){
                System.out.println("3"+e);
        } 
    }
}
