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

        // escolhe se o proximo turno sera do player ou do inimigo
        int random = (int) (Math.random() * 2);

        // se for 0, o proximo turno sera do player
        if (random == 0) 
        {
            // escolhe uma direcao aleatoria
            random = (int) (Math.random() * 4);
            // escolhe um player aleatorio
            int randomPlayer = (int) (Math.random() * board.getPlayers().size());
            board.movePlayer(random, randomPlayer);
        }
        // se for 1, o proximo turno sera do inimigo
        else 
        {
            // escolhe uma direcao aleatoria
            random = (int) (Math.random() * 4);
            // escolhe um inimigo aleatorio
            int randomEnemy = (int) (Math.random() * board.getFakeNews().size());
            board.moveIndividualFakeNews(randomEnemy);
        }
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