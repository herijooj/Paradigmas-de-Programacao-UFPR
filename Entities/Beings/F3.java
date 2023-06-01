package Entities.Beings;

// imports
import Entities.Coordinate;

// class
public class F3 extends FakeNews {

    // attributes

    // constructor
    public F3 (Coordinate position) 
    {
        super(position);
    }
    
    // getters
    
    // setters

    // methods

    public void draw ()
    {
        System.out.print("F3");
    }

    public void move()
    {
        // goes up-left, up-right, down-left or down-right one position randomly
        int direction = randomNumber(1, 4);

        // checks if the movement is valid, if not, tries again
        while (!checkMovement(direction)) {
            direction = randomNumber(1, 4);
        }

        switch (direction) {
            case 1:
                this.position.x += 1;
                this.position.y += 1;
                break;
            case 2:
                this.position.x += 1;
                this.position.y -= 1;
                break;
            case 3:
                this.position.x -= 1;
                this.position.y += 1;
                break;
            case 4:
                this.position.x -= 1;
                this.position.y -= 1;
                break;
        }
    }
}