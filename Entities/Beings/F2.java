package Entities.Beings;

// imports
import Entities.Coordinate;
import Board.Board;
import Cores.Cores;

// class
public class F2 extends FakeNews {

    // Constructor
    public F2(Coordinate position, String state) {
        super(position, state);
    }

    // Methods

    @Override
    public String move(Board board, int direction) {
        int newI, newJ;
        Coordinate position, randomCoordinate;
        FakeNews newFakeNews;

        switch (direction) {
            case 1: // goes two down
                newI = this.position.getI() + 2;
                position = new Coordinate(newI, this.position.getJ());
                break;
            case 2: // goes two up
                newI = this.position.getI() - 2;
                position = new Coordinate(newI, this.position.getJ());
                break;
            case 3: // goes two right
                newJ = this.position.getJ() + 2;
                position = new Coordinate(this.position.getI(), newJ);
                break;
            case 4: // goes two left
                newJ = this.position.getJ() - 2;
                position = new Coordinate(this.position.getI(), newJ);
                break;
            default:
                return "dead";
        }

        if (!canMoveToCoordinate(board.getBoard(), position.getI(), position.getJ()))
            return "dead";

        if (hasItem(board.getBoard(), position)) {
            // Spawn another fakeNews
            randomCoordinate = generateRandomPeriphericCoordinate(position);
            while (hasSomething(board.getBoard(), randomCoordinate))
                randomCoordinate = generateRandomPeriphericCoordinate(position);

            newFakeNews = new F2(randomCoordinate, "RecentlyAdded");

            board.getFakeNews().add(newFakeNews);
            addFakeNewsToSector(board, randomCoordinate, newFakeNews);

            // Add new Item to the board
            board.addItens(1);
        }

        if (direction == 1)
            this.position.setI(this.position.getI() + 2);
        else if (direction == 2)
            this.position.setI(this.position.getI() - 2);
        else if (direction == 3)
            this.position.setJ(this.position.getJ() + 2);
        else if (direction == 4)
            this.position.setJ(this.position.getJ() - 2);

        return "moved";
    }

    public String toString() {
        return "F2";
    }
}
