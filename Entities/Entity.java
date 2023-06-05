package Entities;

// class
public abstract class Entity {

    // attributes
    protected Coordinate position;
    protected boolean alive = true;
    // the type can be handled by the class name
    // it is not necessary to have an attribute for it
    // it can be tested with instanceof

    // constructor
    public Entity(Coordinate position) {
        this.position = new Coordinate(0, 0); // Tava dando bug de inicializacao NULL
        this.setPosition(position);
    }

    // getters
    public Coordinate getPosition() {
        return this.position;
    }

    public boolean IsAlive() {
        return this.alive;
    }

    // setters
    public void setPosition(Coordinate position) {
        if (position.getI() < 0 || position.getI() > 8 || position.getJ() < 0 || position.getJ() > 8)
            throw new IllegalArgumentException("i and j must be positive");

        this.position.setI(position.getI());
        this.position.setJ(position.getJ());
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // methods
    public abstract void draw();

    // checks two coordinates and returns true if they are inside the board
    public boolean checkMovement(int i, int j) { // MUDAR NOME E USAR COORDENADAS
        if (i < 0 || i > 8 || j < 0 || j > 8)
            return false;
        return true;
    }
}
