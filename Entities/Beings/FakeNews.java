package Entities.Beings;

import java.awt.event.KeyEvent;
import java.util.*;

// imports
import Entities.Coordinate;
import Entities.Entity;
import Board.Board;

// class
public abstract class FakeNews extends Entity implements Movement {

    // attributes
    protected String state;

    // constructor
    public FakeNews(Coordinate position) {
        super(position);
        this.setState("alive");
    }

    // getters
    public String getState() {
        return this.state;
    }

    // setters
    public void setState(String state) {
        if (state != "alive" && state != "dead" && state != "outOfGame")
            throw new IllegalArgumentException("Invalid state, valids: [alive, dead and outOfGame]");
        else
            this.state = state;
    }

    // methods

    /**
     * will try and move the fake news in the direction of the key pressed
     * 
     * @param board     the Board of the game
     * @param direction the direction of the movement
     * 
     */
    public abstract boolean move(Board board, int direction);
    // checks if the movement is valid
}
