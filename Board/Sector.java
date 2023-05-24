package Sector;

public class Sector {
    private int i;
    private int j;
    private boolean restricted;

    public Sector(int i, int j, Boolean restricted) {
        this.setI(i);
        this.setJ(j);
        this.setRestricted(restricted);
    }

    // getters
    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    public boolean isRestricted() {
        return this.restricted;
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

    public void setRestricted(boolean value) {
        this.restricted = value;
        return;
    }

    // methods
    public void draw() {
        return;
    }

}
