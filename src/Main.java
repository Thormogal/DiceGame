import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Player> listOfPlayers = DiceGame.transferInitializeToMain();
        for (int i = 0; i < 5; i++) {
            DiceGame.transferTakeTurnToMain(listOfPlayers);
        }

        ArrayList<Player> winners = DiceGame.transferWinnersToMain(listOfPlayers);
        for (Player winner : winners) {
            System.out.println("The winner is: " + winner.getPlayerName());
            System.exit(0);
        }

        ArrayList<Player> players = DiceGame.transferInitializeToMain();
        DiceGame.transferTakeTurnToMain(players);
        ArrayList<Player> theWinners = DiceGame.transferWinnersToMain(players);
    }

}
