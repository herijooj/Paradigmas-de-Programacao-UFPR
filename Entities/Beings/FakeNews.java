package Entities.Beings;

import java.awt.event.KeyEvent;
import java.util.*;

// imports
import Entities.Coordinate;
import Entities.Entity;
import Board.Sector;

// class
public abstract class FakeNews extends Entity {

    // attributes
    protected String state;

    // constructor
    public FakeNews(Coordinate position) {
        super(position);
        this.setState("alive");
    }

    // getters
    public String getState()
    {
        return this.state;
    }

    // setters
    public void setState(String state)
    {
        if (state != "alive" && state != "dead" && state != "outOfGame")
            throw new IllegalArgumentException("Invalid state, valids: [alive, dead and outOfGame]");
        else
            this.state = state;
    }

    // methods
    public boolean move(Sector[][] board, LinkedList<FakeNews> fakeNews, KeyEvent e, int direction) {
        return false;
    }
    // checks if the movement is valid
}
