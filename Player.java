import javax.swing.*;

public class Player {
    private int mapleLeaves;
    private int money;
    private String name; //public because easy to access
    private int level;
    
    //constructors
    public Player()
    {
        this("NA");
    }
    public Player(String name)
    {
        this.name = name;
        mapleLeaves = 0;
        money = 150;
        level = 1;
        if(name.equals("GOD")){
            money = 1000000;
        }
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setIncrement(String type, int amount)
    {
        // A setter method so is not needed to create more seperate methods
        switch(type){
            case "maple leaves": mapleLeaves+=amount;
                         System.out.println("Increment by " +amount+ ", "+ type+ " is now "+mapleLeaves);
                         GameGTop.setMapleLeavesLabel();
                         break;
            case "money": money+=amount;
                         if(money<0){
                             JOptionPane.showMessageDialog(null, "<html>Sorry you don't have any money left QAQ. Exit to replay the game");
                             money = 0;
                         } else {
                             System.out.println("Increment by " + amount + ", " + type + " is now " + money);
                             GameGTop.setMoneyLabel();
                         }
                         break;
            case "level": level+=amount;
                         System.out.println("Increment by " +amount+ ", "+ type+ " is now "+level);
                         if(level >= 5){
                            JOptionPane.showMessageDialog(null, "<html>Congradulation!"+MainGBottom.getEnding());
                            System.exit(0);
                         }
                         break;
            default: System.out.println("Wrong type.");
        }
    }

    public int getValue(String type){
        //Getter method. Easier so won't have to create seperate methods
        switch(type){
            case "maple leaves": return mapleLeaves;
            case "money": return money;
            case "level": return level;
            //case "remainStep": return remainStep;
            default: return -100;
        }
    }

    public String toString()
    {
        return "\t Player "+ name+":\t\t          Level: " +level+ "\t\t        Maple Leaves:" +mapleLeaves+ "\t\t         Money: "+money;
    }
}


