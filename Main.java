public class Main {
    static IntroGUI ig;
    static GameGUI gg;
    static MainGUI mg;
    public static void main(String[] args) {
        //Call all three frames
        Player player = new Player();
        
        ig = new IntroGUI(player);
        ig.setVisible(true);
        //Other frames are not set visible
        gg = new GameGUI(player);
        mg = new MainGUI(player);
    }
}
