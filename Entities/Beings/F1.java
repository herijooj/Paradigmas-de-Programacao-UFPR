package Entities.Beings;

// imports
import Entities.Coordinate;
import Board.Board;
import Cores.Cores;
import java.util.Map;
import java.util.HashMap;

// class
public class F1 extends FakeNews {

    // Constructor
    public F1(Coordinate position, String state) {
        super(position, state);
    }

    // Methods
    
    @Override
    public String move(Board board, int direction) {

        int newI, newJ;
        Coordinate position, randomCoordinate;
        FakeNews newFakeNews;

        // Map the direction to the corresponding coordinate changes
        Map<Integer, Coordinate> directionMap = new HashMap<>();
        directionMap.put(1, new Coordinate(1, 0)); // down
        directionMap.put(2, new Coordinate(-1, 0)); // up
        directionMap.put(3, new Coordinate(0, 1)); // right
        directionMap.put(4, new Coordinate(0, -1)); // left

        // Get the coordinate changes for the given direction
        Coordinate directionCoordinate = directionMap.get(direction);

        // Calculate the new position
        newI = this.position.getI() + directionCoordinate.getI();
        newJ = this.position.getJ() + directionCoordinate.getJ();

        // Check if the new position is valid
        if (!canMoveToCoordinate(board.getBoard(), newI, newJ)) {
            return "dead";
        }

        // Update the position
        position = new Coordinate(newI, newJ);

        // Check if the new position has an item
        if (hasItem(board.getBoard(), position)) {
            // Spawn another fakeNews

            // Generates random coordinate for a new fakeNews to spawn
            randomCoordinate = generateRandomPeriphericCoordinate(position);
            while (hasSomething(board.getBoard(), randomCoordinate))
                randomCoordinate = generateRandomPeriphericCoordinate(position);

            newFakeNews = new F1(randomCoordinate, "RecentlyAdded");

            board.getFakeNews().add(newFakeNews);
            addFakeNewsToSector(board, randomCoordinate, newFakeNews);

            // Add new Item to the board
            board.addItens(1);
        }

        // Update the position
        this.position = position;

        return "moved";
    }

    public String toString() {
        return "F1";
    }
}
