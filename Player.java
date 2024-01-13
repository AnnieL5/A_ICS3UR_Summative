
public class Player {
    private int mapleLeaves;
    private int money;
    public String name; //public because easy to access
    private int level;
    //rivate final int MAXSTEP;
    //private int remainStep;//the amount of steps each player have to attend it's mission

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
        //MAXSTEP = 30;
        //remainStep = MAXSTEP;
    }

    public void setIncrement(String type, int amount)
    {
        switch(type){
            case "maple leaves": mapleLeaves+=amount;
                         System.out.println("Increment by " +amount+ ", "+ type+ " is now "+mapleLeaves);
                         GameGUI.tp.setMapleLeavesLabel(mapleLeaves);
                         break;
            case "money": money+=amount;
                         System.out.println("Increment by " +amount+ type+ " is now "+money);
                         GameGUI.tp.setMoneyLabel(money);
                         break;
            case "level": level+=amount;
                         System.out.println("Increment by " +amount+ type+ " is now "+level);
                         break;
            //case "remainStep": remainStep+=amount;
            //             System.out.println("Increment by " +amount+ type+ " is now "+remainStep);
            //             break;
            default: System.out.println("Wrong type.");
        }
    }

    public int getValue(String type){
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
        return "\n\t Player "+ name+":\n\t Level: " +level+ "\n\tMaple Leaves:" +mapleLeaves+ "\n\tMoney: "+money;
    }
}


