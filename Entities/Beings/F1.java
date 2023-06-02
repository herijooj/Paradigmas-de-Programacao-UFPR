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

        // checks if the movement is valid, if not, tries again
        while (!checkMovement(direction)) {
            direction = (int) Math.random() * 4 + 1;
        }

        switch (direction) {
            case 1:
                this.position.setI(this.position.getI() + 1);
                break;
            case 2:
                this.position.setI(this.position.getI() - 1);
                break;
            case 3:
                this.position.setJ(this.position.getJ() + 1);
                break;
            case 4:
                this.position.setJ(this.position.getJ() - 1);
                break;
        }
    }
}
