package Board;

import Entities.Coordinate;

public class Sector {
    
    // Attributes

    // private int i;
    // private int j;
    private Coordinate coordinate;
    private String sectorState;

    // Constructor 

    public Sector(Coordinate coordinate, String sectorState) {
        this.setCoordinate(coordinate);
        this.setSectorState(sectorState);
    }

    // Getters

    // public int getI() {
    //     return this.i;
    // }

    // public int getJ() {
    //     return this.j;
    // }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    /**
     * it can be:
     * "Restricted", "Player 1..4", "F1..F3", "Item" or ""
     */
    public String getSectorState() {
        return this.sectorState;
    }

    // Setters

    // public void setI(int i) {
    //     if (i < 0)
    //         throw new IllegalArgumentException("I must be positive");
    //     this.i = i;
    //     return;
    // }

    // public void setJ(int j) {
    //     if (j < 0)
    //         throw new IllegalArgumentException("J must be positive");
    //     this.j = j;
    //     return;
    // }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return;
    }

    public void setSectorState(String state) {
        this.sectorState = state;
    }
}
