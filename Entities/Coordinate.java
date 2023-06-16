package Entities;

// class
public class Coordinate {
    private int i;
    private int j;

    public Coordinate(int i, int j) {
        this.setI(i);
        this.setJ(j);
    }

    // getters
    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    // setters

    public void setI(int i) {
        this.i = i;
        return;
    }

    public void setJ(int j) {
        this.j = j;
        return;
    }

    // Methods

    /**
     * Generates a random coordinate within a 10x10 grid.
     *
     * @return A randomly generated Coordinate object.
     */
    public static Coordinate generateRandomCoordinate() {
        int i = (int) (Math.random() * 10);
        int j = (int) (Math.random() * 10);

        Coordinate coordinate = new Coordinate(i, j);

        return coordinate;
    }

}
