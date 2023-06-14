package Entities.Beings;

import Board.Board;

// class
public interface Movement {
    // methods

    /**
     * it will move the entity in the given direction
     * 
     * @param board
     * @param direction
     * @return
     */
    public String move(Board board, int direction);
}
