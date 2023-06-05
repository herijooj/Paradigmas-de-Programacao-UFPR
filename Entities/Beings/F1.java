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
        int direction = (int) (Math.random() * 4) + 1;
        int newI, newJ;

        //System.out.println("ccc");

        switch (direction) {
            // goes down
            case 1:
            System.out.println("DOWN");
                newI = this.position.getI() + 1;
                if (!checkMovement(newI, this.position.getJ()))
                    this.setAlive(alive = false);
                else
                    this.position.setI(this.position.getI() + 1);
                break;
            // goes up
            case 2:
            System.out.println("UP");
                newI = this.position.getI() - 1;
                if (!checkMovement(newI, this.position.getJ()))
                    this.setAlive(alive = false);
                else
                    this.position.setI(this.position.getI() - 1);
                break;
            // goes right
            case 3:
            System.out.println("RIGHT");
                newJ = this.position.getJ() + 1;
                if (!checkMovement(this.position.getI(), newJ))
                    this.setAlive(alive = false);
                else
                    this.position.setJ(this.position.getJ() + 1);
                break;
            // goes left
            case 4:
            System.out.println("LEFT");
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
