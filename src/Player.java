import java.util.ArrayList;

public class Player {

    private String playerName;
    private int score;
    private ArrayList<Dice> diceList;

    public Player(String playerName){
        this.playerName = playerName;
        this.score = 0;
        this.diceList = new ArrayList<Dice>();
    }

    public void rollDice() {
        for (Dice dice : diceList) {
            dice.roll();
        }
    }
    public int getDieValue(){
        int total = 0;
        for(Dice dice : diceList) {
            total += dice.getCurrentValue();
        }
        return total;
    }
    public void increaseScore(){
        this.score++;
    }
    public void addDice(int sides) {
        diceList.add(new Dice(sides));
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }
}