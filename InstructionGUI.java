import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class InstructionGUI extends JFrame{
    //A frame to give instructions
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
        main = ImageIO.read(new File("images/mainIns.png"));
        JLabel picLabel = new JLabel(new ImageIcon(main));
        picLabel.setBounds(0,0,100,200);
        this.add(picLabel);
        }
        catch(IOException e){
            System.out.println(e);
        } 

        //Game instruction
        try{
            game = ImageIO.read(new File("images/gameIns.png"));
            JLabel picLabel = new JLabel(new ImageIcon(game));
            picLabel.setBounds(0,0,100,200);
            this.add(picLabel);
            }
        catch(IOException e){
                System.out.println(e);
        } 
    }
}
