package Entities;

public abstract class Entity {

    // attributes
    protected int type; // 0 for player, 1 for fake news, 2 for item

    // constructor
    public Entity(int type) {
        this.setType(type);
    }

    // getters
    public int getType() {
        return this.type;
    }

    // setters
    public void setType(int type) {
        if (type < 0 || type > 2)
            throw new IllegalArgumentException("Type must be beetwen 0 and 2");
        this.type = type;
    }

    // methods
    public abstract void draw(); 
}
