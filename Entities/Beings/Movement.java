package Entities.Beings;

import java.awt.event.KeyEvent;

import Board.Sector;

// class
public interface Movement {
    // methods
    public void move(Sector[][] board, KeyEvent e, int direction);
}