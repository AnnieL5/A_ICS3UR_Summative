
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameGLeftM extends JPanel implements ActionListener{
    //Left mission bar in the game panel
    private JLabel jLabel;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    public final GameElement[] missions = new GameElement[3];

    public GameGLeftM()
    {
        setLayout(new GridLayout(0,1));
        setVisible(true);
        setBounds(0,0,500,500);

        jLabel = new JLabel("Missions: ");
        this.add(jLabel);
        
        b1 = new JButton();
        addMission(b1, 1);
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton();
        addMission(b2, 2);
        b2.addActionListener(this);
        this.add(b2);

        b3 = new JButton();
        addMission(b3, 3);
        b3.addActionListener(this);
        this.add(b3);

    }

    public void addMission(JButton jbutton, int numOfButton)
    {
        //Get/replace a mission
        missions[numOfButton-1] = GameConstant.getRandomElement();
        jbutton.setText("<html>"+missions[numOfButton-1].toString()+"\n Maple leaves: "+missions[numOfButton-1].getPrice());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            //if submit successful
            if(GameGUI.p.submitMission(missions[0]) == true)
            {
                addMission(b1, 1);
            }
        }
        else if(e.getSource() == b2)
        {
            if(GameGUI.p.submitMission(missions[1]) == true)
            {
                addMission(b2, 2);
            }
        }
        else if(e.getSource() == b3)
        {
            if(GameGUI.p.submitMission(missions[2]) == true)
            {
                addMission(b3, 3);
            }
        }
    }
}
