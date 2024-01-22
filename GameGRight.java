import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameGRight extends JPanel implements ActionListener{
    //Right bar in game frame
    private JButton bCombine;
    private JButton bSell;
    private JButton bBack;

    public GameGRight(Player player){
        setLayout(new GridLayout(0,1));
        setVisible(true);
        setBounds(0,0,500,500);

        bCombine = new JButton("Combine elements");
        bCombine.addActionListener(this);
        this.add(bCombine);

        bSell = new JButton("Sell element");
        bSell.addActionListener(this);
        this.add(bSell);

        bBack = new JButton("Back:\nClick");
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
        }
        
    }
}
