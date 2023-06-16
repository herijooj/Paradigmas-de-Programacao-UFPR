package Entities.Itens;

import Entities.Coordinate;
import Board.*;
import Entities.Beings.*;

// class
public class ItemBoato extends Item {

    // Constructor
    public ItemBoato(Coordinate position) {
        super(position);
    }

    /**
     * Executes the ability of an item that randomly chooses a direction for the player to move in the next turn.
     *
     * @param board  The game board.
     * @param player The player using the item.
     */
    public void itemAbility(Board board, Player player) {
        // This ability is automatically used in the movePlayers function
    }

    public String toString() {
        return "Item Boato";
    }
}
