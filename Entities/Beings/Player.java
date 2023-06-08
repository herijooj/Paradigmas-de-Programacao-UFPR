package Entities.Beings;

import java.awt.event.KeyEvent;
import java.util.*;

import Entities.Itens.*;
import Entities.Coordinate;
import Entities.Entity;
import Board.*;
import Cores.*;

public class Player extends Entity {

    // Attributes
    private int playerNum;
    private LinkedList<ItemCharacteristics> inventory;
    private int inventorySize = 4;

    // Full Constructor
    public Player(int playerNum, Coordinate position) {
        super(position);
        this.setPlayerNum(playerNum);
        this.setInventory();
    }

    // Getters
    public int getPlayerNum() {
        return this.playerNum;
    }

    public LinkedList<ItemCharacteristics> getInventory() {
        return this.inventory;
    }

    // Setters
    public void setPlayerNum(int playerNum) {
        if (playerNum < 1 || playerNum > 4)
            throw new IllegalArgumentException("Player number must be between 1 and 4");

        this.playerNum = playerNum;
    }

    public void setInventory() {
        this.inventory = new LinkedList<ItemCharacteristics>();
    }

    // Methods

    /*
     * Draws the player on screen
     */
    public void draw() {
        System.out.printf("J%d", this.playerNum);
    }

    /*
     * Adds a collected item to the player inventory
     */
    public void addItemToInventory(ItemCharacteristics item) {
        if (this.inventory.size() < this.inventorySize)
            this.inventory.add(item);
    }

    /*
     * Checks if a sector has an Item
     * returns true if it has, and false if it doesn't
     */
    public boolean hasItem(Sector[][] board, Coordinate position) {
        if (board[position.getI()][position.getJ()].getSectorState().contains("Item"))
            return true;
        return false;
    }

    /*
     * Based on the sectorState, returns an Item object
     */
    public ItemCharacteristics getSpecificItem(Sector[][] board, Coordinate position) {
        if (board[position.getI()][position.getJ()].getSectorState() == "Item Boato")
            return (new ItemBoato(position));
        else if (board[position.getI()][position.getJ()].getSectorState() == "Item Denunciar")
            return (new ItemDenunciar(position));
        else if (board[position.getI()][position.getJ()].getSectorState() == "Item Fugir")
            return (new ItemFugir(position));
        else
            return (new ItemLer(position));
    }

    /*
     * Moves the player according to the direction passed
     * returns true if moved, false if couldn't move (died)
     */
    public boolean move(Board board, int direction) {
        int newI, newJ;
        Coordinate position;

        switch (direction) {
            // Goes down
            case 1:
                newI = this.position.getI() + 1;

                if (!canMoveToCoordinate(board.getBoard(), newI, this.position.getJ()))
                    return false;
                else {
                    position = new Coordinate(newI, this.position.getJ());

                    if (hasItem(board.getBoard(), position)) {
                        // Adds an item to the player
                        // inventory and adds a new item to the board
                        addItemToInventory(getSpecificItem(board.getBoard(), position));
                        board.addItens(1);
                    }

                    this.position.setI(this.position.getI() + 1);
                }
                return true;
            // Goes up
            case 2:
                newI = this.position.getI() - 1;

                if (!canMoveToCoordinate(board.getBoard(), newI, this.position.getJ()))
                    return false;
                else {
                    position = new Coordinate(newI, this.position.getJ());

                    if (hasItem(board.getBoard(), position)) {
                        // Adds an item to the player
                        // inventory and adds a new item to the board
                        addItemToInventory(getSpecificItem(board.getBoard(), position));
                        board.addItens(1);
                    }

                    this.position.setI(this.position.getI() - 1);
                }
                return true;

            // Goes right
            case 3:
                newJ = this.position.getJ() + 1;

                if (!canMoveToCoordinate(board.getBoard(), this.position.getI(), newJ))
                    return false;
                else {
                    position = new Coordinate(this.getPosition().getI(), newJ);

                    if (hasItem(board.getBoard(), position)) {
                        // Adds an item to the player
                        // inventory and adds a new item to the board
                        addItemToInventory(getSpecificItem(board.getBoard(), position));
                        board.addItens(1);
                    }

                    this.position.setJ(this.position.getJ() + 1);
                }
                return true;
            // Goes left
            case 4:
                newJ = this.position.getJ() - 1;
                if (!canMoveToCoordinate(board.getBoard(), this.position.getI(), newJ))
                    return false;
                else {
                    position = new Coordinate(this.getPosition().getI(), newJ);

                    if (hasItem(board.getBoard(), position)) {
                        // Adds an item to the player
                        // inventory and adds a new item to the board
                        addItemToInventory(getSpecificItem(board.getBoard(), position));
                        board.addItens(1);
                    }

                    this.position.setJ(this.position.getJ() - 1);
                }
                return true;
        }
        return false;
    }

    /*
     * Returns the player number related to this
     * player object
     */
    public String toString() {

        if (this.playerNum == 1)
            return "Player 1";
        else if (this.playerNum == 2)
            return "Player 2";
        else if (this.playerNum == 3)
            return "Player 3";
        else 
            return "Player 4";
    }
}
