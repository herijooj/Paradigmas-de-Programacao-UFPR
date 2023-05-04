package Board;

import java.util.Random; // to use random
import java.util.Scanner; // to read the map

import Entities.*;

public class Board{

  private Sector tab[][];

  // ----- Constructor -----
  public Board() {
    tab = new Sector[5][5];
    //String lvl = new String("N 0 1 0 1 N 0 0 1 1 N 0 1 1 1 N 0 0 1 1 N 0 1 1 0 N 1 0 0 1 N 0 0 1 0 N 1 1 0 1 P 0 0 1 0 N 1 1 0 0 N 0 1 0 1 N 0 1 1 1 N 1 1 1 1 N 0 0 1 1 N 1 0 1 0 N 1 1 0 0 N 1 1 0 0 N 1 1 0 0 N 0 1 0 0 N 0 1 0 0 N 1 0 0 0 N 1 0 0 0 N 1 0 0 1 N 1 0 1 1 N 1 0 1 0");
    String lvl = new String("N 0 1 0 1 O 0 0 1 1 N 0 1 1 1 N 0 0 1 1 P 0 1 1 0 N 1 0 0 1 O 0 0 1 0 N 1 1 0 1 P 0 0 1 0 N 1 1 0 0 O 0 1 0 1 N 0 1 1 1 N 1 1 1 1 O 0 0 1 1 N 1 0 1 0 P 1 1 0 0 P 1 1 0 0 N 1 1 0 0 O 0 1 0 0 O 0 1 0 0 O 1 0 0 0 P 1 0 0 0 N 1 0 0 1 O 1 0 1 1 O 1 0 1 0");
    Scanner reader = new Scanner(lvl);

    this.tab = new Sector[5][5];
    int u, d, l, r;
    char u_char, d_char, l_char, r_char;
    char type;
    Random rand = new Random();

    // two fors that represent the matrix
    for (int a = 0; a < 5; a++) {
      for (int b = 0; b < 5; b++) {
        type = 'N';
        if (reader.hasNext("N")) {        // normal
          type = reader.next().charAt(0);
        } else if (reader.hasNext("O")) { // ocult
          type = reader.next().charAt(0);
        } else if (reader.hasNext("P")) { // private
          type = reader.next().charAt(0);
        }

        u_char = reader.next().charAt(0);
        d_char = reader.next().charAt(0);
        l_char = reader.next().charAt(0);
        r_char = reader.next().charAt(0);

        u = Character.getNumericValue(u_char);
        d = Character.getNumericValue(d_char);
        l = Character.getNumericValue(l_char);
        r = Character.getNumericValue(r_char);

        if(type == 'N')
          tab[a][b] = new Sector(u, d, l, r);
        else if(type == 'O')
          tab[a][b] = new SectorOcult(u, d, l, r);
        else if(type == 'P')
          tab[a][b] = new SectorPrivate(u, d, l, r);
        // Generate random enemies
        if (a != 2 || b != 2)
          tab[a][b].generateEnemies(rand);
        else // if it is the center, set it to null
          tab[a][b].setEnemiesNULL();
      }
    }
    reader.close();

    // Generate the virus
    int lin = rand.nextInt(4);
    int col = rand.nextInt(4);
    if (lin == 2 && col == 2){
      lin = 1; col = 0;
    }
    else{
      tab[lin][col].setInfection();
      tab[lin][col].setEnemiesNULL();
    }
    tab[2][2].setPlayers(3);
    tab[2][2].visitSector();
  }

  // ----- Getters and setters -----

  // Returns the sector given the coordinate values [x,y]
  public Sector getSector(int x, int y) {
    return tab[x][y];
  }

  // Returns the sector given the position
  public Sector getSector(Player p) {
    return tab[p.getPosition().getX()][p.getPosition().getY()];
  }

  // Returns the enemy given the position
  public Virus getEnemy(Player p) {
    return tab[p.getPosition().getX()][p.getPosition().getY()].returnEnemy();
  }

  // ----- Methods -----

  // RNG for the virus turn
	public void virusTurn(Player p, Random generator){
		int r;
		for(Virus virus : getSector(p).getEnemies()){
    		if(virus.getDefensePower() > 0){
				r = generator.nextInt(6);
				if(r % 2 == 0){
					virus.attack(p);
					if(p instanceof SupPlayer){
						System.out.println("suport"); // i have no fucking idea what to do here
					}
					else
						System.out.println("simple"); // idk either
				}
				else{
					System.out.println("Miss!");    // i dont know what to do here either
				}
     		}	
    	}
 	 }

}
