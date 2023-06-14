package Entities.Beings;

// imports
import Entities.Coordinate;
import Board.Board;

// class
public class F3 extends FakeNews {

    // Constructor
    public F3(Coordinate position, String state) {
        super(position, state);
    }

    // Methods
    
    @Override
    public String move(Board board, int direction) {

        int newI, newJ;
        Coordinate position, randomCoordinate;
        FakeNews newFakeNews;

        switch (direction) {
            // goes down-right
            case 1:
                newI = this.position.getI() + 1;
                newJ = this.position.getJ() + 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, newJ))
                    return "dead";
                else {
                    position = new Coordinate(newI, newJ);

                    if (hasItem(board.getBoard(), position)) {
                        // Spawn another fakeNews

                        // Generates random coordinate for a new fakeNews to spawn
                        randomCoordinate = generateRandomPeriphericCoordinate(position);
                        while (hasSomething(board.getBoard(), randomCoordinate))
                            randomCoordinate = generateRandomPeriphericCoordinate(position);

                        newFakeNews = new F3(randomCoordinate, "RecentlyAdded");

                        board.getFakeNews().add(newFakeNews);
                        addFakeNewsToSector(board, randomCoordinate, newFakeNews);
                        
                        // Add new Item to the board
                        board.addItens(1);
                    }

                    this.position.setI(newI);
                    this.position.setJ(newJ);
                    return "moved";
                }
                // goes up-right
            case 2:
                newI = this.position.getI() - 1;
                newJ = this.position.getJ() + 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, newJ))
                    return "dead";
                else {
                    position = new Coordinate(newI, newJ);

                    if (hasItem(board.getBoard(), position)) {
                        // Spawn another fakeNews

                        // Generates random coordinate for a new fakeNews to spawn
                        randomCoordinate = generateRandomPeriphericCoordinate(position);
                        while (hasSomething(board.getBoard(), randomCoordinate))
                            randomCoordinate = generateRandomPeriphericCoordinate(position);

                        newFakeNews = new F3(randomCoordinate, "RecentlyAdded");

                        board.getFakeNews().add(newFakeNews);
                        addFakeNewsToSector(board, randomCoordinate, newFakeNews);
                        
                        // Add new Item to the board
                        board.addItens(1);
                    }

                    this.position.setI(newI);
                    this.position.setJ(newJ);
                    return "moved";
                }
                // goes down-left
            case 3:
                newI = this.position.getI() + 1;
                newJ = this.position.getJ() - 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, newJ))
                    return "dead";
                else {
                    position = new Coordinate(newI, newJ);

                    if (hasItem(board.getBoard(), position)) {
                        // Spawn another fakeNews

                        // Generates random coordinate for a new fakeNews to spawn
                        randomCoordinate = generateRandomPeriphericCoordinate(position);
                        while (hasSomething(board.getBoard(), randomCoordinate))
                            randomCoordinate = generateRandomPeriphericCoordinate(position);

                        newFakeNews = new F3(randomCoordinate, "RecentlyAdded");

                        board.getFakeNews().add(newFakeNews);
                        addFakeNewsToSector(board, randomCoordinate, newFakeNews);
                        
                        // Add new Item to the board
                        board.addItens(1);
                    }

                    this.position.setI(newI);
                    this.position.setJ(newJ);
                    return "moved";
                }
                // goes up-left
            case 4:
                newI = this.position.getI() - 1;
                newJ = this.position.getJ() - 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, newJ))
                    return "dead";
                else {
                    position = new Coordinate(newI, newJ);

                    if (hasItem(board.getBoard(), position)) {
                        // Spawn another fakeNews

                        // Generates random coordinate for a new fakeNews to spawn
                        randomCoordinate = generateRandomPeriphericCoordinate(position);
                        while (hasSomething(board.getBoard(), randomCoordinate))
                            randomCoordinate = generateRandomPeriphericCoordinate(position);

                        newFakeNews = new F3(randomCoordinate, "RecentlyAdded");

                        board.getFakeNews().add(newFakeNews);
                        addFakeNewsToSector(board, randomCoordinate, newFakeNews);
                        
                        // Add new Item to the board
                        board.addItens(1);
                    }
                    
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                    return "moved";
                }
        }
        return "dead";
    }

    public String toString() {
        return "F3";
    }
}
