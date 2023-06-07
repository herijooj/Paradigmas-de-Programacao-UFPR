package Entities.Itens;

import Entities.Coordinate;
import Board.*;
import Entities.Beings.*;

// class
public class ItemBoato extends ItemCharacteristics {

    // attributes
    
    // constructor
    public ItemBoato (Coordinate position) 
    {
        super(position);
    }
    
    // getters
    
    // setters

    // methods
    public void itemAbility(Board board, Player player) 
    {
        // proximo turno de forma aleatoria
    }

    public void draw()
    {
        // TODO
    }

    public String toString() 
    {
        return "Item Boato";
    }
}