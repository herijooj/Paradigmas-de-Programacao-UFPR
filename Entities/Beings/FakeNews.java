package Entities.Beings;

// imports
import Entities.Coordinate;
import Entities.Entity;
import Board.*;

// class
public abstract class FakeNews extends Entity implements Movement {

    // Attributes
    protected String state;

    // Constructor
    /**
     * Constructor for the Fake News class
     * 
     * @param position where the Fake News will be placed
     */
    public FakeNews(Coordinate position, String state) {
        super(position);
        this.setState(state);
    }

    // Getters
    /**
     * Function that returns the state of the Fake News
     * 
     * @return String "alive", "dead", "RecentlyAdded" or "outOfGame
     */
    public String getState() {
        return this.state;
    }

    // Setters
    /**
     * Function that sets the state of the Fake News
     * 
     * @param state "alive", "dead", "RecentlyAdded" or "outOfGame
     */
    public void setState(String state) {
        if (state != "alive" && state != "dead" && state != "outOfGame" && state != "RecentlyAdded")
            throw new IllegalArgumentException("Invalid state, valids: [alive, dead, RecentlyAdded and outOfGame]");
        else
            this.state = state;
    }

    // Methods

    /**
     * Adjusts a coordinate by adding an offset and ensuring that the result is within
     * the valid range of coordinates (0 to 8 inclusive).
     *
     * @param coordinate the coordinate to adjust
     * @param offset the offset to add to the coordinate
     * @return the adjusted coordinate within the valid range
     */
    private int adjustCoordinate(int coordinate, int offset) {
        return Math.max(0, Math.min(8, coordinate + offset));
    }

    /**
     * Function that generates coordinates for new Fake News generations,
     * based on a coordinate passed as a parameter (center), it generates
     * a new coordinate around that center
     * 
     * @param center the coordinate around which the new coordinate will be
     *               generated
     * @return Coordinate: the new coordinate generated
     */
    public Coordinate generateRandomPeriphericCoordinate(Coordinate center) {
        int iC = center.getI();
        int jC = center.getJ();
        int iOffset, jOffset, newI, newJ;

        // If the center is on the bottom line
        if (iC == 8) {
            iOffset = (int) (Math.random() * 2); // Random offset for i coordinate (0 or 1)
            jOffset = (int) (Math.random() * 3) - 1; // Random offset for j coordinate (-1, 0, or 1)
        }
        // If the center is on the top line
        else if (iC == 0) {
            iOffset = (int) (Math.random() * 2) - 1; // Random offset for i coordinate (-1 or 0)
            jOffset = (int) (Math.random() * 3) - 1; // Random offset for j coordinate (-1, 0, or 1)
        }
        // If the center is in the leftmost column
        else if (jC == 0) {
            iOffset = (int) (Math.random() * 3) - 1; // Random offset for i coordinate (-1, 0, or 1)
            jOffset = (int) (Math.random() * 2) - 1; // Random offset for j coordinate (-1 or 0)
        }
        // If the center is in the rightmost column
        else if (jC == 8) {
            iOffset = (int) (Math.random() * 3) - 1; // Random offset for i coordinate (-1, 0, or 1)
            jOffset = (int) (Math.random() * 2); // Random offset for j coordinate (0 or 1)
        }
        // If the center is in any other position
        else {
            iOffset = (int) (Math.random() * 3) - 1; // Random offset for i coordinate (-1, 0, or 1)
            jOffset = (int) (Math.random() * 3) - 1; // Random offset for j coordinate (-1, 0, or 1)
        }

        // Calculate the new coordinates based on the offsets
        newI = adjustCoordinate(iC, iOffset); // Adjusted new i coordinate within valid range
        newJ = adjustCoordinate(jC, jOffset); // Adjusted new j coordinate within valid range

        // If the generated coordinates are the same as the center coordinates, adjust
        // them
        while (newI == iC && newJ == jC) {
            iOffset = (int) (Math.random() * 3) - 1; // Random adjustment for i coordinate (-1, 0, or 1)
            jOffset = (int) (Math.random() * 3) - 1; // Random adjustment for j coordinate (-1, 0, or 1)
            newI = adjustCoordinate(iC, iOffset); // Adjusted new i coordinate within valid range
            newJ = adjustCoordinate(jC, jOffset); // Adjusted new j coordinate within valid range
        }

        return new Coordinate(newI, newJ);
    }

    /**
     * Function that adds a Fake News to a sector of the board
     * 
     * @param board
     * @param position
     * @param fn       the Fake News to be added
     */
    public void addFakeNewsToSector(Board board, Coordinate position, FakeNews fn) {
        if (fn instanceof F1)
            board.getBoard()[position.getI()][position.getJ()].setSectorState("F1");
        else if (fn instanceof F2)
            board.getBoard()[position.getI()][position.getJ()].setSectorState("F2");
        else if (fn instanceof F3)
            board.getBoard()[position.getI()][position.getJ()].setSectorState("F3");
    }

    /**
     * will try and move the fake news in the direction of the key pressed
     * 
     * @param board     the Board of the game
     * @param direction the direction of the movement
     * 
     */
    public abstract String move(Board board, int direction);
    // checks if the movement is valid
}
