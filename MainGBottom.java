
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGBottom extends JPanel{
    private static JLabel jLabel;
    //private JButton jButton;
    //private JButton gameButton;
    //private final int[] REQUIREMENTS = {2, 5, 10, 15};//the number of required maple leaves for each update
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
       
        MainGBottom.jLabel = new JLabel();
        labelSetText();
        MainGBottom.jLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        this.add(MainGBottom.jLabel);

        // jButton = new JButton();
        // jButton.addActionListener(this);
        // this.add(jButton);
        // buttonSetText();

        // gameButton = new JButton("Game Panel:\n" + //
        //         "Click and close this window");
        // gameButton.addActionListener(this);
        // this.add(gameButton);
    }
    public static void labelSetText(){
        MainGBottom.jLabel.setText(MainGBottom.story[MainGBottom.player.getValue("level")-1]);
    }
    // public void buttonSetText(){
    //     jButton.setText("Upgrade Community"+"\nRequired maple leaves: "+REQUIREMENTS[player.getValue("level")-1]);
    // }
    
    public static String getEnding()
    {
        return MainGBottom.story[LINE-1];
    }
    // @Override
    // public void actionPerformed(ActionEvent e) 
    // {
    //     if(e.getSource() == jButton)
    //     {
    //         if(player.getValue("maple leaves") >= REQUIREMENTS[player.getValue("level")-1])
    //         {
    //             player.setIncrement("maple leaves", -1*REQUIREMENTS[player.getValue("level")-1]);
    //             player.setIncrement("level", 1);
    //             labelSetText();
    //             buttonSetText();
    //             //MainGCenter.switchImage(player);
    //             MainGUI.topLabelSetText();
    //         }
    //         else{
    //             labelSetText();
    //             buttonSetText();
    //             MainGUI.topLabelSetText();
    //             JOptionPane.showMessageDialog(null, "Not enough maple leaves.");
    //         }
    //     }
    //     else if(e.getSource() == gameButton)
    //     {
    //         Main.gg.setVisible(true);
    //         GameGTop.setNameLabel();
    //     }
    // }
}
