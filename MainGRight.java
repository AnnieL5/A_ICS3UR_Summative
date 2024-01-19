import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGRight extends JPanel implements ActionListener{
    //Right panel in the main frame
    private final int[] REQUIREMENTS = {10, 10, 10, 10};//the number of required maple leaves for each update
    private static JButton jButton;
    private JButton gameButton;

    private static Player player;
    
    public MainGRight(Player player)
    {
        setVisible(true);
        setLayout(new GridLayout(0, 1));

        MainGRight.player = player;

        jButton = new JButton();
        jButton.addActionListener(this);
        this.add(jButton);
        buttonSetText();

        gameButton = new JButton("<html>Game Panel:<br>" + //
                "Click");
        gameButton.addActionListener(this);
        this.add(gameButton);
    }
    //Renew text
    public void buttonSetText(){
        MainGRight.jButton.setText("<html>Upgrade Community"+"<br>Required maple leaves: "+REQUIREMENTS[MainGRight.player.getValue("level")-1]);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == jButton)
        {
            //upgrade community
            if(MainGRight.player.getValue("maple leaves") >= REQUIREMENTS[MainGRight.player.getValue("level")-1])
            {
                MainGRight.player.setIncrement("maple leaves", -1*REQUIREMENTS[MainGRight.player.getValue("level")-1]);
                MainGRight.player.setIncrement("level", 1);
                //Renew all label
                MainGBottom.labelSetText();
                buttonSetText();
                MainGUI.topLabelSetText();
                MainGUI.cp.switchImage(player);
            }
            else{
                MainGBottom.labelSetText();
                buttonSetText();
                MainGUI.topLabelSetText();
                JOptionPane.showMessageDialog(null, "Not enough maple leaves.");
            }
        }
        else if(e.getSource() == gameButton)
        {
            //Go to game frame
            Main.gg.setVisible(true);
            GameGTop.setNameLabel();
        }
    }
}
