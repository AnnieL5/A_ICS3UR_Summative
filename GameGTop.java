
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameGTop extends JPanel{
    BufferedImage pProfileP;
    BufferedImage moneyIcon;
    BufferedImage starIcon;
    
    JLabel pName;
    JLabel pMoney;
    JLabel pStar;
    public GameGTop(Player player){
        setBounds(0,0,400,400);
        setLayout(new GridLayout(1,7));
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Profile picture
        try{
        pProfileP = ImageIO.read(new File("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(pProfileP));
        picLabel.setBounds(0,0,100,200);
        this.add(picLabel);
        }
        catch(IOException e){
            System.out.println("1"+e);
        } 

        String n = player.name;
        System.out.println(n);
        pName = new JLabel("Player: "+player.name);
        pName.setText("Player: "+ n);
        this.add(pName);

        //Money icon
        try{
        moneyIcon = ImageIO.read(new File("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(moneyIcon));
        picLabel.setBounds(0,0,100,200);
        this.add(picLabel);
        }
        catch(IOException e){
            System.out.println("2"+e);
        } 


        pMoney = new JLabel("Money: "+player.getValue("money"));
        this.add(pMoney);

        //Star icon
        try{
        starIcon = ImageIO.read(new File("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(starIcon));
        picLabel.setBounds(0,0,100,200);
        this.add(picLabel);
        }
        catch(IOException e){
            System.out.println("3"+e);
        } 

        pStar = new JLabel("Maple leaves: "+ player.getValue("maple leaves"));
        this.add(pStar);
    }
    
    public void setMoneyLabel(int amount)
    {
        pMoney.setText("Money: "+amount);
    }
    public void setMapleLeavesLabel(int amount)
    {
        pStar.setText("Maple leaves: "+amount);
    }
    /*
    public static void main(String[] args) {
        new TopPanel();
    }
    */
}
