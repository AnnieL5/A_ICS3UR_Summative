//import A_ICS3UR_Summative.*;


public class Main {
    static IntroGUI ig;
    static GameGUI gg;
    static MainGUI mg;
    public static void main(String[] args) {
        System.out.println("Hi");
        Player player = new Player();
        ig = new IntroGUI(player);
        ig.setVisible(true);
        gg = new GameGUI(player);
        mg = new MainGUI(player);
    }
}
