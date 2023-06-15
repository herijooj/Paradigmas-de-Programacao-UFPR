package Board;

import Entities.Coordinate;

public class Sector {
    
    // Attributes

    private Coordinate coordinate;
    private String sectorState;

    // Constructor 

    public Sector(Coordinate coordinate, String sectorState) {
        this.setCoordinate(coordinate);
        this.setSectorState(sectorState);
    }

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

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return;
    }

    public void setSectorState(String state) {
        this.sectorState = state;
    }
}
