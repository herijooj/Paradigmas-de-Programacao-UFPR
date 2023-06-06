package Entities.Beings;

// imports
import java.awt.event.KeyEvent;
import java.util.*;

import Entities.Coordinate;
import Board.Sector;

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

    public void move(Sector[][] board, LinkedList<FakeNews> fakeNews, KeyEvent e, int direction) {

        int newI, newJ;
        switch (direction) {
            // goes down-right
            case 1:
                newI = this.position.getI() + 1;
                newJ = this.position.getJ() + 1;
                if (!checkMovement(board, newI, newJ))
                    fakeNews.remove(this);
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                }
                break;
            // goes up-right
            case 2:
                newI = this.position.getI() - 1;
                newJ = this.position.getJ() + 1;
                if (!checkMovement(board, newI, newJ))
                    fakeNews.remove(this);
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                }
                break;
            // goes down-left
            case 3:
                newI = this.position.getI() + 1;
                newJ = this.position.getJ() - 1;
                if (!checkMovement(board, newI, newJ))
                    fakeNews.remove(this);
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                }
                break;
            // goes up-left
            case 4:
                newI = this.position.getI() - 1;
                newJ = this.position.getJ() - 1;
                if (!checkMovement(board, newI, newJ))
                    fakeNews.remove(this);
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                }
                break;
        }
    }

    public String toString() {
        return "F3";
    }
}