package Entities.Itens;

import Entities.Coordinate;

import java.util.LinkedList;

import Board.*;
import Entities.Beings.*;

// class
public class ItemLer extends ItemCharacteristics {

    // attributes

    // constructor
    public ItemLer(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods
    public void itemAbility(Board board, Player player) {

        // escolhe um inimigo para deletar
        // percorre o board e procura por um inimigo aleatorio
        // seta o state do inimigo para 'dead'

        LinkedList<FakeNews> enemies = board.getFakeNews();
        int randomIndex = (int) (Math.random() * enemies.size());
        enemies.get(randomIndex).setState("dead");
        return;
    }

    public void draw() {
        // TODO
    }

    public String toString() {
        return "Item Ler";
    }
}