package Entities;

import Board.Sector;

// class
public abstract class Entity {

    // Attributes
    protected Coordinate position;

    // Constructor
    public Entity(Coordinate position) {
        this.position = new Coordinate(0, 0); // fix inicialization bug
        this.setPosition(position);
    }

    // Getters
    public Coordinate getPosition() {
        return this.position;
    }


    // Setters
    public void setPosition(Coordinate position) {
        if (position.getI() < 0 || position.getI() > 8 || position.getJ() < 0 || position.getJ() > 8)
            throw new IllegalArgumentException("i and j must be positive");

        this.position.setI(position.getI());
        this.position.setJ(position.getJ());
    }


    // Methods
    
    /**
     * Checks if the given coordinate on the board is a valid move location for the entity.
     *
     * @param board the board to check for valid move locations.
     * @param i the row index of the coordinate to check.
     * @param j the column index of the coordinate to check.
     * @return true if the coordinate is a valid move location, false otherwise.
     */
    public boolean canMoveToCoordinate(Sector[][] board, int i, int j) { // MUDAR NOME E USAR COORDENADAS
        if (i < 0 || i > 8 || j < 0 || j > 8)
            return false;

        // checking if the sector already has something other than a player or item
        String sectorState = board[i][j].getSectorState();
        if (sectorState == "Restricted" || sectorState == "F1" || sectorState == "F2" || sectorState == "F3"
                || sectorState.contains("Player"))
            return false;
        return true;
    }

    /**
     * Checks if the given position on the board has any entity or item.
     *
     * @param board the board to check for entities or items.
     * @param position the position on the board to check for an entity or item.
     * @return true if the position has an entity or item, false otherwise.
     */
    public boolean hasSomething(Sector[][] board, Coordinate position) {
        String sectorState = board[position.getI()][position.getJ()].getSectorState();

        if (sectorState != "")
            return true;
        return false;
    }

    /**
     * Checks if the given position on the board has an item.
     *
     * @param board the board to check for items.
     * @param position the position on the board to check for an item.
     * @return true if the position has an item, false otherwise.
     */
    public boolean hasItem(Sector[][] board, Coordinate position) {
        if (board[position.getI()][position.getJ()].getSectorState().contains("Item"))
            return true;
        return false;
    }
}
