package Entities.Beings;

import java.awt.event.KeyEvent;
import java.util.*;

import Board.Sector;
import Entities.Entity;

// class
public interface Movement {
    // methods
    public void move(Sector[][] board, LinkedList<Entity> Entities, KeyEvent e, int direction);
}