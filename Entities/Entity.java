package Entities;

// class
public abstract class Entity {

    // attributes
    protected Coordinate position;
    // the type can be handled by the class name
    // it is not necessary to have an attribute for it
    // it can be tested with instanceof

    // constructor
    public Entity(Coordinate position) {
        this.setPosition(position);
    }

    // getters
    public Coordinate getPosition() {
        return this.position;
    }

    // setters
    public void setPosition(Coordinate position) {
        if (position.getI() < 0 || position.getI() > 8 || position.getJ() < 0 || position.getJ() > 8)
            throw new IllegalArgumentException("i and j must be positive");

        this.position.setI(position.getI());
        this.position.setJ(position.getJ());
    }

    // methods
    public abstract void draw(); 
}
