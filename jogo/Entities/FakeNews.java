package Entities;

import Coordinate.Coordinate;

public abstract class FakeNews extends Entity {

    // attributes
    protected Coordinate position;

    // constructor
    public FakeNews (Coordinate position, int type) 
    {
        super(type);
        this.setPosition(position);
    }

    // getters
    public Coordinate getPosition() 
    {
        return this.position;
    }

    // setters
    public void setPosition(Coordinate position)
    {   
        if (position.getI() < 0 || position.getI() > 8 || position.getJ() < 0 || position.getJ() > 8)
            throw new IllegalArgumentException("i and j must be positive");
        
        this.position.setI(position.getI());
        this.position.setJ(position.getJ());
    }
}
