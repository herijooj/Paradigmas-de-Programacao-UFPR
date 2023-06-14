package Entities.Itens;

import java.util.*;
import Entities.Coordinate;
import Entities.Beings.*;
import Board.*;

// class
public class ItemFugir extends ItemCharacteristics {

    // Constructor
    public ItemFugir(Coordinate position) {
        super(position);
    }

    // Methods

    /**
     * Verifies if a given position is valid
     *
     * returns true if it is, false if it isnt
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
     * This item lets the player choose a position to go
     * 
     * @param board  the board
     * @param player the player
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

        sc.close();
    }

    public String toString() {
        return "Item Fugir";
    }
}
