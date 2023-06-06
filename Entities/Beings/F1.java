package Entities.Beings;

import java.awt.event.KeyEvent;
import java.util.*;

// imports
import Entities.Coordinate;
import Board.Sector;

// class
public class F1 extends FakeNews {

    // attributes

    // constructor
    public F1(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods

    public void draw() {
        System.out.print("F1");
    }

    public boolean move(Sector[][] board, LinkedList<FakeNews> fakeNews, KeyEvent e, int direction) {

        int newI, newJ;

        // System.out.println("ccc");

        switch (direction) {
            // goes down
            case 1:
                System.out.println("DOWN");
                newI = this.position.getI() + 1;
                if (!checkMovement(board, newI, this.position.getJ())) {
                    fakeNews.remove(this);
                    fakeNews.add(null);
                    return false;
                } else {
                    this.position.setI(this.position.getI() + 1);
                    return true;
                }
                // goes up
            case 2:
                System.out.println("UP");
                newI = this.position.getI() - 1;
                if (!checkMovement(board, newI, this.position.getJ())) {
                    fakeNews.remove(this);
                    fakeNews.add(null);
                    return false;
                } else {
                    this.position.setI(this.position.getI() - 1);
                    return true;
                }
                // goes right
            case 3:
                System.out.println("RIGHT");
                newJ = this.position.getJ() + 1;
                if (!checkMovement(board, this.position.getI(), newJ)) {
                    fakeNews.remove(this);
                    fakeNews.add(null);
                    return false;
                } else {
                    this.position.setJ(this.position.getJ() + 1);
                    return true;
                }
                // goes left
            case 4:
                System.out.println("LEFT");
                newJ = this.position.getJ() - 1;
                if (!checkMovement(board, this.position.getI(), newJ)) {
                    fakeNews.remove(this);
                    fakeNews.add(null);
                    return false;
                } else {
                    this.position.setJ(this.position.getJ() - 1);
                    return true;
                }
        }
        return false;
    }

    public String toString() {
        return "F1";
    }
}
