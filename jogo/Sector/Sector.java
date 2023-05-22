package Sector;

public class Sector {
    private int i;
    private int j;

    // getters
    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    // setters

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

    public void draw() {
        i = this.getI();
        j = this.getJ();
        if (i == 0 && j == 0) {
            System.out.println("+----+");
            System.out.println("|    |");
            System.out.println("+----+");
        }
    }

}
