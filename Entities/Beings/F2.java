package Entities.Beings;

// imports
import Entities.Coordinate;

// class
public class F2 extends FakeNews {

    // attributes

    // constructor
    public F2 (Coordinate position) 
    {
        super(position);
    }
    
    // getters
    
    // setters

    // methods

    public void draw ()
    {
        System.out.print("F2");
    }

    public void move()
    {
        // goes up, down, left or right two positions randomly
        int direction = randomNumber(1, 4);
        
        // checks if the movement is valid, if not, tries again
        while (!checkMovement(direction)) {
            direction = randomNumber(1, 4);
        }

        switch (direction) {
            case 1:
                this.position.x += 2;
                break;
            case 2:
                this.position.x -= 2;
                break;
            case 3:
                this.position.y += 2;
                break;
            case 4:
                this.position.y -= 2;
                break;
        }
    }
}