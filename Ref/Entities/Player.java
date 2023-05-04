package Entities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Board.*;

public class Player extends Entity {

    private Coordinates position;

    // constructor
    public Player() {
        super(2, 6);
        setPosition(2, 2);
    }

    // constructor
    public Player(int attackPower, int defensePower, int x, int y) {
        super(attackPower, defensePower);
        setPosition(x, y);
    }

    // getters and setters

    // get position
    public Coordinates getPosition() {
        return this.position;
    }

    // set position
    public void setPosition(int x, int y) {
        this.position = new Coordinates(x,y);
    }

    // methods

    // increment defense
    public void incrementDefense(int increment){
        defensePower = defensePower + increment;
        if(defensePower >= 9) defensePower = 9;
    }

    // search for items
    public void search(Sector setor) {
        Random rand = new Random();
        int num = rand.nextInt(6)+1;
        switch (num) {
            case 4 -> {
                this.setDefensePower(this.getDefensePower() + 1);
                //incrementDefense(1);
                System.out.println("The Player gained 1 defense!");
            }
            case 5 -> {
                this.setDefensePower(this.getDefensePower() + 2);
                //incrementDefense(2);
                System.out.println("The Player gained 2 defense!");
            }
            case 6 -> { // n faco ideia se funciona // funciona
                ArrayList<Virus> enemies = setor.getEnemies();
                enemies.forEach((virus) -> virus.setDefensePower(virus.getDefensePower() - 1));
                System.out.println("The Player damaged all enemies in the sector! (1 damage)");
            }
            default -> System.out.println("The Player didn't find anything!");
        }
    }

    // Receives the board, the direction of the movement and which player will move
    // P = 0 (Simple)
    // P = 1 (Support)
    // Returns 1 if can move and 0 otherwise
    public int move(Board T, char dir, int P) {
        int x = position.getX(), y = position.getY();
        Sector setor_atual = T.getSector(x, y);
        if (setor_atual.hasDoor(dir) == 1) {
            T.getSector(x, y).removePlayers(P);
            if (dir == 'U') {
                T.getSector(x - 1, y).addPlayers(P);
                T.getSector(x - 1, y).visitSector();
                position.setCoordinates(x - 1, y);
            } else if (dir == 'D') {
                T.getSector(x + 1, y).addPlayers(P);
                T.getSector(x + 1, y).visitSector();
                position.setCoordinates(x + 1, y);
            } else if (dir == 'L') {
                T.getSector(x, y - 1).addPlayers(P);
                T.getSector(x, y - 1).visitSector();
                position.setCoordinates(x, y - 1);
            } else if (dir == 'R') {
                T.getSector(x, y + 1).addPlayers(P);
                T.getSector(x, y + 1).visitSector();
                position.setCoordinates(x, y + 1);
            }

            return 1;
        }
        return 0;
    }

    // Returns 1 if the action was successful and 0 otherwise
    public int playerAction(Board tab, char input, Player []p, Scanner reader, Random rand){
        //get current sector
        Sector set = tab.getSector(this);
        int opt = 2;
        int dice = 0;
        //is valid to attack
        if(input == 'A' && set.haveEnemies() == 0){
            if(set instanceof SectorOcult){
                dice = rand.nextInt(6);
                if(dice % 2 == 0){
                    this.attack(tab.getEnemy(this));
                    System.out.print("Attacking...");
                }
                else{
                    System.out.print("You miss the enemy!");
                }
            }
            else{
                this.attack(tab.getEnemy(this));
                System.out.print("Attacking...");
            }
            return 1;
        }
        else if(input == 'S' && !(set instanceof SectorPrivate)){
            System.out.print("Searching...");
            this.search(set);
            return 1;
        }
        else if(input == 'H' && (this instanceof SupPlayer)){
            //check if both players are in the same sector
            if(set == tab.getSector(p[0])){
                System.out.println("Choose a player to heal. (1) Main (2) Support");
                opt = reader.nextInt();
            }
            System.out.print("Regenerating...");
            if(opt == 1){
                p[0].incrementDefense(2);
            }
            else{
                this.incrementDefense(2);
            }
            return 1;
        }
        return 0;
    }

    // return if the player is a support player
    public boolean isSupport() {
        return this instanceof SupPlayer;
    }

    // return true if player is alive
    public boolean isAlive(){
        if(defensePower > 0)
            return true;
        return false;
    }

    // return true if the player has any available options 
    // prevents softlock
    public boolean availabeOptions(Board tab){
        Sector set = tab.getSector(this);
        if(!(this instanceof SupPlayer) && ((set.haveEnemies() == 1 && set instanceof SectorPrivate))){
            return false;
        }
        return true;
    }

    //return true if the player entered an infected sector
    public boolean isGameWon(Board tab){
        return tab.getSector(this).hasInfection();
    }

}

