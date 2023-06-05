package Entities.Beings;

import java.awt.event.KeyEvent;

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

    public void move(Sector[][] board, KeyEvent e, int direction) {

        int newI, newJ;

        // System.out.println("ccc");

        switch (direction) {
            // goes down
            case 1:
                System.out.println("DOWN");
                newI = this.position.getI() + 1;
                if (!checkMovement(board, newI, this.position.getJ()))
                    this.setAlive(alive = false);
                else
                    this.position.setI(this.position.getI() + 1);
                break;
            // goes up
            case 2:
                System.out.println("UP");
                newI = this.position.getI() - 1;
                if (!checkMovement(board, newI, this.position.getJ()))
                    this.setAlive(alive = false);
                else
                    this.position.setI(this.position.getI() - 1);
                break;
            // goes right
            case 3:
                System.out.println("RIGHT");
                newJ = this.position.getJ() + 1;
                if (!checkMovement(board, this.position.getI(), newJ))
                    this.setAlive(alive = false);
                else
                    this.position.setJ(this.position.getJ() + 1);
                break;
            // goes left
            case 4:
                System.out.println("LEFT");
                newJ = this.position.getJ() - 1;
                if (!checkMovement(board, this.position.getI(), newJ))
                    this.setAlive(alive = false);
                else
                    this.position.setJ(this.position.getJ() - 1);
                break;
        }
    }

    public String toString() {
        return "F1";
    }
}
