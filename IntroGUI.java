import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroGUI extends JFrame implements ActionListener{
    private JPanel top;
    private JPanel center;
    private JButton infoButton; 
    private JLabel infoLabel;
    private JLabel label;
    private JButton next;

    private Player player;
    public IntroGUI(Player player)
    {
        setBounds(0,0,500,500);
        //setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Top 
        top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setVisible(true);

        infoButton = new JButton("Info");
        infoButton.setBounds(0,0,40, 40);
        infoLabel = new JLabel("Click for the description of this game");
        top.add(infoButton);
        top.add(infoLabel);
        this.add(top, BorderLayout.NORTH);

        //Center
        center = new JPanel();
        center.setVisible(true);
        center.setLayout(new GridLayout(1, 0));
        this.add(center, BorderLayout.CENTER);

        label = new JLabel("Hi! Welcome to this game!\nEnter your name and click \"continue\"");
        center.add(label);

        next = new JButton("Next");
        next.addActionListener(this);
        center.add(next);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next){
            new GameGUI(player);
        }
    }

}
