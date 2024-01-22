import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

public class MainGBottom extends JPanel{
    //Bottom bar in main frame that 
    private static JLabel jLabel;
    private BufferedReader br;
    private FileReader fr;
    private static final int LINE = 5;
    private static String[] story = new String[LINE];
    private static Player player;
    public MainGBottom(Player player)
    {
        setVisible(true);
        setLayout(new GridLayout(1, 0));

        MainGBottom.player = player;

        //Read text from file
        try {
            fr = new FileReader("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\Story.txt");
            br = new BufferedReader(fr);
            for(int i = 0; i<LINE; i++)
            {
                story[i] = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error in File writing");
        }
       
        //Label to set text
        MainGBottom.jLabel = new JLabel();
        labelSetText();
        MainGBottom.jLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        this.add(MainGBottom.jLabel);

    }
    //Renew text
    public static void labelSetText(){
        MainGBottom.jLabel.setText(MainGBottom.story[MainGBottom.player.getValue("level")-1]);
    }
    
    //Return ending
    public static String getEnding()
    {
        return MainGBottom.story[LINE-1];
    }
}
