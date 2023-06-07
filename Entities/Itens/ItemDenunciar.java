package Entities.Itens;

import Entities.Coordinate;
import Board.*;
import Entities.Beings.*;

// class
public class ItemDenunciar extends ItemCharacteristics {

    // attributes
    
    // constructor
    public ItemDenunciar (Coordinate position) 
    {
        super(position);
    }
    
    // getters
    
    // setters

    // methods
    public void itemAbility(Board board, Player player) 
    {
        // deleta todos os inimigos ao redor do jogador
        // recebe um vetor e checa a posição de cada inimigo
    }

    public void draw()
    {
        // TODO
    }

    public String toString() 
    {
        return "Item Denunciar";
    }
}