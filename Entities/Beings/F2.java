package Entities.Beings;

// imports
import Entities.Coordinate;
import Board.Board;
import Cores.Cores;

// class
public class F2 extends FakeNews {

    // attributes

    // constructor
    public F2(Coordinate position, String state) {
        super(position, state);
    }

    // getters

    // setters

    // methods

    public void draw() {
        System.out.print("F2");
    }
//
    @Override
    public boolean move(Board board, int direction) {

        int newI, newJ;
        Coordinate position, randomCoordinate;
        FakeNews newFakeNews;

        switch (direction) {
            // goes two down
            case 1:
                newI = this.position.getI() + 2;
                if (!canMoveToCoordinate(board.getBoard(), newI, this.position.getJ())) {
                    return false;
                } else {
                    position = new Coordinate(newI, this.position.getJ());

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

                    this.position.setI(this.position.getI() + 2);
                    return true;
                }
                // goes two up
            case 2:
                newI = this.position.getI() - 2;
                if (!canMoveToCoordinate(board.getBoard(), newI, this.position.getJ())) {
                    return false;
                } else {
                    position = new Coordinate(newI, this.position.getJ());

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

                    this.position.setI(this.position.getI() - 2);
                    return true;
                }
                // goes two right
            case 3:
                newJ = this.position.getJ() + 2;
                if (!canMoveToCoordinate(board.getBoard(), this.position.getI(), newJ)) {
                    return false;
                } else {
                    position = new Coordinate(this.position.getI(), newJ);

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

                    this.position.setJ(this.position.getJ() + 2);
                    return true;
                }
                // goes two left
            case 4:
                newJ = this.position.getJ() - 2;
                if (!canMoveToCoordinate(board.getBoard(), this.position.getI(), newJ)) {
                    return false;
                } else {
                    position = new Coordinate(this.position.getI(), newJ);

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

                    this.position.setJ(this.position.getJ() - 2);
                    return true;
                }
        }
        return false;
    }

    public String toString() {
        return "F2";
    }
}
