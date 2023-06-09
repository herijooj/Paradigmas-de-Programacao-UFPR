package Entities.Beings;

import java.awt.event.KeyEvent;
import java.util.*;

import Board.Board;
import Entities.Entity;

// class
public interface Movement {
    // methods
    public boolean move(Board board, int direction);
}