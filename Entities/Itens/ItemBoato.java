package Entities.Itens;

import Entities.Coordinate;
import Board.*;

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
    public void itemAbility(Board board) 
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