package Entities.Beings;

// imports
import Entities.Coordinate;
import Board.Board;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

// class
public class F2 extends FakeNews {

    // Constructor
    public F2(Coordinate position, String state) {
        super(position, state);
    }

    // Methods

    /**
     * Moves the player in the given direction and updates the board accordingly.
     *
     * @param board the board to update
     * @param direction the direction to move in (1 = down, 2 = up, 3 = right, 4 = left)
     * @return a string indicating the result of the move ("moved" if successful, "dead" if the move resulted in death)
     */
    public String move(Board board, int direction) {
        Coordinate position, randomCoordinate;
        FakeNews newFakeNews;

        Map<Integer, BiFunction<Integer, Integer, Coordinate>> directionMap = new HashMap<>();
        directionMap.put(1, (i, j) -> new Coordinate(i + 2, j));
        directionMap.put(2, (i, j) -> new Coordinate(i - 2, j));
        directionMap.put(3, (i, j) -> new Coordinate(i, j + 2));
        directionMap.put(4, (i, j) -> new Coordinate(i, j - 2));

        BiFunction<Integer, Integer, Coordinate> directionFunction = directionMap.getOrDefault(direction, (i, j) -> null);
        if (directionFunction == null) {
            return "dead";
        }

        position = directionFunction.apply(this.position.getI(), this.position.getJ());

        if (!canMoveToCoordinate(board.getBoard(), position.getI(), position.getJ())) {
            return "dead";
        }

        if (hasItem(board.getBoard(), position)) {
            // Spawn another fakeNews

            // Generates random coordinate for a new fakeNews to spawn
            randomCoordinate = generateRandomPeriphericCoordinate(position);
            while (hasSomething(board.getBoard(), randomCoordinate))
                randomCoordinate = generateRandomPeriphericCoordinate(position);

            newFakeNews = new F2(randomCoordinate, "RecentlyAdded");

            board.getFakeNews().add(newFakeNews);
            addFakeNewsToSector(board, randomCoordinate, newFakeNews);

            // Add new Item to the board
            board.addItens(1);
        }

        this.position.setI(position.getI());
        this.position.setJ(position.getJ());
        return "moved";
    }

    public String toString() {
        return "F2";
    }
}
