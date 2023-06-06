package Entities.Beings;

import Entities.Itens.*;
import java.awt.event.KeyEvent;
import java.util.*;

import Entities.Coordinate;
import Entities.Entity;
import Board.Sector;
import Cores.Cores;

public class Player extends Entity {
    // attributes
    private int playerNum;
    private LinkedList<ItemCharacteristics> inventory;
    private int inventorySize = 4;

    // constructor
    public Player(int playerNum, Coordinate position) {
        super(position);
        this.setPlayerNum(playerNum);
        this.setInventory();
    }

    // getters
    public int getPlayerNum() {
        return this.playerNum;
    }

    public LinkedList<ItemCharacteristics> getInventory() {
        return this.inventory;
    }

    // setters
    public void setPlayerNum(int playerNum) {
        if (playerNum < 1 || playerNum > 4)
            throw new IllegalArgumentException("Player number must be between 1 and 4");

        this.playerNum = playerNum;
    }

    public void setInventory() {
        this.inventory = new LinkedList<ItemCharacteristics>();
    }

    // methods
    public void draw() {
        System.out.printf("F%d", this.playerNum);
    }

    public void addItem(ItemCharacteristics item)
    {
        this.inventory.add(item);
    }

    public boolean move(Sector[][] board, LinkedList<Player> players, KeyEvent e, int direction) {
        int newI, newJ;
        Coordinate position;

        switch (direction) {
            // goes down
            case 1:
                newI = this.position.getI() + 1;
                if (!checkMovement(board, newI, this.position.getJ())) {
                    // substitute player for NULL
                    System.out.println("A Player has " + Cores.ANSI_RED + "Died!" + Cores.ANSI_RESET);
                    players.remove(this);
                    players.add(null);
                    return false;
                } else {
                    position = new Coordinate(newI, this.position.getJ());

                    if (board[newI][this.position.getJ()].getSectorState() == "Item Boato")
                        addItem(new ItemBoato(position));
                    else if (board[newI][this.position.getJ()].getSectorState() == "Item Denunciar")
                        addItem(new ItemDenunciar(position));
                    else if (board[newI][this.position.getJ()].getSectorState() == "Item Fugir")
                        addItem(new ItemFugir(position));
                    else if (board[newI][this.position.getJ()].getSectorState() == "Item Ler")
                        addItem(new ItemLer(position));
                    this.position.setI(this.position.getI() + 1);
                    return true;
                }
                // goes up
            case 2:
                newI = this.position.getI() - 1;
                if (!checkMovement(board, newI, this.position.getJ())) {
                    System.out.println("A Player has " + Cores.ANSI_RED + "Died!" + Cores.ANSI_RESET);
                    players.remove(this);
                    players.add(null);
                    return false;
                } else {
                    position = new Coordinate(newI, this.position.getJ());

                    if (board[newI][this.position.getJ()].getSectorState() == "Item Boato")
                        addItem(new ItemBoato(position));
                    else if (board[newI][this.position.getJ()].getSectorState() == "Item Denunciar")
                        addItem(new ItemDenunciar(position));
                    else if (board[newI][this.position.getJ()].getSectorState() == "Item Fugir")
                        addItem(new ItemFugir(position));
                    else if (board[newI][this.position.getJ()].getSectorState() == "Item Ler")
                        addItem(new ItemLer(position));
                    this.position.setI(this.position.getI() - 1);
                    return true;
                }
                // goes right
            case 3:
                newJ = this.position.getJ() + 1;
                if (!checkMovement(board, this.position.getI(), newJ)) {
                    System.out.println("A Player has " + Cores.ANSI_RED + "Died!" + Cores.ANSI_RESET);
                    players.remove(this);
                    players.add(null);
                    return false;
                } else {
                    position = new Coordinate(this.getPosition().getI(), newJ);

                    if (board[this.getPosition().getI()][newJ].getSectorState() == "Item Boato")
                        addItem(new ItemBoato(position));
                    else if (board[this.getPosition().getI()][newJ].getSectorState() == "Item Denunciar")
                        addItem(new ItemDenunciar(position));
                    else if (board[this.getPosition().getI()][newJ].getSectorState() == "Item Fugir")
                        addItem(new ItemFugir(position));
                    else if (board[this.getPosition().getI()][newJ].getSectorState() == "Item Ler")
                        addItem(new ItemLer(position));
                    this.position.setJ(this.position.getJ() + 1);
                    return true;
                }
                // goes left
            case 4:
                newJ = this.position.getJ() - 1;
                if (!checkMovement(board, this.position.getI(), newJ)) {
                    System.out.println("A Player has " + Cores.ANSI_RED + "Died!" + Cores.ANSI_RESET);
                    players.remove(this);
                    players.add(null);
                    return false;
                } else {
                    position = new Coordinate(this.getPosition().getI(), newJ);

                    if (board[this.getPosition().getI()][newJ].getSectorState() == "Item Boato")
                        addItem(new ItemBoato(position));
                    else if (board[this.getPosition().getI()][newJ].getSectorState() == "Item Denunciar")
                        addItem(new ItemDenunciar(position));
                    else if (board[this.getPosition().getI()][newJ].getSectorState() == "Item Fugir")
                        addItem(new ItemFugir(position));
                    else if (board[this.getPosition().getI()][newJ].getSectorState() == "Item Ler")
                        addItem(new ItemLer(position));
                    this.position.setJ(this.position.getJ() - 1);
                    return true;
                }
        }
        return false;
    }

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
