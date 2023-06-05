package Entities.Beings;

import java.awt.event.KeyEvent;

// imports
import Entities.Coordinate;

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

    public void move(KeyEvent e) {
        // goes up, down, left or right one position randomly
        int direction = (int) Math.random() * 4 + 1;
        int newI, newJ;

        switch (direction) {
            // goes down
            case 1:
                newI = this.position.getI() + 1;
                if (!checkMovement(newI, this.position.getJ()))
                    this.setAlive(alive = false);
                else
                    this.position.setI(this.position.getI() + 1);
                break;
            // goes up
            case 2:
                newI = this.position.getI() - 1;
                if (!checkMovement(newI, this.position.getJ()))
                    this.setAlive(alive = false);
                else
                    this.position.setI(this.position.getI() - 1);
                break;
            // goes right
            case 3:
                newJ = this.position.getJ() + 1;
                if (!checkMovement(this.position.getI(), newJ))
                    this.setAlive(alive = false);
                else
                    this.position.setJ(this.position.getJ() + 1);
                break;
            // goes left
            case 4:
                newJ = this.position.getJ() - 1;
                if (!checkMovement(this.position.getI(), newJ))
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
