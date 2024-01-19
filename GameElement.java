public class GameElement{
    private final int LEVEL;
    private final String SET;
    private final int PRICE;//Price to purchase it. When recieve one, output (price/10)coins
    private boolean isActivated = false;
    private String description;
    
    public GameElement(int level, String set){
        //the price is 10 times its level
        this(level, set, (level*10), null);
        description = toString();
    }

    public GameElement(int level, String set, int price, String description)
    {
        LEVEL = level;
        SET = set;
        PRICE = price;
        this.description = description;
    }

    //Getter
    public int getLevel(){
        return LEVEL;
    }

    public int getPrice(){
        return PRICE;
    }

    public String getSet(){
        return SET;
    }

    public boolean getIsActivated(){
        return isActivated;
    }

    //Setter
    public void setActivated(){
        isActivated = true;
    }


    public boolean equals(GameElement element)
    {
        //if level, set, and price match, return true
        if (LEVEL == element.getLevel() && PRICE == element.getPrice() && SET.equals(element.getSet()))
        {
            return true;
        }
        return false;
    }

    public String toString(){
        return SET + " [ level " + LEVEL + " ]";
    }
}   
