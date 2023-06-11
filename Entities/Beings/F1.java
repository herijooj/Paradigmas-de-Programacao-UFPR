package Entities.Beings;

// imports
import Entities.Coordinate;
import Board.Board;
import Cores.Cores;

// class
public class F1 extends FakeNews {

    // attributes

    // constructor
    public F1(Coordinate position, String state) {
        super(position, state);
    }

    // getters

    // setters

    // methods

    public void draw() {
        System.out.print("F1");
    }
//
    @Override
    public String move(Board board, int direction) {

        int newI, newJ;
        Coordinate position, randomCoordinate;
        FakeNews newFakeNews;

        switch (direction) {
            // goes down
            case 1:
                System.out.println("DOWN");
                newI = this.position.getI() + 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, this.position.getJ())) {
                    return "dead";
                } else {
                    position = new Coordinate(newI, this.position.getJ());

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

                    this.position.setI(this.position.getI() + 1);
                    return "moved";
                }
                // goes up
            case 2:
                System.out.println("UP");
                newI = this.position.getI() - 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, this.position.getJ())) {
                    return "dead";
                } else {
                    position = new Coordinate(newI, this.position.getJ());

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

                    this.position.setI(this.position.getI() - 1);
                    return "moved";
                }
                // goes right
            case 3:
                System.out.println("RIGHT");
                newJ = this.position.getJ() + 1;
                if (!canMoveToCoordinate(board.getBoard(), this.position.getI(), newJ)) {
                    return "dead";
                } else {
                    position = new Coordinate(this.position.getI(), newJ);

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

                    this.position.setJ(this.position.getJ() + 1);
                    return "moved";
                }
                // goes left
            case 4:
                System.out.println("LEFT");
                newJ = this.position.getJ() - 1;
                if (!canMoveToCoordinate(board.getBoard(), this.position.getI(), newJ)) {
                    return "dead";
                } else {
                    position = new Coordinate(this.position.getI(), newJ);

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
                    this.position.setJ(this.position.getJ() - 1);
                    return "moved";
                }
        }
        return "dead";
    }

    public String toString() {
        return "F1";
    }
}
