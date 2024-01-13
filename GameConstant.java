
public class GameConstant {
    public static final int NUMOFSETS = 2;
    public static final GameSet book = new GameSet("Book", 1, 2, 3, 4);
    public static final GameSet house = new GameSet("House", 1, 2, 3, 4);
    public static final GameSet[] collection = {book, house};

    public static GameElement getRandomElement(){
        //get a random number between 0 and NUMOFSETS.
        int rand = (int)(Math.random()*NUMOFSETS)%NUMOFSETS;

        for(int i=0; i<NUMOFSETS; i++){
            if(rand==i){
                return collection[i].getRandomSetElement();
            }
        }
        return null;
        
        /*
        switch(rand%NUMOFSETS){
            case 0: return book.getRandomSetElement();
            case 1: return house.getRandomSetElement();
            default: return null;
        }
        */
        
    }
    
    public static GameElement getRandomElement(int minLevel, int maxLevel){
        //Get a random element within a range of levels. Including 
        //the minium and excluding the maximum.
        int rand = (int)(Math.random()*NUMOFSETS)%NUMOFSETS;

        for(int i=0; i<NUMOFSETS; i++){
            if(rand==i){
                return collection[i].getRandomSetElement(minLevel, maxLevel);
            }
        }
        return null;
    }
    
}
