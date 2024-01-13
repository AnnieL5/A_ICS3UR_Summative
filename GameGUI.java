import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GameGUI extends JFrame{
    JButton jButton;
    JLabel jLabel;

    public static GameGTop tp;
    public static GameGGrid p;
    public static GameGRight rp;
    public static GameGLeftM lp;

    //Panel panel;
    public GameGUI(Player player){
        setBounds(0,0,1000,600);
        //setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // JButton jb = new JButton("OO");
        // this.add(jb);

        tp = new GameGTop(player);
        this.add(tp,BorderLayout.NORTH);

        p = new GameGGrid(player);
        this.add(p,BorderLayout.CENTER);

        rp = new GameGRight(player);
        this.add(rp, BorderLayout.EAST);

        lp = new GameGLeftM();
        this.add(lp, BorderLayout.WEST);
    }
    
    /*
    public static void main(String[] args) {
        new GUIGame();
    }
    */
}