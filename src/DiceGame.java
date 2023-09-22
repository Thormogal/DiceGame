import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {

        ArrayList<Player> listOfPlayers = initialize();
        for (int i = 0; i < 5; i++) {
            takeTurn(listOfPlayers);
        }

        ArrayList<Player> winners = getWinners(listOfPlayers);
        for (Player winner : winners) {
            System.out.println("The winner is: " + winner.getPlayerName());
        }

    }

    private static ArrayList<Player> initialize() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();


        System.out.println("Hello and welcome to this dice game! " +
                "First of all, how many players are there?");
        int numberOfPlayers = sc.nextInt();

        System.out.println("How many dices should be used in the game?");
        int numberOfDices = sc.nextInt();

        System.out.println("How many sides shall each dice have?");
        int numbersOfSides = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Name for player " + (i + 1) + ":");

            String playerName = sc.nextLine();
            Player player = new Player(playerName);
            for (int j = 0; j < numberOfDices; j++) {
                player.addDice(numbersOfSides);
            }
            players.add(player);
        }
        return players;
    }

    private static void takeTurn(ArrayList<Player> players) {
        Scanner sc = new Scanner(System.in);

        for (Player player : players) {
            System.out.println(player.getPlayerName() + " Guess what the total value of the dices show");
            int playerGuess = sc.nextInt();
            player.rollDice();
            int diceValue = player.getDieValue();
            System.out.println(player.getPlayerName() + " rolled " + diceValue);
            if (playerGuess == diceValue) {
                player.increaseScore();
                System.out.println(player.getPlayerName() + " your guess was right! You now have: " + player.getScore() + " points!");
            }
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();

        int highestScore = 0;
        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }
        for (Player player : players) {
            if (player.getScore() == highestScore) {
                winners.add(player);

            }
        }
        return winners;
    }


    public static ArrayList<Player> transferInitializeToMain() {
        return initialize();
    }

    public static void transferTakeTurnToMain(ArrayList<Player> players) {
        takeTurn(players);
    }
    public static ArrayList<Player> transferWinnersToMain(ArrayList<Player> players){
        return getWinners(players);
    }

}