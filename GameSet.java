
public class GameSet {
    private final String NAME;
    private final int NUMOFELEMENT = 4;
    private final GameElement[] set = new GameElement[4];

    public GameSet(String name, GameElement e1, GameElement e2, GameElement e3, GameElement e4)
    {
        NAME = name;
        set[0] = e1;
        set[1] = e2;
        set[2] = e3;
        set[3] = e4;
    }

    public GameSet(String name, int level1, int level2, int level3, int level4)
    {
        NAME = name;
        set[0] = new GameElement(level1, NAME);
        set[1] = new GameElement(level2, NAME);
        set[2] = new GameElement(level3, NAME);
        set[3] = new GameElement(level4, NAME);
    }

    public GameElement getElement(int level){
        return set[level-1];
    }

    public GameElement getRandomSetElement(){
        int i = (int)(Math.random()*(NUMOFELEMENT));
        //System.out.println(i);
        return new GameElement(set[i].getLevel(), set[i].getSet());
    }
    public GameElement getRandomSetElement(int minLevel, int maxLevel){
        //Get a random element within a range of levels. Including the minium and excluding the maximum.
        int i = (int)(Math.random()*(maxLevel-minLevel))+minLevel-1;
        //System.out.println(i);
        return new GameElement(set[i].getLevel(), set[i].getSet());
    }
}
