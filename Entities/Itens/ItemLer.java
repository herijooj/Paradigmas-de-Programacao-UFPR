package Entities.Itens;

import java.util.LinkedList;

import Entities.Coordinate;
import Board.*;
import Entities.Beings.*;
import Cores.Cores;

// class
public class ItemLer extends ItemCharacteristics {

    // Constructor
    public ItemLer(Coordinate position) {
        super(position);
    }

    // Methods
    /**
     * This item deletes a random enemy from the board
     * 
     * @param board  the board
     * @param player the player
     */
    public void itemAbility(Board board, Player player) {
        // extracting enemies
        LinkedList<FakeNews> enemies = board.getFakeNews();

        // if there is no enemies, return
        int randomIndex = (int) (Math.random() * enemies.size());

        // while the enemy is not alive, get another random index
        while (enemies.get(randomIndex).getState() != "alive" && enemies.get(randomIndex).getState() != "RecentlyAdded")
            randomIndex = (int) (Math.random() * enemies.size());

        // kill the enemy
        board.getBoard()[enemies.get(randomIndex).getPosition().getI()][enemies.get(randomIndex).getPosition().getJ()].setSectorState("");
        enemies.get(randomIndex).setState("outOfGame");
        System.out.printf("Fake news " + Cores.ANSI_RED + "%d " + Cores.ANSI_RESET + "eliminated! :)\n", randomIndex + 1);
        return;
    }

    public String toString() {
        return "Item Ler";
    }
}
