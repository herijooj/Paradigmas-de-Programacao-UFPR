package Entities.Beings;

// imports
import Entities.Coordinate;
import Entities.Entity;
import Board.*;

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
     * Function that generates coordinates for new Fake News generations,
     * based on a coordinate passed as a parameter (center), it generates
     * a new coordinate around that center 
     * 
     * Returns: new Coordinate;
    */
    public Coordinate generateRandomPeriphericCoordinate(Coordinate center) {
        int iC = center.getI();
        int jC = center.getJ();
        int iOffset, jOffset, newI, newJ;
        
        // If the center is on the bottom line
        if (iC == 8) 
        {
            iOffset = (int) (Math.random() * 2);      // Random offset for i coordinate (0 or 1)
            jOffset = (int) (Math.random() * 3) - 1;  // Random offset for j coordinate (-1, 0, or 1)
        }

        // If the center is on the top line
        else if (iC == 0) 
        {
            iOffset = (int) (Math.random() * 2) - 1;  // Random offset for i coordinate (-1 or 0)
            jOffset = (int) (Math.random() * 3) - 1;  // Random offset for j coordinate (-1, 0, or 1)
        }

        // If the center is in the leftmost column
        else if (jC == 0) 
        {
            iOffset = (int) (Math.random() * 3) - 1;  // Random offset for i coordinate (-1, 0, or 1)
            jOffset = (int) (Math.random() * 2) - 1;  // Random offset for j coordinate (-1 or 0)
        }

        // If the center is in the rightmost column
        else if (jC == 8) 
        {
            iOffset = (int) (Math.random() * 3) - 1;  // Random offset for i coordinate (-1, 0, or 1)
            jOffset = (int) (Math.random() * 2);      // Random offset for j coordinate (0 or 1)
        }

        // If the center is in any other position
        else 
        {
            iOffset = (int) (Math.random() * 3) - 1;  // Random offset for i coordinate (-1, 0, or 1)
            jOffset = (int) (Math.random() * 3) - 1;  // Random offset for j coordinate (-1, 0, or 1)
        }
    
        // Calculate the new coordinates based on the offsets
        newI = iC + iOffset;
        newJ = jC + jOffset;
    
        // If the generated coordinates are the same as the center coordinates, adjust them
        while (newI == iC && newJ == jC) 
        {
            iOffset = (int) (Math.random() * 3) - 1;  // Random adjustment for i coordinate (-1, 0, or 1)
            jOffset = (int) (Math.random() * 3) - 1;  // Random adjustment for j coordinate (-1, 0, or 1)

            newI = iC + iOffset;
            newJ = jC + jOffset;
        }
    
        return (new Coordinate(newI, newJ));
    }
    
    /*
     * Checks if a sector has an Item
     * returns true if it has, and false if it doesn't
     */
    public boolean hasItem(Sector[][] board, Coordinate position) {
        if (board[position.getI()][position.getJ()].getSectorState().contains("Item"))
            return true;
        return false;
    }

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
