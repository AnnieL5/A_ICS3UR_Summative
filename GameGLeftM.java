
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameGLeftM extends JPanel implements ActionListener{
    private JLabel jLabel;
    private JButton b1;
    private boolean b1State = false;
    private JButton b2;
    private boolean b2State = false;
    private JButton b3;
    private boolean b3State = false;
    public final GameElement[] missions = {GameConstant.book.getElement(2), GameConstant.house.getElement(1), GameConstant.book.getElement(1)};
    private int count=0;


    public GameGLeftM()
    {
        setLayout(new GridLayout(0,1));
        setVisible(true);
        setBounds(0,0,500,500);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLabel = new JLabel("Missions: ");
        this.add(jLabel);
        
        b1 = new JButton(missions[count].toString()+"\n Maple leaves: "+missions[count].getPrice());
        count++;
        b1.addActionListener(this);
        this.add(b1);

        b2 = new JButton(missions[count].toString()+"\n Maple leaves: "+missions[count].getPrice());
        count++;
        b2.addActionListener(this);
        this.add(b2);

        b3 = new JButton(missions[count].toString()+"\n Maple leaves: "+missions[count].getPrice());
        count++;
        b3.addActionListener(this);
        this.add(b3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            if(b1State == false)
            {
                b1.setText(b1.getText()+GameGUI.p.submitMission(missions[0]));
                if(b1.getText() == b1.getText()+": \nsubmitted")
                {
                    b1State = true;
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Already submitted");
            }
        }
        else if(e.getSource() == b2)
        {
            if(b2State == false)
            {
                b2.setText(b2.getText()+GameGUI.p.submitMission(missions[1]));
                if(b2.getText() == b2.getText()+": \nsubmitted")
                {
                    b2State = true;
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Already submitted");
            }
        }
        else if(e.getSource() == b3)
        {
            System.out.println("Here");
            if(b3State == false)
            {
                b3.setText(b3.getText()+GameGUI.p.submitMission(missions[2]));
                if(b3.getText() == b3.getText()+": \nsubmitted")
                {
                    b3State = true;
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Already submitted");
            }
        }
        
    }
}
