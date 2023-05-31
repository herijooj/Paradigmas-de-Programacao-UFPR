package Board;

public class Sector {
    private int i;
    private int j;
    private boolean restricted;
    private String whichFakeNews;

    public Sector(int i, int j, boolean restricted, String whichFakeNews) {
        this.setI(i);
        this.setJ(j);
        this.setRestricted(restricted);
        this.setWhichFN(whichFakeNews);
    }

    // getters
    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    public String getWhichFN()
    {
        return this.whichFakeNews;
    }

    public boolean isRestricted()
    {
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

    public void setWhichFN(String name)
    {
        this.whichFakeNews = name;
    }

    // methods
    public void draw() {
        return;
    }

}
