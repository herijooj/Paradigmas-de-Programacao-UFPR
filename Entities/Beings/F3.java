package Entities.Beings;

// imports
import Entities.Coordinate;
import java.awt.event.KeyEvent;

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

    public void move(KeyEvent e) {
        // goes up-left, up-right, down-left or down-right one position randomly
        int direction = (int) Math.random() * 4 + 1;
        int newI, newJ;
        switch (direction) {
            // goes down-right
            case 1:
                newI = this.position.getI() + 1;
                newJ = this.position.getJ() + 1;
                if (!checkMovement(newI, newJ))
                    this.setAlive(alive = false);
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                }
                break;
            // goes up-right
            case 2:
                newI = this.position.getI() - 1;
                newJ = this.position.getJ() + 1;
                if (!checkMovement(newI, newJ))
                    this.setAlive(alive = false);
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                }
                break;
            // goes down-left
            case 3:
                newI = this.position.getI() + 1;
                newJ = this.position.getJ() - 1;
                if (!checkMovement(newI, newJ))
                    this.setAlive(alive = false);
                else {
                    this.position.setI(newI);
                    this.position.setJ(newJ);
                }
                break;
            // goes up-left
            case 4:
                newI = this.position.getI() - 1;
                newJ = this.position.getJ() - 1;
                if (!checkMovement(newI, newJ))
                    this.setAlive(alive = false);
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