package Entities.Beings;

// imports
import Entities.Coordinate;
import Entities.Entity;

// class
public abstract class FakeNews extends Entity implements Movement {

    // attributes

    // constructor
    public FakeNews(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods
    // checks if the movement is valid
    public boolean checkMovement(int direction) {
        // THIS IS A PLACEHOLDER
        // THE REAL METHOD SHOULD CHECK IF THE SECTOR IS VALID
        switch (direction) {
            case 1:
                if (this.position.getI() + 1 > 9) {
                    return false;
                }
                break;
            case 2:
                if (this.position.getI() - 1 < 0) {
                    return false;
                }
                break;
            case 3:
                if (this.position.getJ() + 1 > 9) {
                    return false;
                }
                break;
            case 4:
                if (this.position.getJ() - 1 < 0) {
                    return false;
                }
                break;
        }
        return true;
    }
}
