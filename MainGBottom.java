
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGBottom extends JPanel implements ActionListener{
    private JLabel jLabel;
    private JButton jButton;
    private JButton gameButton;
    private final int[] REQUIREMENTS = {10, 10, 10};//the number of required maple leaves for each update
    private BufferedReader br;
    private FileReader fr;
    private final int LINE = 5;
    private String[] story = new String[LINE];
    private Player player;
    public MainGBottom(Player player)
    {
        setVisible(true);
        setLayout(new GridLayout(1, 0));

        this.player = player;

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
       
        jLabel = new JLabel();
        labelSetText();
        this.add(jLabel);

        jButton = new JButton();
        jButton.addActionListener(this);
        this.add(jButton);
        buttonSetText();

        gameButton = new JButton("Game Panel:\n" + //
                "Click and close this window");
        gameButton.addActionListener(this);
        this.add(gameButton);
    }
    public void labelSetText(){
        jLabel.setText(story[player.getValue("level")]);
    }
    public void buttonSetText(){
        jButton.setText("Upgrade Community"+"\nRequired maple leaves: "+REQUIREMENTS[player.getValue("level")]);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == jButton)
        {
            if(player.getValue("maple leaves")>=REQUIREMENTS[player.getValue("level")])
            {
                player.setIncrement("level", 1);
                labelSetText();
                buttonSetText();
                MainGCenter.switchImage(player);
                MainGUI.topLabelSetText();
            }
            else{
                JOptionPane.showMessageDialog(null, "Not enough maple leaves.");
            }
        }
        else if(e.getSource() == gameButton)
        {
            Main.gg.setVisible(true);
        }
    }
}
