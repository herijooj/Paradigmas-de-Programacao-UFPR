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
     * This item will kill all the enemies that are in a distance of 1 from the
     * player
     * 
     * @param board  the board
     * @param player the player
     */
    public void itemAbility(Board board, Player player) {
        LinkedList<FakeNews> fakeNewsList = board.getFakeNews();
        int i, j;

        // create a list of positions, where the posistion has distance of 1 from the
        // player
        LinkedList<Coordinate> positions = possiblePositions(player.getPosition());

        // for each position, check if there is a fakeNews
        for (i = 0; i < positions.size(); i++) {
            for (j = 0; j < fakeNewsList.size(); j++) {

                // If fakeNews is in the area
                if (fakeNewsList.get(j).getPosition().getI() == positions.get(i).getI()
                        && fakeNewsList.get(j).getPosition().getJ() == positions.get(i).getJ()) {

                    if (fakeNewsList.get(j).getState() == "RecentlyAdded" || fakeNewsList.get(j).getState() == "alive") {

                        // Set state to outOfGame and setSectorState to nothing there
                        fakeNewsList.get(j).setState("outOfGame");
                        board.getBoard()[fakeNewsList.get(j).getPosition().getI()][fakeNewsList.get(j).getPosition()
                                .getJ()].setSectorState("");
                        System.out.printf("Fake news " + Cores.ANSI_RED + "%d " + Cores.ANSI_RESET + "eliminated! :)\n",
                                j + 1);
                    }
                    break;
                }
            }
        }
    }

    /**
     * Creates a list of possible positions to go
     * based on the player's position
     * 
     * @param position the position of the player
     * @return a list of possible positions
     */
    public LinkedList<Coordinate> possiblePositions(Coordinate position) {
        LinkedList<Coordinate> positions = new LinkedList<Coordinate>();
        positions.add(new Coordinate(position.getI() + 1, position.getJ())); // down
        positions.add(new Coordinate(position.getI() + 1, position.getJ() - 1)); // down-left
        positions.add(new Coordinate(position.getI() + 1, position.getJ() + 1)); // down-right
        positions.add(new Coordinate(position.getI() - 1, position.getJ())); // up
        positions.add(new Coordinate(position.getI() - 1, position.getJ() - 1)); // up-left
        positions.add(new Coordinate(position.getI() - 1, position.getJ() + 1)); // up-right
        positions.add(new Coordinate(position.getI(), position.getJ() + 1)); // right
        positions.add(new Coordinate(position.getI() - 1, position.getJ() + 1)); // right-up
        positions.add(new Coordinate(position.getI() + 1, position.getJ() + 1)); // right
        positions.add(new Coordinate(position.getI(), position.getJ() - 1)); // left
        positions.add(new Coordinate(position.getI() - 1, position.getJ() - 1)); // left-up
        positions.add(new Coordinate(position.getI() + 1, position.getJ() - 1)); // left-down

        return positions;
    }

    public String toString() {
        return "Item Denunciar";
    }
}
