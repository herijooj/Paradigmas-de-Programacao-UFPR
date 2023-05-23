package Coordinate;

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
            throw new IllegalArgumentException("I must be positive");
        this.i = i;
        return;
    }

    public void setJ(int j) {
        if (j < 0 || j > 9)
            throw new IllegalArgumentException("J must be positive");
        this.j = j;
        return;
    }

    // methods

    public int calculateDistance(Coordinate coordinate) {
        int i = this.getI();
        int j = this.getJ();
        int i2 = coordinate.getI();
        int j2 = coordinate.getJ();

        int distance = (int) Math.sqrt(Math.pow(i2 - i, 2) + Math.pow(j2 - j, 2));

        return distance;
    }

    public boolean Isvalid() {
        int i = this.getI();
        int j = this.getJ();

        if (i < 0 || i > 9 || j < 0 || j > 9)
            return false;
        return true;
    }
}
