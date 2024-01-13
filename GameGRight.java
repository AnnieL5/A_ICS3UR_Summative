
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameGRight extends JPanel implements ActionListener{
    private JButton bCombine;
    private JButton bSell;
    private JButton bBack;

    private Player player;

    public GameGRight(Player player){
        setLayout(new GridLayout(0,1));
        setVisible(true);
        setBounds(0,0,500,500);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        bCombine = new JButton("Combine elements");
        bCombine.addActionListener(this);
        this.add(bCombine);

        bSell = new JButton("Sell element");
        bSell.addActionListener(this);
        this.add(bSell);

        bBack = new JButton("Back:\nClick and close this window");
        bBack.addActionListener(this);
        this.add(bBack);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bCombine)
        {
            GameGUI.p.combineElements();
        }
        else if(e.getSource() == bSell)
        {
            GameGUI.p.sell();
        }
        else if(e.getSource() == bBack)
        {
            Main.mg.setVisible(true);
            //new MainGUI(player);
        }
        
    }
    
    //public static void main(String[] args) {
     //   new RightPanel();
    //}
}
