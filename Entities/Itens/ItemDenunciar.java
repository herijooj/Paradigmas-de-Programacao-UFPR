package Entities.Itens;

import Entities.Coordinate;

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
    public void itemAbility() 
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