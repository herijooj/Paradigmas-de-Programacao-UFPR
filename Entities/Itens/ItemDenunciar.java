package Entities.Itens;

import Entities.Coordinate;

import java.util.LinkedList;

import Board.*;
import Entities.Beings.*;
import Cores.Cores;

// class
public class ItemDenunciar extends ItemCharacteristics {

    // attributes

    // constructor
    public ItemDenunciar(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods
    /**
     * This item will kill all the enemies that are in a distance of 1 from the
     * player
     * 
     * @param board  the board
     * @param player the player
     */
    public void itemAbility(Board board, Player player) {
        LinkedList<FakeNews> fakeNewsList = board.getFakeNews();

        // create a list of positions, where the posistion has distance of 1 from the
        // player
        LinkedList<Coordinate> positions = new LinkedList<Coordinate>();
        positions.add(new Coordinate(player.getPosition().getI() + 1, player.getPosition().getJ())); // down
        positions.add(new Coordinate(player.getPosition().getI() + 1, player.getPosition().getJ() - 1)); // down-left
        positions.add(new Coordinate(player.getPosition().getI() + 1, player.getPosition().getJ() + 1)); // down-right
        positions.add(new Coordinate(player.getPosition().getI() - 1, player.getPosition().getJ())); // up
        positions.add(new Coordinate(player.getPosition().getI() - 1, player.getPosition().getJ() - 1)); // up-left
        positions.add(new Coordinate(player.getPosition().getI() - 1, player.getPosition().getJ() + 1)); // up-right
        positions.add(new Coordinate(player.getPosition().getI(), player.getPosition().getJ() + 1)); // right
        positions.add(new Coordinate(player.getPosition().getI() - 1, player.getPosition().getJ() + 1)); // right-up
        positions.add(new Coordinate(player.getPosition().getI() + 1, player.getPosition().getJ() + 1)); // right
        positions.add(new Coordinate(player.getPosition().getI(), player.getPosition().getJ() - 1)); // left
        positions.add(new Coordinate(player.getPosition().getI() - 1, player.getPosition().getJ() - 1)); // left-up
        positions.add(new Coordinate(player.getPosition().getI() + 1, player.getPosition().getJ() - 1)); // left-down

        // for each position, check if there is a fakeNews
        for (Coordinate position : positions) {
            for (FakeNews fakeNews : fakeNewsList) {
                if (fakeNews.getPosition().equals(position)) {
                    // check state of the fakeNews
                    if (fakeNews.getState().equals("RecentlyAdded") || fakeNews.getState().equals("alive")) {
                        fakeNews.setState("dead");
                        System.out.printf("Fake news " + Cores.ANSI_RED + "%d " + Cores.ANSI_RESET + "died! :)\n",
                                fakeNewsList.indexOf(fakeNews));

                    }
                    break;
                }
            }
            // PODEMOS FAZER DESENHAR UMA EXPLOSÃO AQUI
        }

        // deleta todos os inimigos ao redor do jogador
        // recebe um vetor e checa a posição de cada inimigo
    }

    public void draw() {
        // TODO
    }

    public String toString() {
        return "Item Denunciar";
    }
}