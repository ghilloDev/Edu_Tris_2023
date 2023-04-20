import engine.Coords;
import engine.Game;
import engine.Tools;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Game game = new Game(Game.PLAYER_1);

        while (!game.hasWinner() && !game.hasDraw()) {
            Tools.printToConsole(game.getGrid(), "Status");
            System.out.println("Muovi mossa giocatore " + Tools.gridToText(game.getPlayer()));

            int num = s.nextInt();
            if(num<=9) {
                Coords move = new Coords(num);
                if (Tools.getGridValue(game.getGrid(), move) != 0)
                    System.out.println("Errore");
                else {
                    System.out.println(move);
                    game.move(move);
                }
            } else
                Game.suggestMove(game.getGrid(), game.getPlayer());
        }
        if (game.hasWinner())
            Tools.printToConsole(game.getGrid(), "VINCITORE");
        else if (game.hasDraw())
            Tools.printToConsole(game.getGrid(), "PATTA");
    }

}