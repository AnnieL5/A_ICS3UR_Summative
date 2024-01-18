
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class GameGGrid extends JPanel implements ItemListener{
    private final int NUM = 4;//number of checkboxs
    private JLabel jLabel;
    private JCheckBox[] jCheckBoxs;
    private String[] label = {"", "", "", ""};
    private GameElement[] gameElement;
    private GameElement[] selectedElements;
    private int count = 0;
    private final int MAXITEMSELECT = 2;
    private final int MINLEVELGENERATED = 1, MAXLEVELGENERATED = 3; 
    private final int COSTOFELEMENT = 10;
    private Player player;

    public GameGGrid(Player player){

        setVisible(true);
        setBounds(0,0,200,200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 4));

        this.player = player;

        jCheckBoxs = new JCheckBox[NUM];
        gameElement = new GameElement[NUM];
        selectedElements = new GameElement[NUM];

        gameElement[0] = getElement(MINLEVELGENERATED, MAXLEVELGENERATED);
        gameElement[1] = getElement(MINLEVELGENERATED, MAXLEVELGENERATED);
        gameElement[2] = getElement(MINLEVELGENERATED, MAXLEVELGENERATED);
        gameElement[3] = getElement(MINLEVELGENERATED, MAXLEVELGENERATED);
        
        //Add the top row: Label
        jLabel = new JLabel("<html>Select two items");
        this.add(jLabel);

        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        for(int i=0; i<NUM; i++)
        {
            jCheckBoxs[i] = new JCheckBox(gameElement[i].toString());
            System.out.println(gameElement[i].toString());
            jCheckBoxs[i].addItemListener(this);
            this.add(jCheckBoxs[i]);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        for(int i=0; i<NUM; i++){
            if(e.getSource() == jCheckBoxs[i])
            {
                if(e.getStateChange() ==1){
                    if(count<MAXITEMSELECT){
                        count++;
                        selectedElements[i] = gameElement[i];
                        //System.out.println(str);
                        //str.replaceAll(str, "Obj"+String.valueOf(num));
                        label[i] = gameElement[i].toString()+" ";
                        //System.out.println(str);
                    }
                    else{
                        System.out.println("You can't choose more than 2");
                        jCheckBoxs[i].setSelected(false);
                        count++;
                    }
                    
                }
                else{//deselect
                    selectedElements[i] = null;
                    label[i]="";
                    count--;
                }
            }
        }
        //Change the label
        String text = "";
        for (String line:label){
            text += line;
        }
        jLabel.setText("<html>Item selected: "+text);
    }

    public void combineElements(){
        System.out.println("Here");
        if(count == 2)
        {
            if(player.getValue("money")>COSTOFELEMENT)
            {
                int selected;
                System.out.println("Here");
                for(int i=0; i<NUM; i++)
                {
                    if(selectedElements[i] != null)
                    {   
                        System.out.println("Here");
                        selected = i;
                        for(int j=i+1; i<NUM; j++)
                        {
                            if(selectedElements[j] != null)
                            {
                                System.out.println("Here");
                                if(selectedElements[j].equals(selectedElements[selected]))
                                {   upgrade(selectedElements[i], selectedElements[j], i, j);}
                                else{
                                    JOptionPane.showMessageDialog(null,"Please select object of the same type.");
                                }
                                break;
                            }
                        } 
                        break;
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"You do not have enough money (over 15)");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"You must select two checkboxs.");
        }
    }
    private void upgrade(GameElement e1, GameElement e2, int index1, int index2){
        //new
        System.out.println("Here");
        gameElement[index1] = new GameElement(e1.getLevel()+1, e1.getSet());
        jCheckBoxs[index1].setText(gameElement[index1].toString());
        jCheckBoxs[index1].setSelected(false);
        MainGUI.topLabelSetText();

        generateNewElement(index2);

        //System.out.println("Here");
    }
    public GameElement getRandomGRIDElement()
    {
        return gameElement[(int)(Math.random()*NUM)];
    }
    public GameElement getElement(int MINLEVELGENERATED, int MAXLEVELGENERATED)
    {
        player.setIncrement("money", -1*COSTOFELEMENT);
        return GameConstant.getRandomElement(MINLEVELGENERATED, MAXLEVELGENERATED);
    }
    public void sell()
    {
        if(count == 1){
            for(int i=0; i<NUM; i++){
                if(selectedElements[i] != null){
                    int price = selectedElements[i].getPrice();
                    System.out.println(price);
                    player.setIncrement("money", price);
                    generateNewElement(i);
                }
            }
        }
    }
    public void generateNewElement(int spot)
    {
        gameElement[spot] = getElement(MINLEVELGENERATED, MAXLEVELGENERATED);
        jCheckBoxs[spot].setText(gameElement[spot].toString());
        jCheckBoxs[spot].setSelected(false);
        MainGUI.topLabelSetText();
    }
    public boolean submitMission(GameElement element){
        if(count==1)
        {
            System.out.println(count);
            for(int i=0; i<NUM; i++)
            {
                if(selectedElements[i] != null && selectedElements[i].equals(element))
                {   
                    player.setIncrement("maple leaves", element.getPrice());
                    generateNewElement(i);
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null,"The elements do not match.");
            return false;
        }
        else{
            JOptionPane.showMessageDialog(null,"You can only select 1 checkbox.");
            return false;
        }
    }
    /*
    public static void main(String[] args) {
        new GUIGridPaneln();
    }
    */
}
