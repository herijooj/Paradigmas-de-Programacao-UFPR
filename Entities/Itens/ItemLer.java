package Entities.Itens;

import Entities.Coordinate;
import Board.*;
import Entities.Beings.*;

// class
public class ItemLer extends ItemCharacteristics {

    // attributes
    
    // constructor
    public ItemLer (Coordinate position) 
    {
        super(position);
    }
    
    // getters
    
    // setters

    // methods
    public void itemAbility(Board board, Player player) 
    {
        // escolhe um inimigo para deletar
    }

    public void draw()
    {
        // TODO
    }

    public String toString() 
    {
        return "Item Ler";
    }
}