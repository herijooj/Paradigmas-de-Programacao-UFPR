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

    // constructor
    public FakeNews(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods
    public boolean move(Sector[][] board, LinkedList<FakeNews> fakeNews, KeyEvent e, int direction) {
        return false;
    }
    // checks if the movement is valid
}
