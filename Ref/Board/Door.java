package Board;

public class Door {
    
    // ----- Attributes -----

    // 0 no door ; 1 has door
    private int u;
    private int d;
    private int l;
    private int r;

    // ----- Constructor -----

    public Door(int u, int d, int l, int r) {
        this.u = u;
        this.d = d;
        this.l = l;
        this.r = r;
    }

    // ----- Getters and setters -----

    public int getR() {
        return r;
    }

    public int getU() {
        return u;
    }

    public int getD() {
        return d;
    }

    public int getL() {
        return l;
    }

    // ----- Methods -----

    public void printDoors() {
        System.out.print(u + " " + d + " " + l + " " + r);
    }
}
