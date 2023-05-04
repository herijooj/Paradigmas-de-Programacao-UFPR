package Board;

import java.util.ArrayList;
import java.util.Random;

import Entities.*;
import Board.Colors;
public class Sector {
    Colors cores;
    // --- Attributes ---

    private Door door;
    private boolean known;
    private boolean infection;

    private ArrayList<Virus> enemies;

    // 0 no one
    // 1 only simple
    // 2 only support
    // 3 both
    private int players;
    

    // --- Constructor ---

    public Sector(int u, int d, int l, int r) {
        door = new Door(u, d, l, r);
        known = false;
        infection = false;
    }


    // --- Getters and setters ---

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int np) {
        players = np;
    }

    public ArrayList<Virus> getEnemies(){
        return this.enemies;
    }

    public void setInfection() {
        infection = true;
    }

    // --- Methods ---

    // returns 1 if there is a door in the indicated direction and 0 otherwise
    public int hasDoor(char dir) {
        if (dir == 'U') {
            return door.getU();
        }
        if (dir == 'L') {
            return door.getL();
        }
        if (dir == 'D') {
            return door.getD();
        }
        if (dir == 'R') {
            return door.getR();
        }
        return 0;
    }

    // returns 1 if the sector has been visited, 0 otherwise
    public boolean isKnown() {
        return known;
    }

    // sets the sector as visited
    public void visitSector() {
        this.known = true;   
    }

    public void printDoors() {
        door.printDoors();
    }

    public boolean hasInfection() {
        return infection;
    }

    public void printSector(int i, int j) {
        if (i == 2 && j == 2) {
            System.out.print(cores.ANSI_YELLOW + " C " + cores.ANSI_RESET);
        } else if (infection) {
            System.out.print(cores.ANSI_RED + " X " + cores.ANSI_RESET);
        } else if (players == 0) {
            System.out.print("   ");
        } else if (players == 1) {
            System.out.print(cores.ANSI_BLUE + "P1 " + cores.ANSI_RESET );
        } else if (players == 2) {
            System.out.print(cores.ANSI_GREEN +"P2 " + cores.ANSI_RESET);
        } else if (players == 3) {
            System.out.print(cores.ANSI_CYAN + " P " + cores.ANSI_RESET);
        }
    }

    public void removePlayers(int P) {
        // Simple
        if (P == 0) {
            if (players == 1)
                players = 0;
            else
                players = 2;
        } else {
            if (players == 2)
                players = 0;
            else
                players = 1;
        }
    }

    // 0 no one
    // 1 only simple
    // 2 only support
    // 3 both
    public void addPlayers(int P) {
        // Simples
        if (P == 0) {
            if (players == 0)
                players = 1;
            else
                players = 3;
        } else {
            if (players == 0)
                players = 2;
            else
                players = 3;
        }
    }

    public void generateEnemies(Random rand){
        int num = rand.nextInt(3) + 1;
        enemies = new ArrayList<Virus>(num);
        for (int i = 0; i < num; i++) {
            enemies.add(new Virus(rand));
        }
    }

    public void printEnemies() {
        for (Virus enemy : enemies) {
            System.out.print(" " + enemy.getAttackPower() + "/" + enemy.getDefensePower());
        }
        for (int i = enemies.size(); i < 3; i++) {
            System.out.print("    ");
        }
        System.out.print(" ");
    }

    // Returns 1 if all enemies in the sector have 0 DEF
    // 0 if any enemy does not have 0 DEF
    public int haveEnemies() {
        for (Virus enemy : enemies) {
            if (enemy.getDefensePower() != 0)
                return 0;
        }
        return 1;
    }

    // -----------------------------/ DEBUG /----------------------------- //
    public void killEnemies() {
        for (Virus enemy : enemies) enemy.setDefensePower(0);
    }

    public Virus returnEnemy() {
        for (Virus enemy : enemies) {
            if (enemy.getDefensePower() != 0)
                return enemy;
        }
        return enemies.get(0);

    }

    public void setEnemiesNULL() {
        enemies = new ArrayList<>();
    }
}