import java.util.Random;

public class Dice {
    private int currentValue; //Current value
    private int numberOfSides; //Number of sides on the dice
    private static Random rand = new Random(); //Generate a random number

    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public void roll() {
        this.currentValue = rand.nextInt(numberOfSides) + 1;
        //Generates a number between 1 and numberOfSides
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }
}
