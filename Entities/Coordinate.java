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
        if (i < 0 || i > 9)
            throw new IllegalArgumentException("I must be positive and less than 10");
        this.i = i;
        return;
    }

    public void setJ(int j) {
        if (j < 0 || j > 9)
            throw new IllegalArgumentException("J must be positive and less than 10");
        this.j = j;
        return;
    }

    // methods

    // this method calculates the distance between two coordinates
    public int calculateDistance(Coordinate coordinate) {
        int i = this.getI();
        int j = this.getJ();
        int i2 = coordinate.getI();
        int j2 = coordinate.getJ();

        int distance = (int) Math.sqrt(Math.pow(i2 - i, 2) + Math.pow(j2 - j, 2));

        return distance;
    }

    // this method checks if the coordinate is valid
    public boolean Isvalid() {
        int i = this.getI();
        int j = this.getJ();

        if (i < 0 || i > 9 || j < 0 || j > 9)
            return false;
        return true;
    }

    // this function generates a random coordinate
    public static Coordinate generateRandomCoordinate() {
        int i = (int) (Math.random() * 10);
        int j = (int) (Math.random() * 10);

        Coordinate coordinate = new Coordinate(i, j);

        return coordinate;
    }

}
