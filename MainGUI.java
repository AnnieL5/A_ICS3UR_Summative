
import java.awt.BorderLayout;

import javax.swing.*;

public class MainGUI extends JFrame{
    //Frame for main that includes all panels
    static JLabel topLabel;
    public static MainGCenter cp;
    public static MainGBottom bp;
    public static MainGRight rp;
    private static Player player;
    public MainGUI(Player player)
    {
        setBounds(0,0,1000,1000);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MainGUI.player = player;

        topLabel = new JLabel();
        MainGUI.topLabelSetText();
        this.add(topLabel, BorderLayout.NORTH);

        cp = new MainGCenter(MainGUI.player);
        this.add(cp, BorderLayout.CENTER);

        bp = new MainGBottom(MainGUI.player);
        this.add(bp, BorderLayout.SOUTH);

        rp = new MainGRight(MainGUI.player);
        this.add(rp, BorderLayout.EAST);
    }
    //Renew text
    public static void topLabelSetText()
    {
        topLabel.setText(MainGUI.player.toString());
    }
}