package Entities;

public abstract class Entities {
    protected int type; // 0 for player, 1 for fake news, 2 for item

    public Entities(int type) {
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
        return;
    }

    public void draw() {
        switch (this.getType()) {
            case 0:
                // Player
                System.out.println("JJ");
                break;
            case 1:
                // Fake News
                System.out.println("FN");
                break;
            case 2:
                // Item
                System.out.println("??");
                break;
            default:
                // Empty
                System.out.println("  ");
                break;
        }
    }
}
