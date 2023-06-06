package Entities;

import Board.Sector;

// class
public abstract class Entity {

    // attributes
    protected Coordinate position;
    protected boolean alive = true;
    // the type can be handled by the class name
    // it is not necessary to have an attribute for it
    // it can be tested with instanceof

    // constructor
    public Entity(Coordinate position) {
        this.position = new Coordinate(0, 0); // Tava dando bug de inicializacao NULL
        this.setPosition(position);
    }

    // getters
    public Coordinate getPosition() {
        return this.position;
    }

    public boolean IsAlive() {
        return this.alive;
    }

    // setters
    public void setPosition(Coordinate position) {
        if (position.getI() < 0 || position.getI() > 8 || position.getJ() < 0 || position.getJ() > 8)
            throw new IllegalArgumentException("i and j must be positive");

        this.position.setI(position.getI());
        this.position.setJ(position.getJ());
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // methods
    public abstract void draw();

    /**
     * Check if a Beign can move to a certain position
     * 
     * 
     * Returns: true if it can move, false otherwise
     **/
    public boolean checkMovement(Sector[][] board, int i, int j) { // MUDAR NOME E USAR COORDENADAS
        if (i < 0 || i > 8 || j < 0 || j > 8)
            return false;

        // checking if the sector already has something other than a player or item
        String sectorState = board[i][j].getSectorState();
        if (sectorState == "Restricted" || sectorState == "F1" || sectorState == "F2" || sectorState == "F3")
            return false;
        return true;
    }
}
