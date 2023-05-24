
import Board.*;
import Sector.*;
import Cores.*;

public class Main {

    //function to generate random number
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void main(String[] args) {
        // System.out.println(Cores.ANSI_RED + "Red text" + Cores.ANSI_RESET);
        // System.out.println(Cores.ANSI_BLUE + "Blue text" + Cores.ANSI_RESET);
        // System.out.println(Cores.ANSI_YELLOW_BACKGROUND + "Yellow background"
        // + Cores.ANSI_RESET);

        Board board = new Board(9);

        board.drawBoard();
    }
}