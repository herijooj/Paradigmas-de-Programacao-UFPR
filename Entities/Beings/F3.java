package Entities.Beings;

// imports

import Entities.Coordinate;
import Board.Board;

// class
public class F3 extends FakeNews {

    // attributes

    // constructor
    public F3(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods

    public void draw() {
        System.out.print("F3");
    }

    @Override
    public boolean move(Board board, int direction) {

        int newI, newJ;
        switch (direction) {
            // goes down-right
            case 1:
                newI = this.position.getI() + 1;
                newJ = this.position.getJ() + 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, newJ))
                    return false;
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                    return true;
                }
                // goes up-right
            case 2:
                newI = this.position.getI() - 1;
                newJ = this.position.getJ() + 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, newJ))
                    return false;
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                    return true;
                }
                // goes down-left
            case 3:
                newI = this.position.getI() + 1;
                newJ = this.position.getJ() - 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, newJ))
                    return false;
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                    return true;
                }
                // goes up-left
            case 4:
                newI = this.position.getI() - 1;
                newJ = this.position.getJ() - 1;
                if (!canMoveToCoordinate(board.getBoard(), newI, newJ))
                    return false;
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                    return true;
                }
        }
        return false;
    }

    public String toString() {
        return "F3";
    }
}
