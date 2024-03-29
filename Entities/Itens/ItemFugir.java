package Entities.Itens;

import java.util.*;
import Entities.Coordinate;
import Entities.Beings.*;
import Board.*;

// class
public class ItemFugir extends Item {

    // Constructor
    public ItemFugir(Coordinate position) {
        super(position);
    }

    // Methods

    /**
     * Checks if a given position is valid on the board.
     *
     * @param board The game board.
     * @param input The position to be checked.
     * @return {@code true} if the position is valid, {@code false} otherwise.
     */
    public boolean validPosition(Board board, int input) {

        // Verifies if it is in the board
        if (input < 0 || input > 88)
            return false;

        // Verifies if the selected sector is invalid
        if (board.getBoard()[input / 10][input % 10].getSectorState() != "")
            return false;

        // If it got here, means its available
        return true;
    }

    /**
     * Executes the ability of an item for a player, allowing them to move to a specified position on the board.
     *
     * @param board  The game board.
     * @param player The player who is using the item.
     */
    public void itemAbility(Board board, Player player) {
        Scanner sc = new Scanner(System.in);
        int input;
        Coordinate newCoordinate;

        System.out.println("Player " + player.getPlayerNum() + " type a position to go:");
        System.out.println("Format: [LineNumber][ColumnNumber], example: 12");
        input = sc.nextInt();
        sc.nextLine();

        while (!validPosition(board, input)) {
            System.out.println("Cant move to that position, type again: ");
            input = sc.nextInt();
            sc.nextLine();
        }

        // Clear old position
        board.getBoard()[player.getPosition().getI()][player.getPosition().getJ()].setSectorState("");

        // Change to new position
        newCoordinate = new Coordinate(input / 10, input % 10);
        player.setPosition(newCoordinate);

        // Update the sectorState
        board.getBoard()[newCoordinate.getI()][newCoordinate.getJ()].setSectorState(player.toString());

        System.out.println("Player " + player.getPlayerNum() + " moved!");
    }

    public String toString() {
        return "Item Fugir";
    }
}
