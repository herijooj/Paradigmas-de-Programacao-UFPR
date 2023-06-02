package Entities.Beings;

import Entities.Coordinate;
import Entities.Entity;
import java.awt.event.KeyEvent;

public class Player extends Entity implements Movement {
    // attributes
    private int playerNum;

    // constructor
    public Player(int playerNum, Coordinate position) {
        super(position);
        this.setPlayerNum(playerNum);
    }

    // getters
    int getPlayerNum() {
        return this.playerNum;
    }

    // setters
    void setPlayerNum(int playerNum) {
        if (playerNum < 1 || playerNum > 4)
            throw new IllegalArgumentException("Player number must be between 1 and 4");

        this.playerNum = playerNum;
    }

    // methods
    public void draw() {
        System.out.printf("F%d", this.playerNum);
    }

    public void move(KeyEvent e) {
        // check if the input was an arrow keyCode
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                Coordinate positionToGo = new Coordinate(this.position.getI() - 1, this.position.getJ());
                if (positionToGo.Isvalid())
                    break;

            default:
                // TODO: show error message and try again
                break;
        }

    }
}