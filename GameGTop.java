
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
    
    static JLabel pName;
    static JLabel pMoney; 
    static JLabel pStar;
    private static Player player;
    public GameGTop(Player player){
        setBounds(0,0,400,400);
        setLayout(new GridLayout(1,7));
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        GameGTop.player = player;
        //Profile picture
        try{
        pProfileP = ImageIO.read(new File("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\player.png"));
        JLabel picLabel = new JLabel(new ImageIcon(pProfileP));
        picLabel.setBounds(0,0,50,50);
        this.add(picLabel);
        }
        catch(IOException e){
            System.out.println("1"+e);
        } 

        String n = GameGTop.player.getName();
        System.out.println(n);
        pName = new JLabel("Player: "+GameGTop.player.getName());
        pName.setText("Player: "+ n);
        this.add(pName);

        //Money icon
        try{
        moneyIcon = ImageIO.read(new File("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\money.png"));
        JLabel picLabel = new JLabel(new ImageIcon(moneyIcon));
        picLabel.setBounds(0,0,100,200);
        this.add(picLabel);
        }
        catch(IOException e){
            System.out.println("2"+e);
        } 


        pMoney = new JLabel("Money: "+GameGTop.player.getValue("money"));
        this.add(pMoney);

        //Star icon
        try{
        starIcon = ImageIO.read(new File("E:\\Annie\\Code\\Annie code\\Summative1\\A_Summative\\A_ICS3UR_Summative\\maple leaves.png"));
        JLabel picLabel = new JLabel(new ImageIcon(starIcon));
        picLabel.setBounds(0,0,100,200);
        this.add(picLabel);
        }
        catch(IOException e){
            System.out.println("3"+e);
        } 

        pStar = new JLabel("Maple leaves: "+ GameGTop.player.getValue("maple leaves"));
        this.add(pStar);
    }
    
    public static void setNameLabel()
    {
        pName.setText("Name: "+GameGTop.player.getName());
    }
    public static void setMoneyLabel()
    {
        pMoney.setText("Money: "+GameGTop.player.getValue("money"));
    }
    public static void setMapleLeavesLabel()
    {
        pStar.setText("Maple leaves: "+GameGTop.player.getValue("maple leaves"));
    }
    /*
    public static void main(String[] args) {
        new TopPanel();
    }
    */
}
