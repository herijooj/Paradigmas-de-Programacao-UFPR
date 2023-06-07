package Entities.Beings;

// imports
import java.util.*;
import java.awt.event.KeyEvent;

import Entities.Coordinate;
import Board.Sector;
import Cores.Cores;

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

    public boolean move(Sector[][] board, LinkedList<FakeNews> fakeNews, KeyEvent e, int direction) {

        int newI, newJ;
        switch (direction) {
            // goes two down
            case 1:
                newI = this.position.getI() + 2;
                if (!checkMovement(board, newI, this.position.getJ())) {
                    System.out.println("A FakeNews has " + Cores.ANSI_GREEN + "Died!" + Cores.ANSI_RESET);
                    //fakeNews.remove(this);
                    //fakeNews.add(null);
                    return false;
                } else {
                    this.position.setI(this.position.getI() + 2);
                    return true;
                }
                // goes two up
            case 2:
                newI = this.position.getI() - 2;
                if (!checkMovement(board, newI, this.position.getJ())) {
                    System.out.println("A FakeNews has " + Cores.ANSI_GREEN + "Died!" + Cores.ANSI_RESET);
                    //fakeNews.remove(this);
                    //fakeNews.add(null);
                    return false;
                } else {
                    this.position.setI(this.position.getI() - 2);
                    return true;
                }
                // goes two right
            case 3:
                newJ = this.position.getJ() + 2;
                if (!checkMovement(board, this.position.getI(), newJ)) {
                    System.out.println("A FakeNews has " + Cores.ANSI_GREEN + "Died!" + Cores.ANSI_RESET);
                    //fakeNews.remove(this);
                    //fakeNews.add(null);
                    return false;
                } else {
                    this.position.setJ(this.position.getJ() + 2);
                    return true;
                }
                // goes two left
            case 4:
                newJ = this.position.getJ() - 2;
                if (!checkMovement(board, this.position.getI(), newJ)) {
                    System.out.println("A FakeNews has " + Cores.ANSI_GREEN + "Died!" + Cores.ANSI_RESET);
                    //fakeNews.remove(this);
                    //fakeNews.add(null);
                    return false;
                } else {
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
