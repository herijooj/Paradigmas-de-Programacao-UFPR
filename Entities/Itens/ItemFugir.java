package Entities.Itens;

import java.util.*;
import Entities.Coordinate;
import Entities.Beings.*;
import Board.Sector;
import Board.*;

// class
public class ItemFugir extends ItemCharacteristics {

    // attributes

    // constructor
    public ItemFugir(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods

    public void draw() {
        // TODO
    }

    /**
     * This item lets the player choose a position to go
     * 
     * @param board  the board
     * @param player the player
     */
    public void itemAbility(Board board, Player player) {

    }

    public String toString() {
        return "Item Fugir";
    }
}
