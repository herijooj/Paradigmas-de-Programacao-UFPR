package Entities.Itens;

import Entities.Coordinate;
import Board.*;
import Entities.Beings.*;

// class
public class ItemBoato extends ItemCharacteristics {

    // attributes

    // constructor
    public ItemBoato(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    /**
     * it will choose a random direction for the player to move in the next turn
     * 
     * @param board
     * @param player the player
     */
    public void itemAbility(Board board, Player player) {
        // Used automatically in the movePlayers function
    }

    public void draw() {
    }

    public String toString() {
        return "Item Boato";
    }
}
