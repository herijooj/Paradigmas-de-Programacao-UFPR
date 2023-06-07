package Entities.Itens;

import Entities.Coordinate;
import Board.*;

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
    public void itemAbility(Board board) 
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