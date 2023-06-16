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
     * Calculates the distance between the current Coordinate object and the given Coordinate object.
     *
     * @param coordinate The Coordinate object to calculate the distance to.
     * @return The distance between the two Coordinate objects as an integer.
     */
    public int calculateDistance(Coordinate coordinate) {
        int i = this.getI();
        int j = this.getJ();
        int i2 = coordinate.getI();
        int j2 = coordinate.getJ();

        int distance = (int) Math.sqrt(Math.pow(i2 - i, 2) + Math.pow(j2 - j, 2));

        return distance;
    }

    /**
     * Checks if the current Coordinate object is valid within a 10x10 grid.
     *
     * @return true if the Coordinate object is valid, false otherwise.
     */
    public boolean Isvalid() {
        int i = this.getI();
        int j = this.getJ();

        if (i < 0 || i > 9 || j < 0 || j > 9)
            return false;
        return true;
    }

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
