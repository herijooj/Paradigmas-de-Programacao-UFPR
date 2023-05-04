// Claudinei Alduan - GRR20203920
// Fernanda Lied    - GRR20206148
// Heric Camargo    - GRR20203959

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Board.*;
import Entities.*;

public class Main {
    public static void flush_terminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        Board tabb = new Board();
        Scanner reader = new Scanner(System.in);
        PrintGame pg = new PrintGame();
        Player[] jogadores = new Player[2];
        jogadores[0] = new Player();
        jogadores[1] = new SupPlayer();
        char input;
        Sector simpleSector, supSector;
        Random rand = new Random();
        int r;
        // turn loop (25)
        for (int i = 1; i <= 25 && jogadores[0].isAlive(); i++) {
            pg.printTable(tabb, jogadores, i);
            // 2 turn loop (players)
            for (int k = 0; k < 2; k++) {
                // if player is alive
                if (jogadores[k].isAlive()) {
                    
                    // if player is in a sector with enemies
                    if (tabb.getSector(jogadores[k]).haveEnemies() == 1) {
                        System.out.print("Choose a direction to Player " + (k + 1) + " ");
                        pg.availableDirections(tabb.getSector(jogadores[k]));
                        // read until the input is valid
                        input = Character.toUpperCase(reader.next().charAt(0));        
                        while(jogadores[k].move(tabb, input, k) != 1){
                            input = Character.toUpperCase(reader.next().charAt(0));
                        }
                        pg.printTable(tabb, jogadores, i);
                        
                        // if the player is in the infected sector
                        if(jogadores[k].isGameWon(tabb)){
                            pg.printWinMessage();
                            System.exit(0);
                        }
                    }

                    // 2 for each player (check if the player has any valid move)
                    Sector sector = tabb.getSector(jogadores[k]);
                    for (int j = 0; j < 2 && jogadores[k].availabeOptions(tabb); j++) {
                        pg.showPossibleActions(jogadores[k], sector);
                        
                        // read until the input is valid
                        input = Character.toUpperCase(reader.next().charAt(0));  
                        while(jogadores[k].playerAction(tabb, input, jogadores, reader, rand) != 1)
                            input = Character.toUpperCase(reader.next().charAt(0));  
            
                        Thread.sleep(1500);
                        pg.printTable(tabb, jogadores, i);
                    }
                    pg.printTable(tabb, jogadores, i);
                }
            }

        // ----------------- VIRUS ATTACK -----------------
        // get the sectors of the players
        simpleSector = tabb.getSector(jogadores[0]);
        supSector = tabb.getSector(jogadores[1]);       
        
        // if the players are in different sectors
        if(simpleSector != supSector){
            // loop for the two sectors
            for(int k = 0; k < 2; k++){
                // if the sector have enemies and the player is alive
                if(tabb.getSector(jogadores[k]).haveEnemies() == 0 && jogadores[k].isAlive()){
                    
                    // for each virus in the sector
                    for(Virus virus : tabb.getSector(jogadores[k]).getEnemies()){
                        // if the virus is alive
                        if(virus.getDefensePower() > 0){
                            System.out.println("An enemy is preparing an attack...");
                            Thread.sleep(2000);
                            
                            // RNG
                            r = rand.nextInt(6);
                            // if the number is even -> attack
                            if(r % 2 == 0){
                                virus.attack(jogadores[k]);
                                if(jogadores[k] instanceof SupPlayer){
                                    System.out.println("The Support player has taken " + virus.getAttackPower() + " damage!");
                                }
                                else
                                    System.out.println("The Main player has taken " + virus.getAttackPower() + " damage");
                            }
                            // if the number is odd -> miss
                            else{
                                System.out.println("He missed!");
                            }
                            Thread.sleep(2000);
                            pg.printTable(tabb, jogadores, i);
                            
                        }
                    }
                }
            }
        }

        // if the players are in the same sector
        else{
            for(Virus virus : simpleSector.getEnemies()){
                if(simpleSector.haveEnemies() == 0 && jogadores[1].isAlive()){
                    if(virus.getDefensePower() > 0){
                        System.out.println("An enemy is preparing an attack...");
                        Thread.sleep(2000);
                        
                        r = rand.nextInt(6);
                        if(r % 2 == 0){
                            r = rand.nextInt(6);
                            virus.attack(jogadores[r % 2]);
                            if(r % 2 == 1)
                                System.out.println("The Support player has taken " + virus.getAttackPower() + " damage!");
                            
                            else
                                System.out.println("The Main player has taken " + virus.getAttackPower() + " damage");
                        }
                        else{
                            System.out.println("He missed!");
                        }
                        Thread.sleep(2000);
                        pg.printTable(tabb, jogadores, i);
                        	
                    }
                }
            }
        }

       }
        // if the main player is dead
        if(jogadores[0].isAlive() == false){
            System.out.println("############################################");
            System.out.println("## You lost! The Main player can't die! ##");
            System.out.println("############################################");
        }
        reader.close();
    }
}