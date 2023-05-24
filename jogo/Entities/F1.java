package Entities;

import Coordinate.Coordinate;

public class F1 extends FakeNews {

    // attributes

    // constructor
    public F1 (Coordinate position, int type) 
    {
        super(position, type);
    }
    
    // getters
    
    // setters

    // methods

    public void draw ()
    {
        System.out.println("F1");
    }
}
