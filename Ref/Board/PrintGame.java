package Board;

import Entities.*;

public class PrintGame {

    // ----- Methods -----

    // prints the board
    public void printBoard(Player s, Player sup, Board tab) {
        int ful;
        System.out.println("|---|---|---|---|---|");
        Sector a = tab.getSector(s), b = tab.getSector(sup);
        Sector temp = a;
        /* */
        for (int i = 0; i < 9; i++) {
            // l and r are the left and right sectors
            ful = i / 2;
            if (i % 2 == 0) {
                System.out.print("|");
                for (int j = 0; j < 5; j++) {
                    temp = tab.getSector(ful, j);
                    temp.printSector(ful, j);
                    if (temp.getPlayers() == 1 || temp.getPlayers() == 3){
                        a = temp;
                    }
                    if (temp.getPlayers() == 2 || temp.getPlayers() == 3){
                        b = temp;
                    }
                    if (temp.hasDoor('R') == 1 && (temp.isKnown() == true || tab.getSector(ful, j + 1).isKnown() == true)) {
                        System.out.print("*");
                    } else {
                        System.out.print("|");
                    }
                }

            } else {
                System.out.print("|");
                for (int j = 0; j < 5; j++) {
                    temp = tab.getSector(ful, j);
                    if (temp.getPlayers() == 1 || temp.getPlayers() == 3)
                        a = temp;
                    if (temp.getPlayers() == 2 || temp.getPlayers() == 3)
                        b = temp;
                    if (temp.hasDoor('D') == 1 && (tab.getSector(ful + 1, j).isKnown() == true || temp.isKnown() == true)) {
                        System.out.print("-*-|");
                    } else {
                        System.out.print("---|");
                    }
                }
                
                
            }
            if (a != b) {
                prinSet(a, i, s, 1);
                prinSet(b, i, sup, 2);
            } else {
                prinSet(a, i, s, sup);
            }
            System.out.println();
        }
        System.out.println("|---|---|---|---|---|");
    }

    // prints the sectors (the HUD)
    public void prinSet(Sector set, int lin, Player player, int P) {
        if (lin == 0 && P == 1) {
            System.out.print("      Sector [" + (player.getPosition().getX()+1) + "," + (player.getPosition().getY()+1) + "]");
        }if (lin == 0 && P == 2) {
            System.out.print("       Sector [" + (player.getPosition().getX()+1) + "," + (player.getPosition().getY()+1) + "]");
            
        } else if (lin == 2) {
            System.out.print("    |------");
            if (set.hasDoor('U') == 1)
                System.out.print("*");
            else
                System.out.print("-");
            System.out.print("------|");
        } else if (lin > 2 && lin < 6) {
            System.out.print("    ");
            if (lin == 5 && (set.hasDoor('L') == 1))
                System.out.print("*");
            else {
                System.out.print("|");
            }
            if (lin != 3)
                System.out.print("             ");
            else {
                
                if(set.hasInfection())
                    System.out.print("      X      ");
                
                else
                    set.printEnemies();

            }
            if (lin == 5 && (set.hasDoor('R') == 1))
                System.out.print("*");
            else {
                System.out.print("|");
            }
        } else if (lin == 6) {
            System.out.print("    |");
            if (P == 1) {
                System.out.print("  P1         |");
            } else if (P == 2) {
                System.out.print("         P2  |");
            }
        } else if (lin == 7) {
            System.out.print("    |");
            if (P == 1) {
                System.out.print("  " + player.getAttackPower() + "/" + player.getDefensePower() + "        |");
            } else {
                System.out.print("        " + player.getAttackPower() + "/" + player.getDefensePower() + "  |");
            }
        } else if (lin == 8) {
            System.out.print("    |------");
            if (set.hasDoor('D') == 1)
                System.out.print("*");
            else
                System.out.print("-");
            System.out.print("------|");
        }
    }

    // prints the sectors (the HUD)
    public void prinSet(Sector set, int lin, Player player, Player suporte) {
        if (lin == 0) {
            System.out.print("      Sector [" + (player.getPosition().getX()+1 )+ "," + (player.getPosition().getY()+1) + "]");
        } else if (lin == 2) {
            System.out.print("    |------");
            if (set.hasDoor('U') == 1)
                System.out.print("*");
            else
                System.out.print("-");
            System.out.print("------|");
        } else if (lin > 2 && lin < 6) {
            System.out.print("    ");
            if (lin == 5 && (set.hasDoor('L') == 1))
                System.out.print("*");
            else {
                System.out.print("|");
            }
            if (lin != 3)
                System.out.print("             ");
            else {
                if(set.hasInfection())
                    System.out.print("      X      ");
                
                else
                    set.printEnemies();
            }
            if (lin == 5 && (set.hasDoor('R') == 1))
                System.out.print("*");
            else {
                System.out.print("|");
            }
        } else if (lin == 6) {
            System.out.print("    |");
            System.out.print("  P1     P2  |");

        } else if (lin == 7) {
            System.out.print("    |");
            System.out.print("  " + player.getAttackPower() + "/" + player.getDefensePower());
            System.out.print("   " + suporte.getAttackPower() + "/" + suporte.getDefensePower() + "  |");

        } else if (lin == 8) {
            System.out.print("    |------");
            if (set.hasDoor('D') == 1)
                System.out.print("*");
            else
                System.out.print("-");
            System.out.print("------|");
        }
    }

    // Shows the possible actions
    public void showPossibleActions(Player p, Sector set) {
        if (set.haveEnemies() == 0) {
            System.out.print("(A) Attack ");
        }
        if (!(set instanceof SectorPrivate)) {
            System.out.print("(S) Search ");
        }
        if (p instanceof SupPlayer) {
            System.out.print("(H) Heal Defense ");
        }
        System.out.println();
    }

    // Prints the Header
    public void printHeader(int turn) {
        System.out.println("       [Turn " + turn + "]");
    }

    // Prints the Board
    public void printTable(Board tabb, Player[] p, int turno) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        printHeader(turno);
        printBoard(p[0], p[1], tabb);

    }

    // Prints the Sectors
    public void printSector(Player p, Sector set){
        System.out.print("|------");
        if(set.hasDoor('U') == 1){
            System.out.print("*");
        }
        else{
            System.out.print("-");
        }
        System.out.println("------|");

        System.out.print("|");
        set.printEnemies();
        System.out.println("|");

    }

    // Prints the Win Message
    public void printWinMessage(){
        System.out.println("#############################");
        System.out.println("## You have won the game ! ##");
        System.out.println("#############################");
    }

    // Prints the available directions
    public void availableDirections(Sector set){
        if(set.hasDoor('U') == 1){
            System.out.print("(U) Up ");
        }
        if(set.hasDoor('D') == 1){
            System.out.print("(D) Down ");
        }
        if(set.hasDoor('L') == 1){
            System.out.print("(L) Left ");
        }
        if(set.hasDoor('R') == 1){
            System.out.print("(R) Right ");
        }
        System.out.println();
    }
}