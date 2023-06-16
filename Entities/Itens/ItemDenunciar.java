package Entities.Itens;

import Entities.Coordinate;

import java.util.LinkedList;

import Board.*;
import Entities.Beings.*;
import Cores.Cores;

// class
public class ItemDenunciar extends Item {

    // Constructor
    public ItemDenunciar(Coordinate position) {
        super(position);
    }

    // Methods

    /**
     * Executes the ability of an item that eliminates all enemies within a distance of 1 from the player.
     *
     * @param board  The game board.
     * @param player The player using the item.
     */
    public void itemAbility(Board board, Player player) {
        LinkedList<FakeNews> fakeNewsList = board.getFakeNews();

        // create a list of positions, where the position has a distance of 1 from the player
        LinkedList<Coordinate> positions = possiblePositions(player.getPosition());

        // for each position, check if there is a fakeNews
        for (Coordinate position : positions) {
            for (FakeNews fakeNews : fakeNewsList) {
                // If fakeNews is in the area
                if (fakeNews.getPosition().equals(position)) {
                    if (fakeNews.getState().equals("RecentlyAdded") || fakeNews.getState().equals("alive")) {
                        // Set state to outOfGame and setSectorState to nothing there
                        fakeNews.setState("outOfGame");
                        board.getBoard()[fakeNews.getPosition().getI()][fakeNews.getPosition().getJ()].setSectorState("");
                        System.out.printf("Fake news " + Cores.ANSI_RED + "%s " + Cores.ANSI_RESET + "eliminated! :)\n",
                                fakeNews.toString() + 1);
                    }
                    break;
                }
            }
        }
    }


    /**
     * Generates a list of possible positions to move to based on the player's current position.
     *
     * @param position The current position of the player.
     * @return A LinkedList of Coordinate objects representing the possible positions.
     */
    public LinkedList<Coordinate> possiblePositions(Coordinate position) {
        LinkedList<Coordinate> positions = new LinkedList<Coordinate>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // skip the current position
                }
                positions.add(new Coordinate(position.getI() + i, position.getJ() + j));
            }
        }

        return positions;
    }

    public String toString() {
        return "Item Denunciar";
    }
}
