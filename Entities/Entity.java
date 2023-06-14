package Entities;

import Board.Sector;

// class
public abstract class Entity {

    // Attributes
    protected Coordinate position;
    protected boolean alive = true;

    // Constructor
    public Entity(Coordinate position) {
        this.position = new Coordinate(0, 0); // fix inicialization bug
        this.setPosition(position);
    }

    // Getters
    public Coordinate getPosition() {
        return this.position;
    }

    public boolean isAlive() {
        return this.alive;
    }

    // Setters
    public void setPosition(Coordinate position) {
        if (position.getI() < 0 || position.getI() > 8 || position.getJ() < 0 || position.getJ() > 8)
            throw new IllegalArgumentException("i and j must be positive");

        this.position.setI(position.getI());
        this.position.setJ(position.getJ());
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // Methods

    /**
     * Check if a Beign can move to a certain position
     * 
     * 
     * Returns: true if it can move, false otherwise
     **/
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

    //
    /**
     * Check if a given coordinate has something in it
     * 
     * 
     * Returns: true if it has, false otherwise
     **/
    public boolean hasSomething(Sector[][] board, Coordinate position) {
        String sectorState = board[position.getI()][position.getJ()].getSectorState();

        if (sectorState != "")
            return true;
        return false;
    }
}
