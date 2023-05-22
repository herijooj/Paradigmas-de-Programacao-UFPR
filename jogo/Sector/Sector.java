package jogo.Sector;

public class Sector {
    private int x;
    private int y;

    public Sector(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    // getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // setters

    public void setX(int x) {
        if (x < 0)
            throw new IllegalArgumentException("X must be positive");
        this.x = x;
        return;
    }

    public void setY(int y) {
        if (y < 0)
            throw new IllegalArgumentException("Y must be positive");
        this.y = y;
        return;
    }

    public void draw(int x, int y) {

    }

}
