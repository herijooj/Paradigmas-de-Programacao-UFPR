package Entities.Beings;

// imports
import Entities.Coordinate;

// class
public class F1 extends FakeNews {

    // attributes

    // constructor
    public F1 (Coordinate position) 
    {
        super(position);
    }
    
    // getters
    
    // setters

    // methods

    public void draw ()
    {
        System.out.print("F1");
    }

    public void move()
    {
        // goes up, down, left or right one position randomly
        int direction = randomNumber(1, 4);

        // checks if the movement is valid, if not, tries again
        while (!checkMovement(direction)) {
            direction = randomNumber(1, 4);
        }

        switch (direction) {
            case 1:
                this.position.x += 1;
                break;
            case 2:
                this.position.x -= 1;
                break;
            case 3:
                this.position.y += 1;
                break;
            case 4:
                this.position.y -= 1;
                break;
        }
    }
}
