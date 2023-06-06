package Entities.Beings;

// imports
import java.util.*;
import java.awt.event.KeyEvent;

import Entities.Coordinate;
import Board.Sector;

// class
public class F2 extends FakeNews {

    // attributes

    // constructor
    public F2(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods

    public void draw() {
        System.out.print("F2");
    }

    public void move(Sector[][] board, LinkedList<FakeNews> fakeNews, KeyEvent e, int direction) {

        int newI, newJ;
        switch (direction) {
            // goes two down
            case 1:
                newI = this.position.getI() + 2;
                if (!checkMovement(board, newI, this.position.getJ()))
                    fakeNews.remove(this);
                else
                    this.position.setI(this.position.getI() + 2);
                break;
            // goes two up
            case 2:
                newI = this.position.getI() - 2;
                if (!checkMovement(board, newI, this.position.getJ()))
                    fakeNews.remove(this);
                else
                    this.position.setI(this.position.getI() - 2);
                break;
            // goes two right
            case 3:
                newJ = this.position.getJ() + 2;
                if (!checkMovement(board, this.position.getI(), newJ))
                    fakeNews.remove(this);
                else
                    this.position.setJ(this.position.getJ() + 2);
                break;
            // goes two left
            case 4:
                newJ = this.position.getJ() - 2;
                if (!checkMovement(board, this.position.getI(), newJ))
                    fakeNews.remove(this);
                else
                    this.position.setJ(this.position.getJ() - 2);
                break;
        }
    }

    public String toString() {
        return "F2";
    }
}