package Entities.Beings;

import Entities.Coordinate;
import Entities.Entity;

public class Player extends Entity implements Movement 
{
    // attributes
    private int playerNum;

    // constructor
    public Player (int playerNum, Coordinate position)
    {
        super(position);
        this.setPlayerNum(playerNum);
    }

    // getters
    int getPlayerNum()
    {
        return this.playerNum;
    }

    // setters
    void setPlayerNum(int playerNum)
    {
        if (playerNum < 1 || playerNum > 4)
            throw new IllegalArgumentException("Player number must be between 1 and 4");
        
        this.playerNum = playerNum;
    }

    // methods
    public void draw()
    {
        System.out.printf("F%d", this.playerNum);
    }

    public void move()
    {
        // TODO
    }
}