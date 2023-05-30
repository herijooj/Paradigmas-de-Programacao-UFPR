package Board;

public class Sector {
    private int i;
    private int j;
    private boolean restricted; // não tem comportamento diferente
    private boolean isF1;

    public Sector(int i, int j, boolean restricted, boolean isF1) {
        this.setI(i);
        this.setJ(j);
        this.setRestricted(restricted);
        this.setIsF1(isF1);
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

    public boolean getIsF1() {
        return this.isF1;
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

    public void setIsF1(boolean isF1) 
    {
        this.isF1 = isF1;
        return;
    }

    // methods
    public void draw() {
        return;
    }

}
