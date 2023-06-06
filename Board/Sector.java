package Board;

public class Sector {
    
    // attributes ====================================
    private int i;
    private int j;
    private String sectorState;

    // constructors ==================================
    public Sector(int i, int j, String sectorState) {
        this.setI(i);
        this.setJ(j);
        this.setSectorState(sectorState);
    }

    // getters =======================================
    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    /**
     * it can be:
     * "Restricted", "Player 1..4", "F1..F3", "Item" or ""
     */
    public String getSectorState() {
        return this.sectorState;
    }

    // setters =======================================
    public void setI(int i) {
        if (i < 0)
            throw new IllegalArgumentException("I must be positive");
        this.i = i;
        return;
    }

    public void setJ(int j) {
        if (j < 0)
            throw new IllegalArgumentException("J must be positive");
        this.j = j;
        return;
    }

    public void setSectorState(String state) {
        this.sectorState = state;
    }

    // methods =======================================
    public void draw() {
        return;
    }

}
