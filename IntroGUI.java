import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroGUI extends JFrame implements ActionListener{
    //Introduction frame
    private JPanel top;
    private JPanel center;
    private JButton infoButton; 
    private JLabel infoLabel;
    private JLabel label;
    private JButton next;
    private JTextField textInput;
    private final String INFOTEXT = "<html>The mission of creating this game is to lead <br>people to raise awareness and execute changes about indigenous issues. <br>To do this, players could build schools, public institutes to reestablish communities <br>and fix the issues by helping community members and combining building blocks that stimulate the actual process. <br>Moreover, each player is required to wisely use the limited amount of money to make the <br>maximum contribution, thus creating challenges and encouraging quick and <br>efficient ways to solve the problem. Players could not only experience Indigenous <br>difficult lives, but figure out a way to assist them and grow the community prosperous.";

    private Player player;
    public IntroGUI(Player player)
    {
        setBounds(0,0,500,500);
        //setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.player = player;
        
        //Top 
        top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setVisible(true);

        infoButton = new JButton("Info");
        infoButton.setBounds(0,0,40, 40);
        infoButton.addActionListener(this);
        
        infoLabel = new JLabel("Click for the description of this game");
        top.add(infoButton);
        top.add(infoLabel);
        this.add(top, BorderLayout.NORTH);

        //Center
        center = new JPanel();
        center.setVisible(true);
        center.setLayout(new GridLayout(0, 1));
        this.add(center, BorderLayout.CENTER);

        label = new JLabel("Hi! Welcome to this game!\nEnter your name and click \"continue\"");
        center.add(label);

        textInput = new JTextField("Input your name");
        center.add(textInput);

        textInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textInput.setText("");
                textInput.removeFocusListener(this);
            }
        });

        next = new JButton("Next");
        next.addActionListener(this);
        center.add(next);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == infoButton)
        {
            JOptionPane.showMessageDialog(null, INFOTEXT);
        }
        else if(e.getSource() == next){
            //Go to the next frame
            String text = textInput.getText();
            player.setName(text);
            MainGUI.topLabelSetText();
            Main.mg.setVisible(true);
            new InstructionGUI();
            JOptionPane.showMessageDialog(null, "<html>Please follow the story line to ungrading the community <br>and achive the ultimate goal of building a school in the Indigenous comunity.");
        }
    }

}
